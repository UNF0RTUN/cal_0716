package com.example.cal_0716

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oper = operate();
        val dot = decimalDot(); //소수점
        val btnNum = btnNum(); //숫자버튼
        val allC = allClear(); //화면 클리어
        val operSet = operSetting(); //연산자 세팅 및 연산자 계산
        val btnRlst = btnRlst(); //결과버튼

        var tv1 : TextView = findViewById(R.id.textViewList1)
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
        var tv3 : TextView = findViewById(R.id.textView3)

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
            allC.clear(tv2,tv1);
        }

        btnPl.setOnClickListener {
            operSet.operSet(tv1,tv2,btnPl);
        }

        btnMi.setOnClickListener {
            operSet.operSet(tv1,tv2,btnMi);
        }

        btnSr.setOnClickListener {
            operSet.operSet(tv1,tv2,btnSr);
        }

        btnSl.setOnClickListener {
            operSet.operSet(tv1,tv2,btnSl);
        }

        btnRslt.setOnClickListener {
            btnRlst.calRlst(tv1,tv2, operSet);
        }

        btnP.setOnClickListener {
           dot.decimalSet(tv2);
        }

        tv3.setOnClickListener {
            val intt = Intent(applicationContext , apiMainActivity::class.java)
            startActivity(intt);
        }

    }

}

