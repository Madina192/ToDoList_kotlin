package com.example.todolist.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.App
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.model.Task
import com.example.todolist.ui.task.TaskFragment

class AddTaskFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var data : Task
    private var task : Task? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        task = arguments?.getSerializable(TaskFragment.TASK_KEY) as Task?

        if(task != null) {
            binding.etTitle.setText(task!!.title)
            binding.etDesc.setText(task!!.desc)
            binding.btnSaveTask.text = getString(R.string.update)
        } else {
            binding.btnSaveTask.text = getString(R.string.save)
        }

        handleClick()
    }

    private fun handleClick(){
        binding.btnSaveTask.setOnClickListener{
            data = Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString(),
            )
            if(binding.etTitle.text != null) {
                if (task != null) {
                    updateTask()
                } else {
                    saveTask()
                }
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "You can't save empty task", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun saveTask() {
        task = Task(data.id, data.title, data.desc)
        App.db.taskDao().insert(task!!)
    }

    private fun updateTask() {
        task!!.title = data.title
        task!!.desc = data.desc
        App.db.taskDao().update(task!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}