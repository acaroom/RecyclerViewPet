package com.acaroom.recyclerviewpet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // ① 빈 배열 목록 선언
    //val dataArray: ArrayList<String> = ArrayList()

    private val petList = arrayListOf<Pet>(  // ①
        Pet("British Shorthair", "Male", "4", "british_shorthair"),
        Pet("Persian Cat", "Male", "8", "persian_cat"),
        Pet("Siamese Cat", "Female", "12", "siamese_cat"),
        Pet("Maine Coon", "Male", "9", "maine_coon"),
        Pet("Ragdoll", "Male", "3", "ragdoll"),
        Pet("Sphynx Cat", "Male", "1", "sphynx_cat"),
        Pet("Abyssinian", "Female", "9", "abyssinian")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv_data_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rv_data_list.setHasFixedSize(true) // RecyclerView의 크기 재구성 방지

        // ② 람다식 함수 매개변수를 통한 클릭 이벤트 핸들러 처리
        rv_data_list.adapter = ExtensionDataAdapter(petList, this) {
            Toast.makeText(
                this,
                "Breed: ${it.breed}, Age: ${it.age}",
                Toast.LENGTH_SHORT
            ).show()
        }



        //addDataArray() // ② 배열 내용 로드

        //  ④ 레이아웃 매니저를 생성
        //rv_data_list.layoutManager = LinearLayoutManager(this)

        // ⑤ RecyclerView 어댑터에 접근해 데이터를 로드
        //rv_data_list.adapter = DataAdapter(dataArray, this)
        //rv_data_list.adapter = ExtensionDataAdapter(dataArray)  // 추가
    }

    // ③ 배열 내용을 채우는 함수
//    private fun addDataArray() {
//        dataArray.add("오리")
//        dataArray.add("호랑이")
//        dataArray.add("여우")
//        dataArray.add("늑대")
//        dataArray.add("오소리")
//        dataArray.add("원숭이")
//        dataArray.add("물개")
//        dataArray.add("펭귄")
//        dataArray.add("하마")
//        dataArray.add("미어캣")
//        dataArray.add("타조")
//    }
}
