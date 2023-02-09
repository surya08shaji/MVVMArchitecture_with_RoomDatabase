package com.example.employeedirectoryapplication.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedirectoryapplication.adapter.Adapter
import com.example.employeedirectoryapplication.data.ApiInterface
import com.example.employeedirectoryapplication.data.Repository
import com.example.employeedirectoryapplication.databinding.ActivityMainBinding
import com.example.employeedirectoryapplication.viewModel.MainViewModel
import com.example.employeedirectoryapplication.viewModelFactory.MainViewModelFactory

class MainActivity : AppCompatActivity(){

    private lateinit var viewModel: MainViewModel
    private val adapter = Adapter()
    private lateinit var binding: ActivityMainBinding

//    val dbHelper:DatabaseHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiInterface = ApiInterface.getInstance()
        val repository = Repository(apiInterface)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)

        viewModel.employeeList.observe(this) {
            adapter.setArtList(it)
//            dbHelper.insertAll(it)
        }
        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.getList()

        viewModel.employeeListDB.observe(this){
            adapter.setArtList(it)
        }

    }
}
