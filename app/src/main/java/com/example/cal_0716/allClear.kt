package com.example.cal_0716

import android.widget.TextView
import java.lang.NumberFormatException

class allClear {

    fun clear(tv2: TextView, tv1: TextView) {

        try {
            tv2.text = "";
            tv1.text = "";
        } catch (ex: NumberFormatException) {

        }

    }

}