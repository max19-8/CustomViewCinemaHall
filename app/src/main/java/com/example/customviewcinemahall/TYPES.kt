package com.example.customviewcinemahall

import android.graphics.Color

enum class TYPES(val color: Int) {
    NOTHING(Color.WHITE){},
    DEFAULT(Color.GRAY){},
    SELECTED(Color.GREEN){},
    BUSY(Color.RED){}
}