package com.example.cal_0716

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class apiMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_main)

        var apiAct = apiConnectTest();

        var btnCon : Button = findViewById(R.id.ButtonCon);
        var tv1 : TextView = findViewById(R.id.textView_search)
        var tv2 : TextView = findViewById(R.id.textView_Rlst)
        var btnBk : Button = findViewById(R.id.buttonBack);

        btnCon.setOnClickListener{
            apiAct.conNNewsApi(tv1, tv2);
        }

        btnBk.setOnClickListener{
            val intt = Intent(this,MainActivity::class.java);
            startActivity(intt);
        }
    }

}