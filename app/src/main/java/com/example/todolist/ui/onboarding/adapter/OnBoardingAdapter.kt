package com.example.todolist.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.todolist.databinding.ItemOnBoardingBinding
import com.example.todolist.model.OnBoarding

class OnBoardingAdapter : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding("https://img.freepik.com/free-vector/variety-time-objects-man-landing-page_52683-23310.jpg?w=740&t=st=1687245951~exp=1687246551~hmac=093f683a811d041374d09193f8b0e6df631b3d8648b6c7ba70aaada787038351", "Get things done.", "Just a click away from planning your tasks."),
        OnBoarding("https://img.freepik.com/free-vector/appointment-booking-with-smartphone_52683-39659.jpg?w=740&t=st=1687246064~exp=1687246664~hmac=9bd0c32d3ea6b8e06228fc566b4c9b75a0c43ae8e546c5493979473b36334d3b", "Get things done.", "Just a click away from planning your tasks."),
        OnBoarding("https://img.freepik.com/free-vector/appointment-booking-with-smartphone_23-2148591884.jpg?w=740&t=st=1687246141~exp=1687246741~hmac=2b33a60dc9c3abfce2efb87e5e3e44ae38ae1aaa99845c1f286166f5133c4a6f", "Get things done.", "Just a click away from planning your tasks."),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding : ItemOnBoardingBinding) : ViewHolder(binding.root){
        fun onBind(onBoarding: OnBoarding) = with(binding){
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            Glide.with(ivIcon).load(onBoarding.image).into(ivIcon)
        }
    }
}