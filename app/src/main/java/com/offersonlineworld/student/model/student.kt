package com.offersonlineworld.student.model

data class student(var id : String , var name : String , var address : String , var Birthdate : String , var Faculty_name : String ) {
    companion object {
        const val Table_name = "student"
        const val cole_id = "StudentID"
        const val cole_name = "name"
        const val cole_address = "address"
        const val cole_birthdate = "birthdate"
        const val cole_faculty_name = "faculty_name"
        const val cole_createTable = "create table $Table_name ($cole_id text primary key not null , " +
                "$cole_name Text not null," +
                "$cole_address Text not null," +
                "$cole_birthdate Text not null," +
                "$cole_faculty_name Text not null, " +
                "foreign key ($cole_faculty_name) references ${faculty.TABLE_NAME} (${faculty.cole_Name}))"
    }
}