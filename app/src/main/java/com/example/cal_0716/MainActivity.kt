package com.example.cal_0716

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oper = operate();
        val dot = decimalDot();
        val btnNum = btnNum();

        var tv1 : TextView = findViewById(R.id.textView1)
        var tv2 : TextView = findViewById(R.id.textView2)
        var btn0 : Button = findViewById(R.id.button0)
        var btn1 : Button = findViewById(R.id.button1)
        var btn2 : Button = findViewById(R.id.button2)
        var btn3 : Button = findViewById(R.id.button3)
        var btn4 : Button = findViewById(R.id.button4)
        var btn5 : Button = findViewById(R.id.button5)
        var btn6 : Button = findViewById(R.id.button6)
        var btn7 : Button = findViewById(R.id.button7)
        var btn8 : Button = findViewById(R.id.button8)
        var btn9 : Button = findViewById(R.id.button9)
        var btnC : Button = findViewById(R.id.buttonC)
        var btnPl : Button = findViewById(R.id.buttonPl)
        var btnMi : Button = findViewById(R.id.buttonMi)
        var btnSr : Button = findViewById(R.id.buttonSr)
        var btnSl : Button = findViewById(R.id.buttonSl)
        var btnRslt : Button = findViewById(R.id.btnResult)
        var btnP : Button = findViewById(R.id.buttonP)

        var btnOper : String = "";

        btn0.setOnClickListener {
//            if(""==tv2.text.toString() || "0"==tv2.text.toString()){
//               tv2.text = "0"
//            }else{
//               var setTv2 = tv2.text.toString()+ "0"
//                tv2.text = setTv2
//            }
            btnNum.btnNumSet(tv2,"0");
        }

        btn1.setOnClickListener {
            btnNum.btnNumSet(tv2,"1");
        }

        btn2.setOnClickListener {
            btnNum.btnNumSet(tv2,"2");
        }

        btn3.setOnClickListener {
            btnNum.btnNumSet(tv2,"3");
        }

        btn4.setOnClickListener {
            btnNum.btnNumSet(tv2,"4");
        }

        btn5.setOnClickListener {
            btnNum.btnNumSet(tv2,"5");
        }

        btn6.setOnClickListener {
            btnNum.btnNumSet(tv2,"6");
        }

        btn7.setOnClickListener {
            btnNum.btnNumSet(tv2,"7");
        }

        btn8.setOnClickListener {
            btnNum.btnNumSet(tv2,"8");
        }

        btn9.setOnClickListener {
            btnNum.btnNumSet(tv2,"9");
        }

        btnC.setOnClickListener {
            tv2.text = ""
            tv1.text = ""
        }

        btnPl.setOnClickListener {
            var plus = "+"
            var num1 = tv1.text.toString()
            var num2 = tv2.text.toString()
            if(""==num1){
                tv1.text = tv2.text
                tv2.text = ""
                btnOper = "+";
            } else if(""==num2){
                btnOper = "+";
            } else {
                var rlst = oper.result(num1,num2,plus);
                tv1.text = rlst.toString();
                tv2.text = ""
            }
        }

        btnMi.setOnClickListener {
            var minus = "-"
            var num1 = tv1.text.toString()
            var num2 = tv2.text.toString()
            if(""==num1){
                tv1.text = tv2.text
                tv2.text = ""
                btnOper = "-";
            } else if(""==num2){
                btnOper = "-";
            } else {
                var rlst = oper.result(num1,num2,minus);
                tv1.text = rlst.toString();
                tv2.text = ""
            }
        }

        btnSr.setOnClickListener {
            var star = "*"
            var num1 = tv1.text.toString()
            var num2 = tv2.text.toString()
            if(""==num1){
                tv1.text = tv2.text
                tv2.text = ""
                btnOper = "*";
            } else if(""==num2){
                btnOper = "*";
            } else {
                var rlst = oper.result(num1,num2,star);
                tv1.text = rlst.toString();
                tv2.text = ""
            }
        }

        btnSl.setOnClickListener {
            var slash = "/"
            var num1 = tv1.text.toString()
            var num2 = tv2.text.toString()
            if(""==num1){
                tv1.text = tv2.text
                tv2.text = ""
                btnOper = "/";
            } else if(""==num2){
                btnOper = "/";
            } else {
                var rlst = oper.result(num1,num2,slash);
                tv1.text = rlst.toString();
                tv2.text = ""
            }
        }

        btnRslt.setOnClickListener {
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

        btnP.setOnClickListener {
           dot.decimalSet(tv2);
        }

    }

}

