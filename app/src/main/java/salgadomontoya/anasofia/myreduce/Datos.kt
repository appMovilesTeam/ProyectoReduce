package salgadomontoya.anasofia.myreduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Datos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        val button1 : Button =findViewById(R.id.Finalizar_inscripcion) as Button

        button1.setOnClickListener {
            var intent: Intent = Intent(this, Principal_Activity::class.java)
            startActivity(intent)
        }


    }
}
