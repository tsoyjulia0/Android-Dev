package com.example.dodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.databinding.ItemPizzaBinding
import com.example.dodo.model.Pizza

class PizzaAdapter(
    private val onPizzaClick: (Pizza) -> Unit
) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {
    private var pizzaList: List<Pizza> = emptyList()

    fun setData(pizzas: List<Pizza>) {
        pizzaList = pizzas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPizzaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.bind(pizza)
    }

    override fun getItemCount(): Int = pizzaList.size


    inner class ViewHolder(private val binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val pizza = pizzaList[position]
                    onPizzaClick(pizza)
                }
            }
        }

        fun bind(pizza: Pizza) {
            with(binding) {
                imageViewPizza.setImageResource(pizza.image)
                textViewName.text = pizza.name
                pizzaDescription.text = pizza.description
                pizzaPrice.text = pizza.price.toString()
            }
        }
    }
}
