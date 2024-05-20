package com.bumantra.myanimals

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumantra.myanimals.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionShare.setOnClickListener {
            shareText((binding.tvTitleAnimal.text.toString() + " : " + binding.tvDetailDescription.text.toString()) )
        }

        val dataAnimal = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_animal", Animal::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_animal")
        }

        if (dataAnimal != null) {
            Glide.with(this.baseContext)
                .load(dataAnimal.imgSrc)
                .into(binding.imgDetailAnimal)

            binding.tvTitleAnimal.text = dataAnimal.animal
            binding.tvDetailDesc.text = dataAnimal.animalDesc.substringBefore('.')
            binding.tvDetailDescription.text = dataAnimal.animalDesc
        }
    }

    private fun shareText(text: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Bagikan dengan")
        startActivity(shareIntent)
    }
}