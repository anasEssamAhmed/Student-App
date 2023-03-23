package com.offersonlineworld.student.model

data class student_course(var student_id : String , var courseName : String , var year : String , var semester : String , var grade : String) {
    companion object {
        const val TableName = "student_course"
        const val cole_student_id = "student_id"
        const val cole_course_id = "course_id"
        const val cole_year = "year"
        const val cole_semester = "semester"
        const val cole_grade = "grade"
        const val createTable = "create table $TableName ($cole_student_id Text not null," +
                "$cole_course_id Text not null," +
                "$cole_year Text not null," +
                "$cole_semester Text not null," +
                "$cole_grade Text not null," +
                "foreign key ($cole_student_id) references ${student.Table_name} (${student.cole_id})," +
                "foreign key ($cole_course_id) references ${course.TableName} (${course.cole_name}))"
    }
}