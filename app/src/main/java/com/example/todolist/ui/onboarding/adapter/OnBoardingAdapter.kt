package com.example.todolist.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.todolist.databinding.ItemOnBoardingBinding
import com.example.todolist.model.OnBoarding

class OnBoardingAdapter(val onNextClick : () -> Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding("https://www.pngmart.com/files/Android-App-Development-PNG-Image.png", "Get things done.", "Just a click away from planning your tasks."),
        OnBoarding("https://www.goodday.work/site/assets/img/templates/manager-page/header@2x.png", "Get things done.", "Just a click away from planning your tasks."),
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
            viewNext.setOnClickListener {
                if(adapterPosition == list.lastIndex) {
                    onNextClick()
                }
            }
        }
    }
}