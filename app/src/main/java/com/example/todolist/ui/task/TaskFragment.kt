package com.example.todolist.ui.task

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.App
import com.example.todolist.R
import com.example.todolist.databinding.FragmentTasksBinding
import com.example.todolist.model.Task
import com.example.todolist.ui.task.adapter.TaskAdapter

class TaskFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    private val adapter = TaskAdapter(this::onClick, this::onLongClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addTasks()

        binding.recyclerView.adapter = adapter
    }

    private fun addTasks() {
        val list = App.db.taskDao().getAll()
        adapter.setTasks(list)
    }

    private fun onClick(task: Task) {
        findNavController().navigate(R.id.navigation_add, bundleOf(TASK_KEY to task))
    }

    private fun onLongClick(task: Task) {
        App.db.taskDao().delete(task)
        val alertDialogDelete = AlertDialog.Builder(requireContext())
        alertDialogDelete.setMessage("Are you sure to delete this task?")

        alertDialogDelete.setPositiveButton(getString(R.string.yes)) { _, _ ->
            App.db.taskDao().delete(task)
            addTasks()
        }

        alertDialogDelete.setNegativeButton(getString(R.string.no)) { dialog, _ ->
            dialog?.cancel()
        }
        alertDialogDelete.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TASK_KEY = "task"
    }
}