package com.bulfa.animals.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulfa.animals.midterm.adapter.BlockedAnimalsAdapter
import com.bulfa.animals.midterm.adapter.UnBlockedAnimalsAdapter
import com.bulfa.animals.midterm.databinding.ActivityManageBlockBinding
import com.bulfa.animals.midterm.local.LocalStorage
import com.bulfa.animals.midterm.model.AnimalModel

class ManageBlockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManageBlockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBlockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val localStorage = LocalStorage(this)
        val data: ArrayList<AnimalModel> = ArrayList()
        binding.blockedAnimalRecyclerView.layoutManager = LinearLayoutManager(this)

        for(index in localStorage.animalList) {
            if (localStorage.animalIsBlocked(index.name.toString())) {
                data.add(AnimalModel(index.name, index.detail))
            }
        }

        binding.blockedAnimalRecyclerView.adapter = BlockedAnimalsAdapter(this, data)

        binding.backButton.setOnClickListener {
            startActivity(Intent(this, AnimalNamesActivity::class.java))
            finish()
        }

    }
}