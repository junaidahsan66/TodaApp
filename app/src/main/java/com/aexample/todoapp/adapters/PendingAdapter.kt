package com.aexample.todoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aexample.todoapp.databinding.ItemsBinding
import com.aexample.todoapp.models.ResponseModel

class PendingAdapter(val todoList: ArrayList<ResponseModel>,val context: Context?) : RecyclerView.Adapter<PendingAdapter.ViewHolder>() {
  inner  class ViewHolder(val binding:  ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(position: Int) {
            binding.apply {
                rbRadioButton.text = todoList[position].description
                tvDate.text = todoList[position].scheduledDate?.substring(7,9)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingAdapter.ViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PendingAdapter.ViewHolder, position: Int) {
        holder.bindItems(position)

    }

    override fun getItemCount(): Int {
       return todoList.size
    }
    interface OnClickListner{
        fun setOnClick(position: Int)
    }
}