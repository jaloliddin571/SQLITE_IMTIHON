package com.example.sqlite_imtihon.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlite_imtihon.models.User

class MyDbHelper(context: Context): SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION),MyDbInterface {

    companion object {
        val DB_NAME = "db_name"
        val DB_VERSION = 1

        val USER_TABLE = "label_table"
        val USER_ID = "id"
        val USER_NAME = "name"
        val USER_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table $USER_TABLE($USER_ID integer not null primary key autoincrement unique ,$USER_NAME text not null ,$USER_DATE text not null )"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User) {
        val database=writableDatabase
        val contentValues= ContentValues()
        contentValues.put(USER_NAME,user.name)
        contentValues.put(USER_DATE,user.date)
        database.insert(USER_TABLE,null,contentValues)
        database.close()
    }

    override fun getAddUser(): ArrayList<User> {
        var list=ArrayList<User>()
        val query="select*from $USER_TABLE"
        val database=readableDatabase
        val cursor=database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                list.add(
                    User(
                        id = cursor.getInt(0),
                        name = cursor.getString(1),
                        date = cursor.getString(2),
                    )
                )
            }while (cursor.moveToNext())
        }
        return list
    }
}