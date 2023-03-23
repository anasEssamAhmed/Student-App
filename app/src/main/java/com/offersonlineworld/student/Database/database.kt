package com.offersonlineworld.student.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.offersonlineworld.student.model.*

class database(context: Context) : SQLiteOpenHelper(context,dbName,null,version ) {
    private var dataB:SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(log.create_table)
        db.execSQL(faculty.create_table)
        db.execSQL(student.cole_createTable)
        db.execSQL(course.create_table)
        db.execSQL(grade.createTable)
        db.execSQL(student_course.createTable)

    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS ${log.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${faculty.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${student.Table_name}")
        db.execSQL("DROP TABLE IF EXISTS ${course.TableName}")
        db.execSQL("DROP TABLE IF EXISTS ${grade.TableName}")
        db.execSQL("DROP TABLE IF EXISTS ${student_course.TableName}")

        onCreate(db)
    }
    // insert to table user
    fun insertInfo(fullName: String,email: String,password: String) : Boolean{
        val cv = ContentValues()
        cv.put(log.cole_fullName, fullName)
        cv.put(log.cole_email , email)
        cv.put(log.cole_password , password)
        val r =  dataB.insert(log.TABLE_NAME , null , cv)
        return r > 0
    }
    // insert to table Faculty
    fun insertFaculty(name : String , hour : String) : Boolean{
        val cv = ContentValues()
        cv.put(faculty.cole_Name, name)
        cv.put(faculty.cole_price , hour)
        val r =  dataB.insert(faculty.TABLE_NAME , null , cv)
        return r > 0
    }
    // insert to table student
    fun insertStudent(id: String, name: String, address: String, Birthdate: String, Faculty_name: String) : Boolean{
        val cv = ContentValues()
        cv.put(student.cole_id, id)
        cv.put(student.cole_name, name)
        cv.put(student.cole_address, address)
        cv.put(student.cole_birthdate, Birthdate)
        cv.put(student.cole_faculty_name, Faculty_name)
        val r =  dataB.insert(student.Table_name , null , cv)
        return r > 0
    }
    // insert to table course
    fun insertCourse(id : String , name: String , hour: String) : Boolean{
        val cv = ContentValues()
        cv.put(course.cole_id, id)
        cv.put(course.cole_name, name)
        cv.put(course.cole_hour, hour)
        val r =  dataB.insert(course.TableName , null , cv)
        return r > 0
    }
    // insert to table grade
    fun insertGrade(student_id : String , Semester : String ,yearOfSemester : String , gradeOfCourse  : String , course_name : String) : Boolean{
        val cv = ContentValues()
        cv.put(grade.cole_stuId, student_id)
        cv.put(grade.cole_semester, Semester)
        cv.put(grade.cole_yearOfSemester, yearOfSemester)
        cv.put(grade.cole_gradeOfCourse, gradeOfCourse)
        cv.put(grade.cole_course_name, course_name)
        val r =  dataB.insert(grade.TableName , null , cv)
        return r > 0
    }
    // insert to table student_course
    fun insertStudent_course(student_id : String , course_name : String, yearOfSemester : String , Semester : String , grade: String) : Boolean{
        val cv = ContentValues()
        cv.put(student_course.cole_student_id, student_id)
        cv.put(student_course.cole_course_id, course_name)
        cv.put(student_course.cole_year, yearOfSemester)
        cv.put(student_course.cole_semester, Semester)
        cv.put(student_course.cole_grade , grade)
        val r =  dataB.insert(student_course.TableName , null , cv)
        return r > 0
    }
    // get data to table student
    fun getDataStudent() : ArrayList<student>{
        var logInfo = ArrayList<student>()
        val c = dataB.rawQuery("select * from ${student.Table_name}" , null)
        c.moveToFirst()
        while (!c.isAfterLast){
            val s = student(c.getString(0),c.getString(1), c.getString(2) , c.getString(3), c.getString(4))
            logInfo.add(s)
            c.moveToNext()
        }
        c.close()
        return logInfo
    }
    // get data to table student_course
    fun getDataStudentCourse(ID: String) : ArrayList<student_course>{
        var logInfo = ArrayList<student_course>()
        val c = dataB.rawQuery("select * from ${student_course.TableName} where ${student_course.cole_student_id} = ?" , arrayOf(ID))
        c.moveToFirst()
        while (!c.isAfterLast){
            val s = student_course(c.getString(0),c.getString(1) , c.getString(2) , c.getString(3), c.getString(4))
            logInfo.add(s)
            c.moveToNext()
        }
        c.close()
        return logInfo
    }
    // delete student
    fun deleteStudent(id : String) : Boolean{
        return dataB.delete(student.Table_name , "${student.cole_id} = $id", null) > 0
    }
    fun deleteStudentCourse(id : String , course_name: String) : Boolean{
        return dataB.delete(student_course.TableName , "${student_course.cole_student_id} = ? and ${student_course.cole_course_id} = ?", arrayOf(id , course_name)) > 0
    }
    // update table student
    fun updateStudent(oldId: String , id : String , name : String , address : String , Birthdate : String , Faculty_name : String) : Boolean{
        val cv = ContentValues()
        cv.put(student.cole_id, id)
        cv.put(student.cole_name, name)
        cv.put(student.cole_address, address)
        cv.put(student.cole_birthdate, Birthdate)
        cv.put(student.cole_faculty_name, Faculty_name)
        return dataB.update(student.Table_name , cv , "${student.cole_id} = $oldId" , null ) > 0
    }
    fun UpdateStudenCourse(OldId: String ,student_id : String , courseName : String , year : String , semester : String ,grade : String) : Boolean{
        val cv = ContentValues()
        cv.put(student_course.cole_student_id , student_id)
        cv.put(student_course.cole_course_id , courseName)
        cv.put(student_course.cole_year , year)
        cv.put(student_course.cole_semester , semester)
        cv.put(student_course.cole_grade , grade)
        return dataB.update(student_course.TableName , cv , "${student_course.cole_student_id} = ? and ${student_course.cole_course_id} = ?" , arrayOf(OldId, courseName) ) > 0
    }
    // function to get the email from table user
    fun getEmail(email: String) : Boolean{
        var c = dataB.rawQuery("select * from ${log.TABLE_NAME} where ${log.cole_email} = ?", arrayOf(email))
        return c.count > 0
    }
    // function to get the email and password from table user
    fun getEmailPassword(email: String , password: String) : Boolean{
        var c = dataB.rawQuery("select * from ${log.TABLE_NAME} where ${log.cole_email} = ? and ${log.cole_password} = ?", arrayOf(email , password))
        return c.count > 0

    }
    // get faculty name only
    fun getFacultyName() : ArrayList<String>{
        var logInfo = ArrayList<String>()
        val c = dataB.rawQuery("select ${faculty.cole_Name} from ${faculty.TABLE_NAME}", null)
        c.moveToFirst()
        while (!c.isAfterLast){
            logInfo.add(c.getString(0))
            c.moveToNext()
        }
        c.close()
        return logInfo
    }
    // get course name only
    fun getcourse() : ArrayList<String>{
        var logInfo = ArrayList<String>()
        val c = dataB.rawQuery("select ${course.cole_name} from ${course.TableName}" , null)
        c.moveToFirst()
        while (!c.isAfterLast){
            logInfo.add(c.getString(0))
            c.moveToNext()
        }
        c.close()
        return logInfo
    }

    // get the ID and Course And Year And Semester
    fun getIDAndCourse(ID: String , Course: String , Year : String , Semester: String) : Boolean{
        var c = dataB.rawQuery("select * from ${student_course.TableName} where ${student_course.cole_student_id} = ? and ${student_course.cole_course_id} = ? and ${student_course.cole_year} = ? and ${student_course.cole_semester} = ?", arrayOf(ID , Course, Year , Semester))
        return c.count > 0

    }


    companion object{
        const val dbName = "StudentInfo5"
        const val version = 1
    }
}