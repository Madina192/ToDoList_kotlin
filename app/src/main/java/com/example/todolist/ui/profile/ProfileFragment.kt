package com.example.todolist.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.todolist.data.local.Pref
import com.example.todolist.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val pref : Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initName()
        initImage()
    }

    private fun initImage() {
        Glide.with(binding.profileImage).load(pref.getImage()).into(binding.profileImage)
        binding.profileImage.setOnClickListener{
            chooseImageContract.launch("image/*")
        }
    }

    private val chooseImageContract = registerForActivityResult(ActivityResultContracts.GetContent()) { img ->
        if(img != null){
            pref.setImage(img.toString())
            Glide.with(requireContext()).load(img).into(binding.profileImage)
        }
    }

    private fun initName() {
        binding.etName.setText(pref.getName())
        binding.btnSave.setOnClickListener{
            pref.setName(binding.etName.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}