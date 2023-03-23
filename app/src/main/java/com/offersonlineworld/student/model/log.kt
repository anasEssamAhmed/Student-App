package com.offersonlineworld.student.model

data class log(var fullName : String, var email : String, var password : String) {
    companion object{
        const val TABLE_NAME = "user"
        const val cole_fullName = "fullName"
        const val cole_email = "email"
        const val cole_password = "password"
        const val create_table = "create table $TABLE_NAME ($cole_email Text PRIMARY KEY not null," +
                "$cole_fullName TEXT NOT NULL, $cole_password TEXT NOT NULL)"
    }
}