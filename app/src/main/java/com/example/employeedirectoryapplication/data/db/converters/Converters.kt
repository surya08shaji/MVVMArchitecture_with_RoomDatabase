package com.example.employeedirectoryapplication.data.db.converters

import androidx.room.TypeConverter
import com.example.employeedirectoryapplication.model.Address
import com.example.employeedirectoryapplication.model.Company
import com.example.employeedirectoryapplication.model.DataModelItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class Converters {





    @TypeConverter
    fun fromAddress(value:Address):String{
        return "${value.city?:""},${value.street?:""},${value.suite?:""},${value.zipcode?:""}"
    }

    @TypeConverter
    fun toAddress(value: String):Address{
        val list= value.split(",")
        return Address(city = list[0], street = list[1],suite = list[2], zipcode = list[3])
    }


    @TypeConverter
    fun fromCompany(value:Company):String{
        return "${value.bs?:""},${value.catchPhrase?:""},${value.catchPhrase?:""}"
    }

    @TypeConverter
    fun toCompany(value: String):Company{
        val list= value.split(",")
        return Company(bs = list[0], catchPhrase = list[1],name = list[2])
    }
}







