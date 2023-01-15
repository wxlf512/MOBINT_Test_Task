package dev.wxlf.mobint_test_task.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.wxlf.mobint_test_task.R
import dev.wxlf.mobint_test_task.data.entities.CardEntity
import dev.wxlf.mobint_test_task.databinding.CardItemBinding

class CardsAdapter(private val cards: List<CardEntity>) :
    RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    inner class CardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: CardEntity) {
            binding.cardinfo = card
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<CardItemBinding>(inflater, R.layout.card_item, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) =
        holder.bind(cards[position])

    override fun getItemCount(): Int = cards.size
}