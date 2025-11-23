package com.example.seniorproject

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QueueActivity : AppCompatActivity() {

    private lateinit var queuePositionTextView: TextView
    private lateinit var queueProgressBar: ProgressBar
    private lateinit var queueStatusTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_queue)

        queuePositionTextView = findViewById(R.id.queuePosition)
        queueProgressBar = findViewById(R.id.queueProgressBar)
        queueStatusTextView = findViewById(R.id.queueStatusText)

        val yourPosition = 24
        val totalInQueue = 125

        setupQueueUI(yourPosition, totalInQueue)
    }

    private fun setupQueueUI(position: Int, total: Int) {
        queuePositionTextView.text = getOrdinalString(position)

        queueProgressBar.max = total
        queueProgressBar.progress = position

        queueStatusTextView.text = "$position / $total"
    }


    private fun getOrdinalString(number: Int): String {
        return when {
            number % 100 in 11..13 -> "${number}th"
            number % 10 == 1 -> "${number}st"
            number % 10 == 2 -> "${number}nd"
            number % 10 == 3 -> "${number}rd"
            else -> "${number}th"
        }
    }
}
