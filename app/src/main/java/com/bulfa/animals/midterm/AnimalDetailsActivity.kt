package com.bulfa.animals.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bulfa.animals.midterm.constants.Values
import com.bulfa.animals.midterm.databinding.ActivityAnimalDetailsBinding
import com.bulfa.animals.midterm.local.LocalStorage

class AnimalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        val localStorage = LocalStorage(this)
        setContentView(binding.root)

        binding.animalName.text = intent.getStringExtra(Values.PARAM_NAME)
        binding.animalDetails.text  = intent.getStringExtra(Values.PARAM_DETAIL)

        binding.block.setOnClickListener {
            localStorage.blockAnimal(intent.getStringExtra(Values.PARAM_NAME).toString())
            startActivity(Intent(this, AnimalNamesActivity::class.java))
            finish()
        }

    }
}