package com.example.seniorproject

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class CreateEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val halls = arrayOf("Main Hall", "Orange Hall", "Green Hall", "Blue Hall", "Cinema Hall")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, halls)

        val hallDropdown: AutoCompleteTextView = findViewById(R.id.inputHall)

        hallDropdown.setAdapter(adapter)
    }
}
