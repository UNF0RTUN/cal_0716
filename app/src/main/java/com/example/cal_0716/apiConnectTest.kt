package com.example.cal_0716

import android.util.Log
import android.widget.TextView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import kotlin.concurrent.thread

class apiConnectTest {

    fun conNNewsApi(tv1 : TextView,tv2 : TextView){
        var clientId : String = "0zg_m0vi6CARQJOB8CIL";
        var clientSecret : String = "4Ru4xNZLX3";

        var serachText : String = "";
        var text : String = tv1.text.toString();
        try {
            serachText = URLEncoder.encode(text,"UTF-8")
        } catch (ex: UnsupportedEncodingException){
            throw RuntimeException("인코딩 실패");
        }

        var apiURL : String = "https://openapi.naver.com/v1/search/news?query="+serachText+"&display=1&sort=date"; //json 결과
        //var apiURL : String = "https://openapi.naver.com/v1/search/news.xml?query="+serachText+"?sort=date"; //xml결과

        var headerMap = HashMap<String,String>()
        headerMap.put("X-Naver-Client-Id",clientId);
        headerMap.put("X-Naver-Client-Secret",clientSecret);

        //tv2.text = apiURL;
        var newsBody : String = getNews(apiURL,headerMap);

        tv2.text = newsBody
    }



    private fun getNews(apiUrl : String, header : HashMap<String,String>): String {
        val url = URL(apiUrl);
        val con = url.openConnection() as HttpURLConnection;
        var rlst : String = "";
        try {
            con.requestMethod = "GET"
            thread(start = true){
                if(con.responseCode == HttpURLConnection.HTTP_OK){
                    rlst = "성공!"
//                    var rederRlst = InputStreamReader(con.inputStream)
//                    var buffered = BufferedReader(rederRlst)
//
//                    val content = StringBuilder()
//                    while(true){
//                        val data = buffered.readLine() ?: break
//                        content.append(data)
//                    }
//                    buffered.close()
//                    con.disconnect()
//                    rlst = "${content}"
                } else {
                    rlst = "실패"
                }

            }//thread 종료
            return rlst;
        } catch (ex:IOException){
            //throw RuntimeException("URL연결 실패");
            return "연결실패";
        }

    }


}