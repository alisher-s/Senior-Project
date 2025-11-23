package com.example.seniorproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        val recycler = findViewById<RecyclerView>(R.id.eventsRecycler)

        recycler.layoutManager = GridLayoutManager(this, 2)

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

        recycler.adapter = EventAdapter(events)
    }
}
