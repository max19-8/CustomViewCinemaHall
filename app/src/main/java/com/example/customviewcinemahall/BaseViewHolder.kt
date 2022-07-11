package com.example.customviewcinemahall

import android.graphics.Color
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.customviewcinemahall.databinding.*

abstract class BaseViewHolder<T,P>(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item:T,position:P)
}

class RowViewHolder(binding: RowBinding): BaseViewHolder<String,Int>(binding) {
    private val row = binding.row
    override fun bind(item: String,position:Int) {
        row.text = "Row $item"
    }
}
  class PlaceNothingViewHolder(binding : PlaceNothingBinding) : BaseViewHolder<Int,Int>(binding){
      override  fun bind(item:Int,position: Int){
    }
}
class PlaceDefaultViewHolder(binding : PlaceDefaultBinding) : BaseViewHolder<Int,Int>(binding){
    private val button =  binding.place
    override  fun bind(item:Int,position: Int){
        button.text = position.toString()
    }
}
class PlaceSelectedViewHolder(binding : PlaceSelectedBinding) : BaseViewHolder<Int,Int>(binding){
    private val button =  binding.place
    override  fun bind(item:Int,position: Int){
        button.text = position.toString()
    }
}
class PlaceBusyViewHolder(binding : PlaceBusyBinding) : BaseViewHolder<Int,Int>(binding){
    private val button =  binding.place
    override  fun bind(item:Int,position: Int){
//        button.text = position.toString()
//        button.setTextColor(Color.BLACK)
    }
}