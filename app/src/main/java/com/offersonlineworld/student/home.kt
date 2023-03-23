package com.offersonlineworld.student

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_add_course2.*
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Add_Students.setOnClickListener {
            val i = Intent(this , AddStudent :: class.java)
            startActivity(i)
        }
        show_Students.setOnClickListener {
            val i  = Intent(this , Rs_show_student :: class.java)
            startActivity(i)
        }
        add_faculty.setOnClickListener {
            val i  = Intent(this , AddFaculty :: class.java)
            startActivity(i)
        }
        Add_course.setOnClickListener {
            val i  = Intent(this , AddCourse2 :: class.java)
            startActivity(i)
        }
        add_grade.setOnClickListener {
            val i  = Intent(this , AddGrade :: class.java)
            startActivity(i)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.log_menu , menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure ?")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes") { _, _ -> finishAffinity() }
        builder.setNegativeButton("No"){_,_ -> }
        builder.create().show()
        return super.onOptionsItemSelected(item)
    }
}