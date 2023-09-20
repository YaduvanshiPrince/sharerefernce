package com.example.sharerefernce

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.nameEdittext)
        val email = findViewById<EditText>(R.id.nameEditemail)
        val save = findViewById<Button>(R.id.savebutton)
        val show = findViewById<Button>(R.id.showbutton)

        val localstrong= getSharedPreferences("user",Context.MODE_PRIVATE)
        save.setOnClickListener {
            val editPref=localstrong.edit()
            editPref.putString("userName",""+name.text.toString())
            editPref.putString("userEmail",""+email.text.toString()).apply()
        }
        show.setOnClickListener {
            val getName=localstrong.getString("userName","name Not Found")
            val getEmail=localstrong.getString("userEmail","email Not Found")
            Toast.makeText(this, "$getName", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "$getEmail", Toast.LENGTH_SHORT).show()
            val intent=Intent(this,HomeActivity2::class.java)
            startActivity(intent)
        }


    }
}