//package com.example.customviewcinemahall
//
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewbinding.ViewBinding
//
//abstract class BaseDataHolder<T>(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
//    abstract fun bind(items:T)
//}
//
//
//class HeaderViewHolder(private val binding: HeaderBinding): BaseDataHolder<String>(binding) {
//    override fun bind(items: String) {
//        binding.title.text = items
//    }
//}