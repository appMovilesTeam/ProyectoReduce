package salgadomontoya.anasofia.myreduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PaginaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)

        val buttoncasa : ImageButton =findViewById(R.id.blog_principal) as ImageButton

        buttoncasa.setOnClickListener {
            var intent: Intent = Intent(this, HomeBlog::class.java)
            startActivity(intent)
        }




    }
}
