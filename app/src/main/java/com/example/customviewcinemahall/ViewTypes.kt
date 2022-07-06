package com.example.customviewcinemahall

sealed class ViewTypes{
    data class Button(val place:Int,val types: TYPES)
//    data class Text(val textView: TextView)
//    data class Screen(val textView: TextView)
}
