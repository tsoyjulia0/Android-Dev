package com.example.dodo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dodo.databinding.ActivityPizzaDetailBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        const val KEY_RESULT = "KeyResult"
        const val KEY_DESCRIPTION = "KeyDescription"
        const val KEY_PRICE = "KeyPrice"
        const val KEY_IMAGE_RES_ID = "KeyImageResId"
    }

    private lateinit var binding: ActivityPizzaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPizzaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(KEY_RESULT)
        val description = intent.getStringExtra(KEY_DESCRIPTION)
        val price = intent.getDoubleExtra(KEY_PRICE, 0.0)
        val imageResId = intent.getIntExtra(KEY_IMAGE_RES_ID, 0)

        binding.textViewNameDetail.text = name
        binding.textViewDescriptionDetail.text = description
        binding.textViewPriceDetail.text = price.toString()

        if (imageResId != 0) {
            binding.imageViewPizzaDetail.setImageResource(imageResId)
        }

        val addToCartButton: Button = findViewById(R.id.addToCartButton)
        addToCartButton.text = "Add to Cart for ${price.toString()} $"
        addToCartButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Pizza Added")
                .setMessage("$name added to cart.")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}
