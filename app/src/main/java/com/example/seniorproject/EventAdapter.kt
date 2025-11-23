package com.example.seniorproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EventAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventImage: ImageView = itemView.findViewById(R.id.eventImage)
        val eventTitle: TextView = itemView.findViewById(R.id.eventTitle)
        val eventLocation: TextView = itemView.findViewById(R.id.eventLocation)
        val eventPrice: TextView = itemView.findViewById(R.id.eventPrice)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedEvent = events[position]
                    showEventDetailsDialog(itemView.context, clickedEvent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.eventImage.setImageResource(event.imageResId)
        holder.eventTitle.text = event.title
        holder.eventLocation.text = event.location
        holder.eventPrice.text = event.price
    }

    override fun getItemCount() = events.size

    private fun showEventDetailsDialog(context: Context, event: Event) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_event_details, null)

        val title = dialogView.findViewById<TextView>(R.id.dialogEventTitle)
        val date = dialogView.findViewById<TextView>(R.id.dialogEventDate)
        val location = dialogView.findViewById<TextView>(R.id.dialogEventLocation)
        val price = dialogView.findViewById<TextView>(R.id.dialogEventPrice)
        val description = dialogView.findViewById<TextView>(R.id.dialogEventDescription)

        title.text = event.title
        date.text = event.date
        location.text = event.location
        price.text = event.price
        description.text = event.description

        MaterialAlertDialogBuilder(context)
            .setView(dialogView)
            .setPositiveButton("Book Ticket") { dialog, _ ->
                Toast.makeText(context, "Booking for \"${event.title}\"...", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Close") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
