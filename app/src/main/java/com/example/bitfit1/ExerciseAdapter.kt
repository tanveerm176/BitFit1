package com.example.bitfit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private val exercises: List<DisplayExercise>) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val exerciseTitle: TextView
        val exerciseDuration: TextView
        val exerciseWeekday: TextView

        init {
            exerciseTitle=itemView.findViewById(R.id.exerciseTitle)
            exerciseDuration = itemView.findViewById(R.id.exerciseDuration)
            exerciseWeekday = itemView.findViewById(R.id.exerciseWeekday)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.exercise_fragment, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = exercises.get(position)

        holder.exerciseTitle.text=item.title
        holder.exerciseDuration.text = item.duration
        holder.exerciseWeekday.text = item.weekday
    }

    override fun getItemCount(): Int {
        return exercises.size
    }
}