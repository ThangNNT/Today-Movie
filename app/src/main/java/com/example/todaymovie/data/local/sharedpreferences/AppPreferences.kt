package com.example.todaymovie.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.example.todaymovie.app.App
import com.google.gson.GsonBuilder


object AppPreferences {
    private const val REFERENCES_NAME = "AppPreferences"

    var preferences: SharedPreferences =
        App.getInstance().getSharedPreferences(REFERENCES_NAME, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = preferences.edit()


    /**
     * Saves object into the Preferences.
     *
     * @param `object` Object of model class (of type <T>) to save
     * @param key Key with which Shared preferences to
     **/
    fun putObject(`object`: Any?, key: String) {
        //Convert object to JSON String.
        try {
            val jsonString = GsonBuilder().create().toJson(`object`)
            //Save that String in SharedPreferences
            preferences.edit().putString(key, jsonString).apply()
        }catch (e:Throwable){}
    }

    fun clearPreference(key:String){
        preferences.edit().remove(key).apply()
    }

    /**
     * Used to retrieve object from the Preferences.
     *
     * @param key Shared Preference key with which object was saved.
     **/
    inline fun <reified T> getObject(key: String): T? {
        //We read JSON String which was saved.
        val value = preferences.getString(key, null)
        //JSON String was found which means object can be read.
        //We convert this JSON String to model object. Parameter "c" (of
        //type Class < T >" is used to cast.
        return try {
            GsonBuilder().create().fromJson(value, T::class.java)
        }catch (e:Throwable){
            null
        }
    }
}