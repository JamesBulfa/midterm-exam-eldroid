package com.bulfa.animals.midterm.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bulfa.animals.midterm.AnimalDetailsActivity
import com.bulfa.animals.midterm.constants.Values
import com.bulfa.animals.midterm.databinding.UnBlockedAnimalsItemBinding
import com.bulfa.animals.midterm.model.AnimalModel

class UnBlockedAnimalsAdapter(private val activity: Activity, private val list: ArrayList<AnimalModel>) : RecyclerView.Adapter<UnBlockedAnimalsAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: UnBlockedAnimalsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (animal: AnimalModel){
            binding.nameTextView.text = animal.name
            binding.animalRelativeLayout.setOnClickListener {
                val intent = Intent(activity, AnimalDetailsActivity::class.java)
                intent.putExtra(Values.PARAM_NAME, animal.name)
                intent.putExtra(Values.PARAM_DETAIL, animal.detail)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UnBlockedAnimalsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

}