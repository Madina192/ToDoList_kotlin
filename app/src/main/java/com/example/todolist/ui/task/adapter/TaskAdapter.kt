package com.example.todolist.ui.task.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todolist.databinding.ItemTaskBinding
import com.example.todolist.model.Task

class TaskAdapter(val onClick : (Task) -> Unit, val onLongClick : (Task) -> Unit) : Adapter<TaskAdapter.TaskViewHolder>(){

    private val list = arrayListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setTasks(tasks : List<Task>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class TaskViewHolder(private val binding : ItemTaskBinding) : ViewHolder(binding.root){
        fun onBind(task: Task) = with(binding){
            tvTitle.text = task.title
            tvDesc.text = task.desc

            itemView.setOnClickListener {
                onClick(task)
            }

            itemView.setOnLongClickListener{
                onLongClick(task)
                false
            }

        }


    }
}