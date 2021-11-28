package com.italkutalk.lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            //驗證發出對象，確認 SecActivity 執行的狀態
            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                //讀取 Bundle 資料
                findViewById<TextView>(R.id.tv_meal).text =
                        "您的餐點: ${it.getString("meal")}\n\n"
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_choice = findViewById<Button>(R.id.btn_choice)
        val ed_table = findViewById<EditText>(R.id.ed_table)

        findViewById<Button>(R.id.btn_choice).setOnClickListener {
            if (ed_table.length() < 1){
                Toast.makeText(this, "請輸入桌號",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, SecActivity::class.java)
                val b = Bundle()
                b.putString("table", ed_table.text.toString())
                //setResult(Activity.RESULT_OK, intent.putExtras(b))
                startActivityForResult(intent.putExtras(b), 1)
            }

        }
    }
}