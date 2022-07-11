package com.example.customviewcinemahall

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewcinemahall.databinding.*


class ScreenAdapter(private val list : List<MutableList<Int>>,
                    private val placeClickListener: PlaceClickListener)
    :  RecyclerView.Adapter<BaseViewHolder<*,*>>() {

    private val columnSize = list[0].size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*,*>  {
        return  when(viewType) {
            ViewTypes.NOTHING.ordinal ->{
                val binding = PlaceNothingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                PlaceNothingViewHolder(binding)
            }
            ViewTypes.DEFAULT.ordinal -> {
                val binding = PlaceDefaultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                PlaceDefaultViewHolder(binding)
            }
            ViewTypes.SELECTED.ordinal -> {
                val binding = PlaceSelectedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                PlaceSelectedViewHolder(binding)
            }
            ViewTypes.BUSY.ordinal ->{
                val binding = PlaceBusyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                PlaceBusyViewHolder(binding)
            }
            ViewTypes.ROW.ordinal -> {
                val binding = RowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                RowViewHolder(binding)
            }
            else ->  throw IllegalArgumentException("The viewType value of  is not supported")
        }
        }
    override fun onBindViewHolder(holder: BaseViewHolder<*,*>, position: Int) {
             val row = position / columnSize
          val col = position % columnSize
        val place = list[row][col]

        when(holder){
            is PlaceNothingViewHolder ->{
                    holder.bind(place,col)
            }
            is PlaceDefaultViewHolder ->{
                holder.bind(place,col)
            }
            is PlaceSelectedViewHolder ->{
                holder.bind(place,col)
            }
            is PlaceBusyViewHolder ->{
                holder.bind(place,col)
            }
            is RowViewHolder -> {
                holder.bind(row.inc().toString(),col)
            }
        }
      //  holder.bind(place,position % list[0].size)
        holder.itemView.setOnClickListener {
            placeClickListener.onClick(row,col,place)
        }
       }

    override fun getItemViewType(position: Int): Int {
        return when(list[position /columnSize ][position % columnSize]){
             0  ->  ViewTypes.NOTHING.ordinal
             1  ->   ViewTypes.DEFAULT.ordinal
             2  ->  ViewTypes.SELECTED.ordinal
            3 -> ViewTypes.BUSY.ordinal
            else ->  ViewTypes.ROW.ordinal
        }
    }

    override fun getItemCount(): Int {
        return getSize(list)
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