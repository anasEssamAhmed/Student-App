package com.offersonlineworld.student.model

data class faculty(var name : String , var price  : String) {
    companion object{
        const val TABLE_NAME = "Faculty"
        const val cole_Name = "name"
        const val cole_price = "price"
        const val create_table = "create table $TABLE_NAME ($cole_Name Text PRIMARY KEY not null," +
                "$cole_price Text NOT NULL)"
    }
}