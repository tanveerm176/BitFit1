package com.example.bitfit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private val exercises: List<DisplayExercise>) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val exerciseTitle: TextView
        val exerciseDuration: TextView
        val exerciseWeekday: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            exerciseTitle=itemView.findViewById(R.id.exerciseTitle)
            exerciseDuration = itemView.findViewById(R.id.exerciseDuration)
            exerciseWeekday = itemView.findViewById(R.id.exerciseWeekday)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.exercise_fragment, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = exercises.get(position)
        // Set item views based on views and data model
        holder.exerciseTitle.text=item.title
        holder.exerciseDuration.text = item.duration
        holder.exerciseWeekday.text = item.weekday
    }

    override fun getItemCount(): Int {
        return exercises.size
    }
}