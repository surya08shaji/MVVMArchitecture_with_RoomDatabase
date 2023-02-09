package com.example.employeedirectoryapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.employeedirectoryapplication.data.Repository
import com.example.employeedirectoryapplication.data.db.DatabaseHelper
import com.example.employeedirectoryapplication.data.db.DatabaseHelperImpl
import com.example.employeedirectoryapplication.data.db.EmployeeDatabase
import com.example.employeedirectoryapplication.data.db.EmployeeRepository
import com.example.employeedirectoryapplication.model.DataModelItem
import kotlinx.coroutines.*

class MainViewModel(private val repository: Repository): ViewModel() {

    //,private val dbHelper: DatabaseHelper

    val errorMessage = MutableLiveData<String>()
    val employeeList = MutableLiveData<ArrayList<DataModelItem>>()
    val employeeListDB = MutableLiveData<ArrayList<DataModelItem>>()
    private var job: Job? = null
    val dbHelper: EmployeeDatabase? = null

    val dbRepository: EmployeeRepository? = null

    private val exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
    }


    fun getList(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getList()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    employeeList.postValue(response.body())



                    if (response.body() != null){

                        val list = arrayListOf<DataModelItem>()

                        response.body()?.let { list.addAll(it)
//                            dbHelper?.EmployeeDao()?.insertAll(list)
                            dbRepository?.insertAll(list)
                        }



//                        dbHelper?.insertAll(response.body()!!)
//
//                        val data = dbHelper?.EmployeeDao()?.getAll()
//                        val data = dbHelper?.getAll()

                        val data = dbRepository?.getAll()

                        employeeListDB.postValue(data as ArrayList<DataModelItem>?)
                    } else{
//                        onError("Error :${response.message()}")
                    }


                } else {
//                    onError("Error :${response.message()}")
                }
            }
        }
    }

//    private fun onError(message: String) {
//        errorMessage.value = message
//    }
}