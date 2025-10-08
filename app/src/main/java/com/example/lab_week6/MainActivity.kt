package com.example.lab_week6

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_week6.model.CatBreed
import com.example.lab_week6.model.CatModel
import com.example.lab_week6.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: androidx.recyclerview.widget.RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup adapter and layout manager
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Setup swipe to delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Set data
        catAdapter.setData(getCatList())
    }

    private fun getCatList(): List<CatModel> {
        return listOf(
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Fred",
                "Silent and deadly",
                "https://cdn2.thecatapi.com/images/7dj.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Wilma",
                "Cuddly assassin",
                "https://cdn2.thecatapi.com/images/egv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Curious George",
                "Award winning investigator",
                "https://cdn2.thecatapi.com/images/bar.jpg"
            ),
            // Tambahkan 7 data lagi untuk memenuhi 10 item (ASSIGNMENT)
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Tom",
                "Loves to sleep all day",
                "https://cdn2.thecatapi.com/images/1a2.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.BalineseJavanese,
                "Luna",
                "Very active and playful",
                "https://cdn2.thecatapi.com/images/3b4.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.ExoticShorthair,
                "Simba",
                "King of the house",
                "https://cdn2.thecatapi.com/images/5c6.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.AmericanCurl,
                "Misty",
                "Loves to cuddle",
                "https://cdn2.thecatapi.com/images/7d8.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Oscar",
                "Very curious about everything",
                "https://cdn2.thecatapi.com/images/9e0.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Bella",
                "Loves to eat and sleep",
                "https://cdn2.thecatapi.com/images/1f2.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Max",
                "Very friendly with everyone",
                "https://cdn2.thecatapi.com/images/3g4.jpg"
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}