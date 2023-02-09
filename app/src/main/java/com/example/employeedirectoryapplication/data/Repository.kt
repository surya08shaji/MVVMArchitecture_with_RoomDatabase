package com.example.employeedirectoryapplication.data

class Repository(private val apiInterface: ApiInterface){

    suspend fun getList() = apiInterface.getList()

}