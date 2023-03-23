package com.offersonlineworld.student.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.offersonlineworld.student.Database.database
import com.offersonlineworld.student.R
import com.offersonlineworld.student.Rs_show_student
import com.offersonlineworld.student.model.student_course
import kotlinx.android.synthetic.main.student_courses.view.*

class course_student(var context: Context , var data : ArrayList<student_course>) : RecyclerView.Adapter<course_student.holder>() {
    class holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val course = itemView.course_name_student
        val Year = itemView.course_year
        val Semester = itemView.course_semester
        val grade = itemView.course_grade
        val delete = itemView.btn_delete2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val root = LayoutInflater.from(context).inflate(R.layout.student_courses , parent , false)
        return holder(root)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {

        holder.Year.text = data[position].year
        holder.grade.text = data[position].grade
        holder.Semester.text = data[position].semester
        holder.course.text = data[position].courseName
        holder.delete.setOnClickListener {
            val i = database(context)
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete Course")
            builder.setMessage("Are you sure to Delete Course to ID ${data[position].student_id}?")
            builder.setCancelable(false)
            builder.setPositiveButton("Delete Course") { _, _ ->
                i.deleteStudentCourse(data[position].student_id , data[position].courseName)
                val i = Intent(context , Rs_show_student :: class.java)
                context.startActivity(i)
            }
            builder.setNegativeButton("No Delete "){_,_ -> }
            builder.create().show()
        }

    }



    override fun getItemCount(): Int {
        return data.size
    }
}

