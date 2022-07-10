package com.example.customviewcinemahall

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewcinemahall.databinding.PlaceBinding


class ScreenAdapter(private val list : ArrayList<MutableList<Int>>,
                    private val placeClickListener: PlaceClickListener)
    : RecyclerView.Adapter<ScreenAdapter.ScreenVIewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenVIewHolder {
         val binding = PlaceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ScreenVIewHolder(binding)
    }


    override fun onBindViewHolder(holder: ScreenVIewHolder, position: Int) {
             val row = position / 4
          val col = position % 4
        val place = list[row][col]
        holder.bind(place,position % 4) // TODO: было position % 4 - работало

        holder.itemView.setOnClickListener {
            placeClickListener.onClick(row,col,place)
        }
       }

    override fun getItemViewType(position: Int): Int {
        return when(list[position/4][position%4]){
             0  ->  TYPES.NOTHING.ordinal
             1  ->   TYPES.DEFAULT.ordinal
             2  ->  TYPES.SELECTED.ordinal
             else  ->  TYPES.BUSY.ordinal
        }
    }

    override fun getItemCount(): Int {
        return list.size * list.size
    }


  inner  class ScreenVIewHolder(binding : PlaceBinding)
        : RecyclerView.ViewHolder(binding.root){
      private val button =  binding.place
        fun bind(place:Int,position:Int){
            when (place) {
                0 ->{
                   button.isVisible = false
                }
                1 -> {
                   button.text = position.toString()
                    button.setBackgroundColor(Color.GRAY)
                }
                2-> {
                   button.text = position.toString()
                    button.setBackgroundColor(Color.GREEN)
                }
                3-> {
                    button.setBackgroundColor(Color.RED)
                }
            }

            println(place)
    }
}
}

private fun getSize(list: List<MutableList<Int>>):Int{
    var result = 0
    for (element in list) {
        var count = 0
        for (j in 0 until element.size) {
            count++
        }
        result += count
    }
    return result
}

private fun getColumn(list: List<MutableList<Int>>,row:Int):Int{
    val listColumn = mutableListOf<Int>()
    for (element in list) {
        var count = 0
        for (j in 0 until element.size) {
            count++
        }
        listColumn.add(count)
    }
    println(listColumn.forEach {
        println(it)
    })
    println(listColumn[row])
    return listColumn[row]
}