package dev.wxlf.mobint_test_task.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.wxlf.mobint_test_task.domain.usecases.FetchAllCardsIdealUseCase
import dev.wxlf.mobint_test_task.presentation.common.CardsEvent
import dev.wxlf.mobint_test_task.presentation.common.CardsViewState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val fetchAllCardsUseCase: FetchAllCardsIdealUseCase
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
                    val data = fetchAllCardsUseCase.execute(event.offset)
                    _uiState.postValue(CardsViewState.LoadedState(data))
                }
            }
        }
    }
}