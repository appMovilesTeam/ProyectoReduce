package salgadomontoya.anasofia.myreduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Crear_cuenta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        val button1 : Button =findViewById(R.id.Siguientes_datos) as Button

        button1.setOnClickListener {
            var intent: Intent = Intent(this, Datos::class.java)
            startActivity(intent)
        }


    }
}
