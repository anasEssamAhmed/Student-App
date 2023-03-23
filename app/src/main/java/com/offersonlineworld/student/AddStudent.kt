package com.offersonlineworld.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.offersonlineworld.student.Database.database
import kotlinx.android.synthetic.main.activity_add_student.*
import kotlinx.android.synthetic.main.activity_add_student.view.*

class AddStudent : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        val i = database(this)
        val ID = inputID.text
        val name = inputFullname.text
        val address = inputAddress.text
        val birhdate = inputBirhdate.text
        val array = i.getFacultyName()
        var facultyText = ""
        val arrayAdapter = ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item , array)
        spinner_select_faculty.adapter = arrayAdapter
        spinner_select_faculty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
        btn_AddStudent.setOnClickListener {
            val i = i.insertStudent("$ID" , "$name" , "$address" , "$birhdate" , "$facultyText")
            if (i){
                Toast.makeText(this , "Add Successfully" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this , "Add Failed" , Toast.LENGTH_SHORT).show()
            }
        }



    }
}