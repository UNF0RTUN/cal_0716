package com.example.cal_0716

import android.widget.TextView
import java.lang.NumberFormatException

class btnRlst {

    var oper = operate();

    fun calRlst(tv1: TextView, tv2: TextView,opSet : operSetting) {

        var btnOper = opSet.btnOperString;
        var num1 = tv1.text.toString()
        var num2 = tv2.text.toString()
        if(""==num1||""==num2){
            //결과 없음
        } else {
            var rlst = oper.result(num1,num2,btnOper);
            tv1.text = rlst.toString();
            tv2.text = ""
        }

    }
}