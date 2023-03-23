package com.offersonlineworld.student

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_add_student.*
import kotlinx.android.synthetic.main.activity_add_student.spinner_select_faculty
import kotlinx.android.synthetic.main.activity_edit_student.*

class EditStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)
        val i = database(this)
        val id = intent.getStringExtra("id")
        val name2 = intent.getStringExtra("name")
        val address2 = intent.getStringExtra("address")
        val Birthdate2 = intent.getStringExtra("Birthdate")
        // ------------------------
        inputName.setText("$name2")
        input_City.setText("$address2")
        input_DOB.setText("$Birthdate2")
        student_id2.text = id
        // -----------------------
        val old_Student = student_id2.text
        val array = i.getFacultyName()
        val name = inputName.text
        val adresse = input_City.text
        val DOB = input_DOB.text
        var facultyText = ""
        val arrayAdapter = ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item , array)
        spinner_spicaly.adapter = arrayAdapter
        spinner_spicaly.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                facultyText = array[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        btn_editStudent.setOnClickListener {
            val i = database(this)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("update to student")
            builder.setMessage("Are you sure to Update to ID ${old_Student}?")
            builder.setCancelable(false)
            builder.setPositiveButton("Update") { _, _ ->
                val i = i.updateStudent("$old_Student" , "$old_Student","$name" , "$adresse" , "$DOB" , "$facultyText")
                if (i){
                    Toast.makeText(this , "Update Successfully" , Toast.LENGTH_SHORT).show()
                    val s = Intent(this , home :: class.java)
                    startActivity(s)
                }else{
                    Toast.makeText(this , "Failed Update" , Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton("No Update "){_,_ -> }
            builder.create().show()
        }
    }
}