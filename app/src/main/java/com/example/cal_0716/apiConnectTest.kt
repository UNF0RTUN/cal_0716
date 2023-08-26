package com.example.cal_0716

import android.text.Html
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.ArraySet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cal_0716.databinding.ActivityApiMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.lang.Exception
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.Arrays
import java.util.Objects
import kotlin.concurrent.thread
import kotlin.math.log

class apiConnectTest  {

    private lateinit var binding : ActivityApiMainBinding

    fun conNNewsApi(tv1 : TextView,tv2 : TextView, tvList: RecyclerView, am:apiMainActivity){
        var clientId : String = "0zg_m0vi6CARQJOB8CIL";
        var clientSecret : String = "4Ru4xNZLX3";

        var serachText : String = "";
        var text : String = tv1.text.toString();
        try {
            serachText = URLEncoder.encode(text,"UTF-8")
        } catch (ex: UnsupportedEncodingException){
            throw RuntimeException("인코딩 실패");
        }

        var apiURL : String = "https://openapi.naver.com/v1/search/news?query="+serachText+"&display=2&sort=date"; //json 결과
        //var apiURL : String = "https://openapi.naver.com/v1/search/news.xml?query="+serachText+"&sort=date"; //xml결과

        var headerMap = HashMap<String,String>()
        headerMap.put("X-Naver-Client-Id",clientId);
        headerMap.put("X-Naver-Client-Secret",clientSecret);
        
        getNews(apiURL,headerMap,tvList,am);
        //tv2.text = newsBody
        return
    }



    private fun getNews(apiUrl : String, header : HashMap<String,String>, tvList : RecyclerView,am:apiMainActivity) {
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
                    val arryCont = testCont.getJSONArray("items")
                    var arryCont2 = testCont.optJSONArray("items")
                    val arryInt = arryCont.length().toInt()
                    //var listRlst : String = "";
                    var totRlst = StringBuilder()

                    var urlCont = "";
                    Log.d("URL",urlCont)

                    var arList : ArrayList<String> = java.util.ArrayList();
                    Log.d("2",urlCont)
                    for (i in 0 until arryInt){

                        val titleCont :JSONObject?  = arryCont.getJSONObject(i)
                        val j : Int = i+1
                        var htmlRlst = Html.fromHtml(titleCont?.get("title") as String?)
                        urlCont = arryCont2.getJSONObject(i).getString("originallink")
                        //totRlst.append(""+ j + ". "+ htmlRlst + "\n"+urlCont+"\n")
                        //totRlst.append(""+ j + ". "+ htmlRlst + "\n")
                        arList.add(htmlRlst.toString())
                    }
                    //arList.add("test")
                    Log.d("얼쑤",arList.size.toString())
                    var custAdpt = customAdpt(arList)
                    //tvList.adapter = custAdpt;
                    //tvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

                    //tv2.text = totRlst;
                    //tv2.setText(totRlst)
                    //return@thread
//                    return custAdpt;
                    am.runOnUiThread{
                        tvList.layoutManager = LinearLayoutManager(am)
                        tvList.adapter = custAdpt
                    }
                } else {
                    rlst = "실패"
                    //tv2.text = rlst;
                }

            }//thread 종료
            Log.d("도착",rlst)

        } catch (ex:IOException){
            throw RuntimeException("URL연결 실패");

        }
//        return null
    }


}