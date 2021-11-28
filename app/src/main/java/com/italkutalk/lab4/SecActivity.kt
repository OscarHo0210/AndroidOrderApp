package com.italkutalk.lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SecActivity : AppCompatActivity() {
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                findViewById<TextView>(R.id.tv_meal3).text =
                    "桌號: ${it.getString("table")}"
            }
        }
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        val bundle = intent.extras;
        findViewById<TextView>(R.id.tv_meal3).text =
            "桌號: ${bundle?.getString("table")}"

        val btn_send = findViewById<Button>(R.id.btn_send)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        btn_send.setOnClickListener {
                val b = Bundle()
                b.putString("meal", radioGroup.findViewById<RadioButton>
                    (radioGroup.checkedRadioButtonId).text.toString())
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()

                findViewById<Button>(R.id.btn_send).setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }
}