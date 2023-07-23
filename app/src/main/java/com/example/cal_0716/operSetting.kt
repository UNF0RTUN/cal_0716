package com.example.cal_0716

import android.widget.Button
import android.widget.TextView
import java.lang.NumberFormatException
import java.math.BigDecimal

class operSetting {
    var btnOperString : String = "";
    var oper = operate();

    fun operSet(tv1 : TextView, tv2 : TextView, btnOper : Button) {

            var o = btnOper.text.toString();
            var num1 = tv1.text.toString()
            var num2 = tv2.text.toString()

            btnOperString = o;
            if(""==num1){
                tv1.text = tv2.text
                tv2.text = ""
                btnOperString = o;
            } else if(""==num2){
                btnOperString = o;
            } else {
                var rlst = oper.result(num1,num2,o);
                tv1.text = rlst.toString();
                tv2.text = ""
            }
    }
}