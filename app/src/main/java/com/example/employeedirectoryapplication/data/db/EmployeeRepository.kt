package com.example.employeedirectoryapplication.data.db

import android.content.Context
import com.example.employeedirectoryapplication.model.DataModelItem

class EmployeeRepository(context: Context) {

    var db:EmployeeDao = EmployeeDatabase.getInstance(context)?.EmployeeDao()!!

    suspend fun getAll(): List<DataModelItem> {
        return db.getAll()
    }
    suspend fun insertAll(dataModelItem: ArrayList<DataModelItem>) {
        return db.insertAll(dataModelItem)
    }
}