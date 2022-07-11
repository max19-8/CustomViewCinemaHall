package com.example.customviewcinemahall

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.customviewcinemahall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PlaceClickListener {

    private lateinit var binding: ActivityMainBinding

    private val list = arrayListOf(
        mutableListOf(2, 3, 2,2),
        mutableListOf(1, 1, 3,2),
        mutableListOf(1, 3, 3,2),
        mutableListOf(1, 2, 3,2),
        mutableListOf(1, 1, 1,2),
        mutableListOf(1, 1, 1,2),
        mutableListOf(1, 1, 1,2),
    )

    private  lateinit var  adapterr:ScreenAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val grid = binding.recyclerVIew
        list.forEach {
            it.add(0,4)
            it.add(it.size,4)
        }
        val itemDecoration = ItemOffsetDecoration(this,R.dimen.item_offset)
      adapterr  = ScreenAdapter(list, this)
        grid.apply {
            layoutManager = GridLayoutManager(context, list[0].size)
            addItemDecoration(itemDecoration)
            adapter = adapterr
            Log.d("SIZE", list.size.toString())
        }
    }
    override fun onClick(row: Int, col: Int, place: Int) {
        when (place) {
            ViewTypes.NOTHING.ordinal -> list[row][col] = ViewTypes.NOTHING.ordinal
            ViewTypes.DEFAULT.ordinal -> list[row][col] = ViewTypes.SELECTED.ordinal
            ViewTypes.SELECTED.ordinal -> list[row][col] = ViewTypes.DEFAULT.ordinal
            ViewTypes.BUSY.ordinal -> list[row][col] = ViewTypes.BUSY.ordinal
        }
        adapterr.notifyDataSetChanged()
    }
}

//fun main() {
//    val list =
//        arrayListOf(
//            mutableListOf(1, 0, 0, 2,),
//            mutableListOf(1, 1, 1, 1,),
//            mutableListOf(1, 1, 1, ),
//            mutableListOf(1, 1),
//            mutableListOf(1, 1, 1, 3),
//            mutableListOf(1, 1, 1, 3),
//        )
//
//    list.forEach {
//        it.add(0,-2)
//        it.add(it.size,-2)
//    }
//    println(list)
//}
//
//private fun getColumn(list: List<MutableList<Int>>,row:Int):Int{
//    val listColumn = mutableListOf<Int>()
//    for (element in list) {
//        var count = 0
//        for (j in 0 until element.size) {
//            count++
//        }
//        listColumn.add(count)
//    }
//    println(listColumn.forEach {
//        println(it)
//    })
//    println(listColumn[row])
//    return listColumn[row]
//}

