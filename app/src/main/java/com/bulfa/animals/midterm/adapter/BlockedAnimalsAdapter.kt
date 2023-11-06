package com.bulfa.animals.midterm.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bulfa.animals.midterm.ManageBlockActivity
import com.bulfa.animals.midterm.databinding.BlockedAnimalsItemBinding
import com.bulfa.animals.midterm.local.LocalStorage
import com.bulfa.animals.midterm.model.AnimalModel

class BlockedAnimalsAdapter(private val activity: Activity, private val list: ArrayList<AnimalModel>) : RecyclerView.Adapter<BlockedAnimalsAdapter.ViewHolder>(){

    val localStorage = LocalStorage(activity)

    inner class ViewHolder(private val binding: BlockedAnimalsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (animal: AnimalModel){
            binding.nameTextView.text = animal.name
            binding.unblockButton.setOnClickListener {
                localStorage.unBlockAnimal(animal.name.toString())
                activity.startActivity(Intent(activity, ManageBlockActivity::class.java))
                activity.finish()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BlockedAnimalsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

}