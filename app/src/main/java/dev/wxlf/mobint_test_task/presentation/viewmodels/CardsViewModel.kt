package dev.wxlf.mobint_test_task.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.wxlf.mobint_test_task.data.entities.ErrorEntity
import dev.wxlf.mobint_test_task.domain.usecases.FetchAllCardsUseCase
import dev.wxlf.mobint_test_task.presentation.common.CardsEvent
import dev.wxlf.mobint_test_task.presentation.common.CardsViewState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val fetchAllCardsUseCase: FetchAllCardsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<CardsViewState>()
    val uiState : LiveData<CardsViewState> get() = _uiState

    init {
        obtainEvent(CardsEvent.LoadCardsEvent(offset = 0))
    }

    fun obtainEvent(event: CardsEvent) {
        when (event) {
            is CardsEvent.LoadCardsEvent -> {
                viewModelScope.launch {
                    _uiState.postValue(CardsViewState.LoadingState(offset = event.offset))
                    try {
                        val data = fetchAllCardsUseCase.execute(event.offset)
                        _uiState.postValue(CardsViewState.LoadedState(data, data.isEmpty()))
                    } catch (e: HttpException) {
                        if (e.code() == 400) {
                            val gson = GsonBuilder().create()
                            try {
                                val error = gson.fromJson(e.response()!!.errorBody()!!.string(), ErrorEntity::class.java)
                                _uiState.postValue(CardsViewState.ErrorState(statusCode = e.code(), message = error.message))
                            } catch (e: IOException) {
                                Log.e("IOException", e.localizedMessage.orEmpty())
                            }
                        } else {
                            _uiState.postValue(CardsViewState.ErrorState(statusCode = e.code()))
                        }
                    } catch (e: Exception) {
                        Log.e("Exception", e.localizedMessage.orEmpty())
                    }
                }
            }
        }
    }
}