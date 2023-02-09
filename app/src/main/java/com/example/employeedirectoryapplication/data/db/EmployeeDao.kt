package com.example.employeedirectoryapplication.data.db

import androidx.room.*
import com.example.employeedirectoryapplication.model.DataModelItem

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employee")
    suspend fun getAll():List<DataModelItem>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(dataModelItem: DataModelItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dataModelItem: ArrayList<DataModelItem>)

    @Delete
    suspend fun delete(dataModelItem: DataModelItem)
}

