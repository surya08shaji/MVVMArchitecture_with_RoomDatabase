package com.example.employeedirectoryapplication.model

import androidx.room.ColumnInfo

data class Company(
    @ColumnInfo(name = "bs") val bs: String?,
    @ColumnInfo(name = "catchPhrase") val catchPhrase: String?,
    @ColumnInfo(name = "name") val name: String?
)