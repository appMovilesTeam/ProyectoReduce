package salgadomontoya.anasofia.myreduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class AgregarActividad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_actividad)

        val buttonAtras : ImageButton=findViewById(R.id.regresar_atras) as ImageButton

        buttonAtras.setOnClickListener {
            var intent: Intent = Intent(this, PaginaPrincipal::class.java)
            startActivity(intent)
        }

    }
}
