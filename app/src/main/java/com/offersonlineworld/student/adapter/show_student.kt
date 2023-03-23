package com.offersonlineworld.student.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.offersonlineworld.student.*
import com.offersonlineworld.student.Database.database
import com.offersonlineworld.student.model.student
//import com.offersonlineworld.student.re_course_student
import kotlinx.android.synthetic.main.activity_addcourse.view.*
import kotlinx.android.synthetic.main.activity_edit_student.view.*
import kotlinx.android.synthetic.main.student_list.view.*

class show_student(var context: Context , var data : ArrayList<student>) : RecyclerView.Adapter<show_student.Holder>() {
    class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val studentName = itemView.text_student
        val address = itemView.text_address
        val DOB = itemView.text_dob
        val FacultyName  = itemView.text_facultyofstudent
        val courses   = itemView.btn_course
        val addCourse = itemView.btn_addCourse2
        val edit = itemView.btn_edit
        val delete = itemView.btn_delete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val root = LayoutInflater.from(context).inflate(R.layout.student_list , parent , false)
        return Holder(root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.studentName.text = data[position].name
        holder.address.text = data[position].address
        holder.DOB.text = data[position].Birthdate
        holder.FacultyName.text = data[position].Faculty_name
        holder.studentName.text = "${data[position].name} (${data[position].id})"
        val name2 = data[position].name.toString()

        holder.courses.setOnClickListener {
            val i = Intent(context , re_course_student :: class.java)
            i.putExtra("id" , data[position].id)
            context.startActivity(i)
        }

        holder.addCourse.setOnClickListener {
            val i = Intent(context , addcourse :: class.java)
            i.putExtra("id" , data[position].id)
            context.startActivity(i)
        }
        holder.edit.setOnClickListener {
            val i = Intent(context , EditStudent :: class.java)
            i.putExtra("id" , data[position].id)
            i.putExtra("name" , name2)
            i.putExtra("address" , holder.address.text)
            i.putExtra("Birthdate" , holder.DOB.text)
            context.startActivity(i)
        }
        // delete of the table
        holder.delete.setOnClickListener {
            val i = database(context)
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete Student")
            builder.setMessage("Are you sure to Delete Student?")
            builder.setCancelable(false)
            builder.setPositiveButton("Delete Student") { _, _ ->
                i.deleteStudent(data[position].id)
                val i = Intent(context , home :: class.java)
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