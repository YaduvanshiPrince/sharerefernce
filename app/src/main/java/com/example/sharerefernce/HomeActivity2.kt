package com.example.sharerefernce

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class HomeActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

         val localstrong=getSharedPreferences("user",Context.MODE_PRIVATE)

        val getName=localstrong.getString("userName","name Not Found")
        val getEmail=localstrong.getString("userEmail","email Not Found")


        val name1=findViewById<TextView>(R.id.name)
        val email1=findViewById<TextView>(R.id.email)

        name1.text=getName.toString()
        email1.text=getEmail.toString()

       Toast.makeText(this, "$getName",Toast.LENGTH_SHORT).show()
       Toast.makeText(this, "$getEmail",Toast.LENGTH_SHORT).show()


    }
}