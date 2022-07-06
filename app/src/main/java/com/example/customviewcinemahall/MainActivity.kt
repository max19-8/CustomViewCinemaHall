package com.example.customviewcinemahall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.customviewcinemahall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list =
            arrayListOf(
                arrayListOf(1, 0, 0, 2,),
                arrayListOf(1, 1, 1, 1,),
                arrayListOf(1, 1, 1, 1),
                arrayListOf(1, 1, 1, 3),
            )
        val grid = binding.recyclerVIew
        grid.layoutManager = GridLayoutManager(this, 4)

        val adapter = ScreenAdapter(list, object : PlaceClickListener{
            override fun onClick(row: Int, col:Int,place:Int) {
                when(place){
                    TYPES.DEFAULT.ordinal->  list[col][row] =  TYPES.SELECTED.ordinal
                    TYPES.SELECTED.ordinal ->  list[col][row] =  TYPES.DEFAULT.ordinal
                }
            }
        })
        grid.adapter = adapter
    }
}
