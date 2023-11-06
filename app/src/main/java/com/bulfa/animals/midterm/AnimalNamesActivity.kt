package com.bulfa.animals.midterm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulfa.animals.midterm.adapter.UnBlockedAnimalsAdapter
import com.bulfa.animals.midterm.databinding.ActivityAnimalNamesBinding
import com.bulfa.animals.midterm.local.LocalStorage
import com.bulfa.animals.midterm.model.AnimalModel

class AnimalNamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalNamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val localStorage = LocalStorage(this)
        val data: ArrayList<AnimalModel> = ArrayList()
        binding.unBlockRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.manageButton.setOnClickListener {
            startActivity(Intent(this@AnimalNamesActivity, ManageBlockActivity::class.java))
            finish()
        }

        binding.loadDataImageButton.setOnClickListener {
            localStorage.saveAnimalData()
            startActivity(Intent(this@AnimalNamesActivity, AnimalNamesActivity::class.java))
            finish()
        }

        for(index in localStorage.animalList) {
            if (!localStorage.animalIsBlocked(index.name.toString())) {
                data.add(AnimalModel(index.name, index.detail))
            }
        }

        binding.unBlockRecyclerView.adapter = UnBlockedAnimalsAdapter(this, data)


    }
}