package com.aexample.todoapp.ui.main.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.aexample.todoapp.R
import com.aexample.todoapp.adapters.CompletedAdapter
import com.aexample.todoapp.adapters.PendingAdapter
import com.aexample.todoapp.databinding.TodayFragmentBinding
import com.aexample.todoapp.models.ResponseModel
import com.aexample.todoapp.ui.main.MainViewModel

class TodayFragment : Fragment() {
    private val model: MainViewModel by activityViewModels()
    lateinit var binding:TodayFragmentBinding
    val todoList = ArrayList<ResponseModel>()
    lateinit var pendingAdapter: PendingAdapter
    lateinit var completedAdapter: CompletedAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.today_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
        setUpObserver()

        model.getTodoList()
    }

    private fun setUpRecyclerView() {
        pendingAdapter = PendingAdapter(todoList,context)
        binding.rvPending.adapter = pendingAdapter
    }

    private fun setUpObserver() {
        model.todoList.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrEmpty()){
                todoList.addAll(it)
            }
        })
    }


}