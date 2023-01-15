package dev.wxlf.mobint_test_task.presentation.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dev.wxlf.mobint_test_task.data.entities.CardEntity
import dev.wxlf.mobint_test_task.databinding.FragmentCardsBinding
import dev.wxlf.mobint_test_task.presentation.adapters.CardsAdapter
import dev.wxlf.mobint_test_task.presentation.common.CardsEvent
import dev.wxlf.mobint_test_task.presentation.common.CardsViewState
import dev.wxlf.mobint_test_task.presentation.viewmodels.CardsViewModel


@AndroidEntryPoint
class CardsFragment : Fragment() {

    private val viewModel by viewModels<CardsViewModel>()

    private var _binding: FragmentCardsBinding? = null
    private val binding get() = _binding!!

    private val cardsList = mutableListOf<CardEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardsList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.cardsList.adapter = CardsAdapter(cardsList)

        viewModel.uiState.observe(viewLifecycleOwner) { viewState ->
            when(viewState) {
                is CardsViewState.LoadedState -> {
                    cardsList.addAll(viewState.data)
                    (binding.cardsList.adapter as CardsAdapter).notifyDataSetChanged()
                    binding.cardsList.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    binding.loadingText.visibility = View.GONE
                }
                is CardsViewState.LoadingState -> {
                    if(viewState.offset == 0) {
                        binding.cardsList.visibility = View.GONE
                    }
                    binding.progressBar.visibility = View.VISIBLE
                    binding.loadingText.visibility = View.VISIBLE
                }
            }
        }

        binding.cardsList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val adapter = recyclerView.adapter as CardsAdapter
                val position = layoutManager.findLastCompletelyVisibleItemPosition()

                if(position >= adapter.itemCount - 2)
                    viewModel.obtainEvent(CardsEvent.LoadCardsEvent(adapter.itemCount))
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}