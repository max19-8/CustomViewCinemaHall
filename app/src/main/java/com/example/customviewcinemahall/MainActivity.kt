package com.example.customviewcinemahall

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewcinemahall.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity(), PlaceClickListener {

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf(
        mutableListOf(0, 3, 2, 3),
        mutableListOf(2, 0, 3, 2),
        mutableListOf(0, 3, 3, 3),
        mutableListOf(1, 2, 3, 3),
    )


    private val adapterr = ScreenAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val grid = binding.recyclerVIew
        grid.apply {
            grid.layoutManager = GridLayoutManager(context, 4)
            //   setHasFixedSize(true)
            grid.adapter = adapterr
        }
    }

    override fun onClick(row: Int,col:Int, place: Int) {
        when (place) {
            TYPES.NOTHING.ordinal -> list[row][col] = TYPES.NOTHING.ordinal
            TYPES.DEFAULT.ordinal -> list[row][col] = TYPES.SELECTED.ordinal
            TYPES.SELECTED.ordinal -> list[row][col] = TYPES.DEFAULT.ordinal
            TYPES.BUSY.ordinal -> list[row][col] = TYPES.BUSY.ordinal
        }

        adapterr.notifyDataSetChanged()
        Toast.makeText(applicationContext, row.toString(), Toast.LENGTH_SHORT).show()
    }
}

//fun main() {
//    val list =
//        arrayListOf(
//            arrayListOf(1, 0, 0, 2,),
//            arrayListOf(1, 1, 1, 1,),
//            arrayListOf(1, 1, 1, ),
//            arrayListOf(1, 1),
//            arrayListOf(1, 1, 1, 3),
//            arrayListOf(1, 1, 1, 3),
//        )
//    println(list.)
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

