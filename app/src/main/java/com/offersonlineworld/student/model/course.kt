package com.offersonlineworld.student.model

data class course(var id : String , var name:String , var hour : String) {
    companion object {
        const val TableName = "course"
        const val cole_id = "_id"
        const val cole_name = "name"
        const val cole_hour = "hour"
        const val create_table = "create table $TableName ($cole_id Text primary key not null," +
                "$cole_name Text not null," +
                "$cole_hour Text not null )"
    }
}