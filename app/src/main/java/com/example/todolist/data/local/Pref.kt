package com.example.todolist.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context : Context) {

    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun isUserSeen() : Boolean{
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveUserSeen(){
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun putBoolean(){
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun getName() : String{
        return pref.getString(USER_NAME, "").toString()
    }

    fun setName(name : String) {
        pref.edit().putString(USER_NAME, name).apply()
    }

    fun getImage() : String {
        return pref.getString(USER_IMAGE, "").toString()
    }

    fun setImage(image : String){
        pref.edit().putString(USER_IMAGE, image).apply()
    }
    companion object{
        const val PREF_NAME = "pref.name"
        const val SEEN_KEY = "seen.key"
        const val USER_NAME = "user.name"
        const val USER_IMAGE = "user.image"
    }
}