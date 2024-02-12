package com.example.dodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo.adapter.PizzaAdapter
import com.example.dodo.databinding.ActivityMainBinding
import com.example.dodo.model.Pizza
import com.example.dodo.model.PizzaDataSource


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PizzaAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button

    private var originalPizzaList: List<Pizza> = PizzaDataSource.pizzas
    private var filteredPizzaList: MutableList<Pizza> = originalPizzaList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        searchEditText = binding.editText
        searchButton = binding.actionButton

        adapter = PizzaAdapter { pizza ->
            handlePizzaClick(pizza)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setData(originalPizzaList)

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().trim()
            filterPizzas(query)
        }
    }

    private fun filterPizzas(query: String) {
        filteredPizzaList.clear()
        if (query.isEmpty()) {
            filteredPizzaList.addAll(originalPizzaList)
        } else {
            for (pizza in originalPizzaList) {
                if (pizza.name.contains(query, ignoreCase = true) ||
                    pizza.description.contains(query, ignoreCase = true)) {
                    filteredPizzaList.add(pizza)
                }
            }
        }
        adapter.setData(filteredPizzaList)
    }

    private fun handlePizzaClick(pizza: Pizza) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(SecondActivity.KEY_RESULT, pizza.name)
            putExtra(SecondActivity.KEY_DESCRIPTION, pizza.description)
            putExtra(SecondActivity.KEY_PRICE, pizza.price)
            putExtra(SecondActivity.KEY_IMAGE_RES_ID, pizza.image)
        }
        startActivity(intent)
    }
}
