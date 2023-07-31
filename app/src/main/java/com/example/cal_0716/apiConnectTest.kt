package com.example.cal_0716

import android.util.Log
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject
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
        //var apiURL : String = "https://openapi.naver.com/v1/search/news.xml?query="+serachText+"&sort=date"; //xml결과

        var headerMap = HashMap<String,String>()
        headerMap.put("X-Naver-Client-Id",clientId);
        headerMap.put("X-Naver-Client-Secret",clientSecret);

        getNews(apiURL,headerMap,tv2);
        //tv2.text = newsBody
    }



    private fun getNews(apiUrl : String, header : HashMap<String,String>, tv2 : TextView){
        //Log.d("result2","답2")
        val url = URL(apiUrl);
        val con = url.openConnection() as HttpURLConnection;
        var rlst : String = "";
        try {
            con.requestMethod = "GET"
            for((key,value) in header){
                con.setRequestProperty(key,value)
            }
            thread(start = true){
                //Log.d("thread",url.toString())
                if(con.responseCode == HttpURLConnection.HTTP_OK){
                    //Log.d("여기 어디",con.responseCode.toString())
                    //rlst = "성공!"
                    var rederRlst = InputStreamReader(con.inputStream)
                    var buffered = BufferedReader(rederRlst)

                    val content = StringBuilder()
                    while(true){
                        val data = buffered.readLine() ?: break
                        content.append(data)
                    }
                    buffered.close()
                    con.disconnect()
                    rlst = "${content}"
                    val testCont = JSONObject(content.toString())
                    //val title : String = testCont.getJSONObject("items").toString()
                    val arryCont = testCont.getJSONArray("items").toString()
                   // val  titlsCont = arryCont.get(0).toString()
                    Log.d("title",arryCont)
                    tv2.text = arryCont;
                } else {
                    //Log.d("여기 어디",con.responseCode.toString())
                    rlst = "실패"
                    tv2.text = rlst;
                }

            }//thread 종료
            Log.d("도착",rlst)

        } catch (ex:IOException){
            throw RuntimeException("URL연결 실패");

        }

    }


}