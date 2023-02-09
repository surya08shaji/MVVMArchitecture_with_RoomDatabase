package com.example.employeedirectoryapplication.data.db

import com.example.employeedirectoryapplication.model.DataModelItem


class DatabaseHelperImpl(private val employeeDatabase: EmployeeDatabase):DatabaseHelper {

    override suspend fun getAll(): List<DataModelItem> = employeeDatabase
        .EmployeeDao().getAll()

    override suspend fun insertAll(dataModelItem: ArrayList<DataModelItem>) = employeeDatabase
        .EmployeeDao().insertAll(dataModelItem)
}

