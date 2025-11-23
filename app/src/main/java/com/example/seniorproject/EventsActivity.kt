package com.example.seniorproject

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.seniorproject.databinding.ActivityEventsBinding

class EventsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eventsRecycler.layoutManager = GridLayoutManager(this, 2)

        val events = listOf(
            Event(R.drawable.img1, "Nomad Talks", "March 11 15:00", "Orange Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img2, "The Sound of Time", "April 6-7 5:30", "Main Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img3, "Robot", "November 25 19:00", "Cinema Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img4, "Shibuya", "November 7 19:00", "Main Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img5, "The Last Sunrise", "April 5 18:00", "Main Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img6, "Entrepreneurs Talk", "April 5 17:00", "Green Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img7, "Spider man: Into the Spider-verse", "September 19 18:00", "Cinema Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img8, "Takappar Gasyqtar", "November 13-15 14:00", "Orange Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img9, "Kazakh Music Evolution", "November 20-21 19:00", "Main Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img10, "Artrev", "November 16 19:00", "Cinema Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img11, "Spotify", "November 1 19:00", "Cinema Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img12, "Cozy Korpe", "October 22 17:00", "Ballroom Right", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img13, "Piano Workshop", "September 4 16:00", "Cinema Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
            Event(R.drawable.img14, "Общество Мертвых Мечт", "April 6 18:00", "Main Hall", "free", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in scelerisque sem. Mauris volutpat, dolor id interdum ullamcorper, risus dolor egestas lectus, sit amet mattis purus dui nec risus."),
        )

        val adapter = EventAdapter(events)
        binding.eventsRecycler.adapter = adapter


        adapter.onItemClick = { event ->
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_event_details)

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


            val imageView = dialog.findViewById<ImageView>(R.id.dialogEventImage)
            val titleView = dialog.findViewById<TextView>(R.id.dialogEventTitle)
            val dateView = dialog.findViewById<TextView>(R.id.dialogEventDate)
            val locationView = dialog.findViewById<TextView>(R.id.dialogEventLocation)
            val descriptionView = dialog.findViewById<TextView>(R.id.dialogEventDescription)

            val backButton = dialog.findViewById<Button>(R.id.backButton)
            val bookTicketButton = dialog.findViewById<Button>(R.id.bookTicketButton)

            backButton.setOnClickListener {
                dialog.dismiss()
            }

            bookTicketButton.setOnClickListener {
                val intent = Intent(this, QueueActivity::class.java)
                startActivity(intent)
            }

            imageView.setImageResource(event.imageResId)
            titleView.text = event.title
            dateView.text = event.date
            locationView.text = event.location
            descriptionView.text = event.description

            dialog.show()
        }

    }
}
