package com.offersonlineworld.student.model

data class grade(var student_id : String , var Semester : String , var yearOfSemester : String , var gradeOfCourse  : String , var course_name : String ) {
    companion object {
        const val TableName = "gradeStudent"
        const val cole_id = "Grade_ID"
        const val cole_stuId = "student_id"
        const val cole_semester = "semester"
        const val cole_yearOfSemester = "year_of_semester"
        const val cole_gradeOfCourse = "grade_of_course"
        const val cole_course_name = "course_name"
        const val createTable = "create table $TableName ($cole_id Integer primary key AUTOINCREMENT," +
                "$cole_stuId Text not null," +
                "$cole_semester text not null," +
                "$cole_yearOfSemester text not null," +
                "$cole_gradeOfCourse Text not null," +
                "$cole_course_name text not null," +
                "foreign key ($cole_stuId) references ${student.Table_name} (${student_course.cole_student_id})," +
                "foreign key ($cole_course_name) references ${course.TableName} (${student_course.cole_course_id}))"
    }
}