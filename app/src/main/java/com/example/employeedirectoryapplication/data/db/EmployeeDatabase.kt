package com.example.employeedirectoryapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.employeedirectoryapplication.data.db.converters.Converters
import com.example.employeedirectoryapplication.model.DataModelItem


@Database(entities = [DataModelItem::class], version = 1)
@TypeConverters(Converters::class)
 abstract class EmployeeDatabase : RoomDatabase() {
     abstract fun EmployeeDao() : EmployeeDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase? {
            if (INSTANCE == null) {
                synchronized(EmployeeDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        EmployeeDatabase::class.java, "employee.db").allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}


