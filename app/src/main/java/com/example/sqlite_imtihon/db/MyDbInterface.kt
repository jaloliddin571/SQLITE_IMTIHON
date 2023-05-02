package com.example.sqlite_imtihon.db

import com.example.sqlite_imtihon.models.User

interface MyDbInterface {
    fun addUser(user: User)
    fun getAddUser():ArrayList<User>
}