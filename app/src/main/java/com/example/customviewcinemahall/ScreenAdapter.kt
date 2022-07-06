package com.example.customviewcinemahall

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewcinemahall.databinding.PlaceBinding


class ScreenAdapter(private val list : List<MutableList<Int>>,
                    private val placeClickListener: PlaceClickListener)
    : RecyclerView.Adapter<ScreenAdapter.ScreenVIewHolder>() {

   private fun getRows(list: List<MutableList<Int>>):Int{
        var maxRowLength = 0
        for (i in list.indices) {
            if (maxRowLength < list[i].size) {
                maxRowLength = list[i].size
            }
        }
        return maxRowLength
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenVIewHolder {
        val binding = PlaceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ScreenVIewHolder(binding)
    }


    override fun onBindViewHolder(holder: ScreenVIewHolder, position: Int) {
             val row = position % getRows(list)
          val col = position / 4
        val place = list[col][row]
        holder.bind(place,position % 4)
        holder.itemView.setOnClickListener {
            placeClickListener.onClick(row ,col,place)
            notifyDataSetChanged()
        }
            }

//    override fun getItemViewType(position: Int): Int {
//        val row = position % getRows(list)
//        val col = position / 4
//        return  list[col][row]
//    }

    override fun getItemCount(): Int {
        return list.size * list.size
    }

  inner  class ScreenVIewHolder(private val binding : PlaceBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(place:Int,position:Int){
            when (place) {
               TYPES.NOTHING.ordinal  ->{
                    binding.place.isVisible = false
                }
                TYPES.DEFAULT.ordinal -> {
                    binding.place.text = position.toString()
                    binding.place.setBackgroundColor(TYPES.DEFAULT.color)
                }
                TYPES.SELECTED.ordinal -> {
                    binding.place.text = position.toString()
                    binding.place.setBackgroundColor(TYPES.SELECTED.color)
                }
                TYPES.BUSY.ordinal -> {
                    binding.place.setBackgroundColor(TYPES.BUSY.color)
                }
            }
    }
}
}