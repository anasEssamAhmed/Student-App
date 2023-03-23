package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.offersonlineworld.student.Database.database
import com.offersonlineworld.student.adapter.show_student
import kotlinx.android.synthetic.main.activity_rs_show_student.*

class Rs_show_student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rs_show_student)
        val i = database(this)
        val data = i.getDataStudent()
        val adapterStudent =  show_student(this , data)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapterStudent

    }
}