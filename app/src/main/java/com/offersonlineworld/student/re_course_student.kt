package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.offersonlineworld.student.Database.database
import com.offersonlineworld.student.adapter.course_student
import kotlinx.android.synthetic.main.activity_re_course_student.*

class re_course_student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_re_course_student)
        val id = intent.getStringExtra("id")
        id_student.text = "$id"
        val i = database(this)
        val data = i.getDataStudentCourse("$id")
        recay.layoutManager = LinearLayoutManager(this)
        val adapter = course_student(this, data)
        recay.adapter = adapter


    }
}

