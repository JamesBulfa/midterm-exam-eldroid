package com.bulfa.animals.midterm.local

import android.app.Activity
import android.content.Context
import com.bulfa.animals.midterm.constants.Values
import com.bulfa.animals.midterm.model.AnimalModel

class LocalStorage(private val activity: Activity) {

     val animalList = arrayListOf(
        AnimalModel("Armadillo", "Armadillos are small mammals with armored shells."),
        AnimalModel("Baboon", "Baboons are primates known for their distinctive faces."),
        AnimalModel("Cheetah", "Cheetahs are the fastest land animals, known for their speed and agility."),
        AnimalModel("Dolphin", "Dolphins are highly intelligent marine mammals known for their playful behavior."),
        AnimalModel("Elephant", "Elephants are the largest land animals and known for their long trunks."),
        AnimalModel("Fennec Fox", "Fennec foxes are small desert foxes with large ears."),
        AnimalModel("Gazelle", "Gazelles are graceful antelopes known for their speed."),
        AnimalModel("Hippopotamus", "Hippos are large, mostly herbivorous mammals found near water."),
        AnimalModel("Iguana", "Iguanas are reptiles known for their colorful scales."),
        AnimalModel("Jaguar", "Jaguars are big cats known for their powerful jaws."),
        AnimalModel("Kangaroo", "Kangaroos are marsupials known for their hopping locomotion."),
        AnimalModel("Lemur", "Lemurs are small, arboreal primates native to Madagascar."),
        AnimalModel("Meerkat", "Meerkats are small mammals known for their social behavior."),
        AnimalModel("Nightingale", "Nightingales are small birds known for their beautiful songs."),
        AnimalModel("Ocelot", "Ocelots are small wild cats with distinctive spotted coats."),
        AnimalModel("Pangolin", "Pangolins are mammals with protective keratin scales."),
        AnimalModel("Quokka", "Quokkas are small marsupials known for their friendly appearance."),
        AnimalModel("Red Panda", "Red pandas are small mammals with reddish fur."),
        AnimalModel("Sloth", "Sloths are slow-moving mammals known for their tree-dwelling lifestyle."),
        AnimalModel("Tiger", "Tigers are big cats known for their striped patterns."),
        AnimalModel("Uakari", "Uakaris are primates with bald faces and red faces."),
        AnimalModel("Vulture", "Vultures are scavenging birds known for their bald heads."),
        AnimalModel("Wallaby", "Wallabies are small marsupials similar to kangaroos."),
        AnimalModel("X-ray Tetra", "X-ray Tetras are small fish with transparent bodies."),
        AnimalModel("Yak", "Yaks are domesticated bovids native to the Himalayas."),
        AnimalModel("Zebra", "Zebras are known for their black and white stripes.")
    )

    private val sharedPreferences = activity.getSharedPreferences(Values.PARAM_STORAGE_NAME, Context.MODE_PRIVATE)

    fun saveAnimalData() {
        with(sharedPreferences.edit()) {
            for (animal in animalList) {
                putString(animal.name, animal.detail)
                apply()
            }
        }
    }

    fun animalIsBlocked(name: String): Boolean {
        if(sharedPreferences.getString(name, "").toString() == "blocked") {
            return true
        }
        return false
    }

    fun blockAnimal(name: String) {
        with(sharedPreferences.edit()) {
            for (animal in animalList) {
                if(animal.name == name) {
                    putString(animal.name, "blocked")
                    apply()
                }
            }
        }
    }

    fun unBlockAnimal(name: String) {
        with(sharedPreferences.edit()) {
            for (animal in animalList) {
                if(animal.name == name) {
                    putString(animal.name, animal.detail)
                    putString("LOCAL_STORAGE", "LOCAL STORAGE EXIST")
                    apply()
                }
            }
        }
    }

}