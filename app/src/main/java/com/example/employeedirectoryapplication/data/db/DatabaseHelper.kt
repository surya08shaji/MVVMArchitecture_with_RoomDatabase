package com.example.employeedirectoryapplication.data.db

import com.example.employeedirectoryapplication.model.DataModelItem

interface DatabaseHelper {

    suspend fun getAll(): List<DataModelItem>

    suspend fun insertAll(dataModelItem: ArrayList<DataModelItem>)
}