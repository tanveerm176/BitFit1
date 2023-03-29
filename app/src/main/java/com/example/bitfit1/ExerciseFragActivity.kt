package com.example.bitfit1

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseFragActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_detail)

        val exerciseTitle = findViewById<TextView>(R.id.inptExerTitle)
        val exerciseDuration = findViewById<TextView>(R.id.inptExerDuration)
        val exerciseWeekday = findViewById<TextView>(R.id.inptExerWeekday)
        val exerciseSubmit = findViewById<Button>(R.id.submitExerBtn)

        exerciseSubmit.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                (application as ExerciseApplication).db.exerciseDao().insert(
                    ExerciseEntity(
                        title = exerciseTitle.text.toString(),
                        duration = exerciseDuration.text.toString(),
                        weekday = exerciseWeekday.text.toString(),
                    )
                )
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
