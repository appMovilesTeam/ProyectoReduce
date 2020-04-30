package salgadomontoya.anasofia.myreduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_datos.*
import kotlinx.android.synthetic.main.activity_pagina_principal.*
import kotlinx.android.synthetic.main.activity_pagina_principal.nombre_usuario

class PaginaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)

        val buttoncasa : ImageButton =findViewById(R.id.blog_principal) as ImageButton

        buttoncasa.setOnClickListener {
            var intent: Intent = Intent(this, HomeBlog::class.java)
            startActivity(intent)
        }




        val bundle= intent.extras
        if(bundle != null){
            val nombre= bundle.getString("name")
            nombre_usuario.setText(nombre)
        }




    }
}
