package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val exercises = mutableListOf<DisplayExercise>()
    private lateinit var exerciseRv : RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addtoList = findViewById<Button>(R.id.addExerciseBtn)

        exerciseRv = findViewById(R.id.exercises)

        val exerciseAdapter = ExerciseAdapter(exercises)
        exerciseRv.adapter = exerciseAdapter

        exerciseRv.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            exerciseRv.addItemDecoration(dividerItemDecoration)
        }

        lifecycleScope.launch{
            (application as ExerciseApplication).db.exerciseDao().getAll().collect{ databaseList ->
                databaseList.map{ entity ->
                    DisplayExercise(
                        entity.title,
                        entity.duration,
                        entity.weekday
                    )
            }.also { mappedList->
                exercises.clear()
                exercises.addAll(mappedList)
                exerciseAdapter.notifyDataSetChanged()
            }
            }
        }

        addtoList.setOnClickListener {
            val intent = Intent(this, ExerciseFragActivity::class.java)
            startActivity(intent)
        }
    }


}