package com.bumantra.myanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumantra.myanimals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Animal>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page) {
            val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
            startActivity(moveIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAnimals.setHasFixedSize(true)
        list.addAll(getListAnimals())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        val listAnimalAdapter = ListAnimalAdapter(list)
        binding.rvAnimals.adapter = listAnimalAdapter
        binding.rvAnimals.layoutManager = LinearLayoutManager(this)
    }

    private fun getListAnimals(): ArrayList<Animal> {
        val animalName = resources.getStringArray(R.array.animal_names)
        val animalDesc = resources.getStringArray(R.array.animal_descriptions)
        val animalImg = resources.getStringArray(R.array.animal_images)
        val listAnimal = ArrayList<Animal>()
        for(i in animalName.indices) {
            val animal = Animal(animalName[i],animalDesc[i],animalImg[i])
            listAnimal.add(animal)
        }
        return listAnimal
    }
}