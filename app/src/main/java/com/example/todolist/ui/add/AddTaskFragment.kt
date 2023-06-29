package com.example.todolist.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.model.Task

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

        handleClick()
    }

    private fun handleClick(){
        binding.btnSaveTask.setOnClickListener{
            data = Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString(),
            )
            if (task != null) {
                updateTask()
            } else {
                saveTask()
            }
            findNavController().navigateUp()
        }
    }

    private fun saveTask() {
        TODO("Not yet implemented")
    }

    private fun updateTask() {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}