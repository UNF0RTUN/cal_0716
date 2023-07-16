package com.example.cal_0716

import android.view.View
import android.widget.Button
import java.lang.NumberFormatException
import java.math.BigDecimal

open class operate() {

       fun result(n1: String, n2: String, o: String): Any {

            try {
                val num1 = BigDecimal.valueOf(n1.toDouble());
                var num2 = BigDecimal.valueOf(0);
                if ("" != n2.toString()) {
                    num2 = BigDecimal.valueOf(n2.toDouble());
                }

                val oper = o.toString();
                var rlst = BigDecimal.valueOf(0);

                if (oper == "+") {
                    //rlst = num1 + num2;
                    rlst = num1.add(num2);
                } else if (oper == "-") {
                    rlst = num1 - num2;
                } else if (oper == "*") {
                    rlst = num1 * num2;
                } else if (oper == "/") {
                    rlst = num1 / num2;
                }

                return rlst;
            } catch (ex: NumberFormatException) {
                return 0;
            }

        }

}