package salgadomontoya.anasofia.myreduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 : Button =findViewById(R.id.inicio_sesion) as Button
        val button2: Button= findViewById(R.id.crea_cuenta) as Button

        button1.setOnClickListener {
            var intent: Intent = Intent(this, PaginaPrincipal::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            var intent: Intent = Intent(this, Crear_cuenta::class.java)
        }

    }






}
