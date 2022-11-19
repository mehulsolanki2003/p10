package com.example.p10

import android.app.Person
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.RecyclerView
import com.example.p10.databinding.ActivityHttpRequestBinding.inflate
import kotlin.io.Serializable as KotlinIoSerializable

class PersonAdapter (private val context: Context, private val array:ArrayList<Person>):
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(val binding: PersonItemViewBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        with(holder){
            with(array[position]){
                binding.textViewPhoneNo.text = this.javaClass
                binding.textViewName.text = this.javaClass
                binding.textViewEmail.text = this.javaClass
                binding.textViewAddress.text = this.javaClass
                val obj = this as KotlinIoSerializable
                binding.buttonMap.setOnClickListener {
                    Intent(this@PersonAdapter.context, MapsActivity::class.java).apply {
                        putExtra("Object",obj)
                        this@PersonAdapter.context.startActivity(this)
                    }
                }
            }
        }
    }

    private fun putExtra(s: String, obj: KotlinIoSerializable) {

    }

    override fun getItemCount(): Int {
        return array.size
    }
}