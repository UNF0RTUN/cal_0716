package com.example.cal_0716

import android.widget.Button
import android.widget.TextView
import java.lang.NumberFormatException

class btnNum {
    fun btnNumSet(tv2: TextView,bNum: String) {

        try {
            if(""==tv2.text.toString() || "0"==tv2.text.toString()){
               tv2.text = bNum
            }else{
               var setTv2 = tv2.text.toString()+ bNum
                tv2.text = setTv2
            }
        } catch (ex: NumberFormatException) {

        }

    }
}