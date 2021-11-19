package com.surendra.jd_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ExpandableListView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.surendra.jd_test.R
import com.surendra.jd_test.databinding.ActivityMainBinding
import com.surendra.jd_test.model.Child
import com.surendra.jd_test.viewmodel.NavViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.HashMap

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var expandableListView: ExpandableListView
    private lateinit var navViewModel: NavViewModel;
    private lateinit var navAdapter: NavAdapter

    private val viewModel: NavViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar?.title = "Shop"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        lifecycleScope.launchWhenStarted {
            withContext(Dispatchers.IO) {
                viewModel.getAllImages()
            }
        }
        viewModel.responseNavData.observe(this, { response ->
            if (response != null) {
                val navList = response.nav

                val hashMap = HashMap<String, List<Child>>()
                for(data in navList) {
                    if(data.children!=null) {
                        hashMap[data.name] = data.children
                    }
                }
                navAdapter = NavAdapter(this, navList, hashMap)
                binding.expendableList.apply {
                    setAdapter(navAdapter)
                }
            } else {
                Log.e("MainActivity", "Response Null")
            }
        })


    }

    private fun <T> list(): List<String> {
        TODO("Not yet implemented")
    }
}