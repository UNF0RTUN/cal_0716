package com.example.cal_0716

import android.widget.TextView
import java.lang.NumberFormatException

class decimalDot {
    fun decimalSet(tv2: TextView) {

        try {
            if(""==tv2.text.toString() || "0"==tv2.text.toString()){
                tv2.text = "0."
            }else{
                var setTv2 = tv2.text.toString()+ "."
                tv2.text = setTv2
            }
        } catch (ex: NumberFormatException) {

        }

    }
}