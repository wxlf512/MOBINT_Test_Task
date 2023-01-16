package dev.wxlf.mobint_test_task.presentation.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.wxlf.mobint_test_task.R
import dev.wxlf.mobint_test_task.data.entities.CardEntity
import dev.wxlf.mobint_test_task.databinding.CardItemBinding

class CardsAdapter(private val cards: List<CardEntity>, var finished: Boolean) :
    RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    inner class CardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: CardEntity, position: Int) {
            binding.cardinfo = card
            binding.executePendingBindings()

            if (position == cards.lastIndex && !finished) {
                binding.loading.visibility = View.VISIBLE
            } else {
                binding.loading.visibility = View.GONE
            }

            binding.eyeButton.setOnClickListener {
                val builder = AlertDialog.Builder(it.context)
                with(builder)
                {
                    setTitle("Клик")
                    setMessage("Нажата кнопка глаза, ид компании: ${card.company.companyId}")
                    setPositiveButton("OK", null)
                    show()
                }
            }
            binding.trashButton.setOnClickListener {
                val builder = AlertDialog.Builder(it.context)
                with(builder)
                {
                    setTitle("Клик")
                    setMessage("Нажата кнопка мусорки, ид компании: ${card.company.companyId}")
                    setPositiveButton("OK", null)
                    show()
                }
            }
            binding.moreButton.setOnClickListener {
                val builder = AlertDialog.Builder(it.context)
                with(builder)
                {
                    setTitle("Клик")
                    setMessage("Нажата кнопка \"Подробнее\", ид компании: ${card.company.companyId}")
                    setPositiveButton("OK", null)
                    show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<CardItemBinding>(inflater, R.layout.card_item, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) =
        holder.bind(cards[position], position)

    override fun getItemCount(): Int = cards.size
}