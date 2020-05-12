package salgadomontoya.anasofia.myreduce

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AgregarActividad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_actividad)

        val buttonAtras : ImageButton= findViewById<ImageButton>(R.id.regresar_atras)
        //val arrayArticulo : ArrayList<EntradaBlog> = findViewById(R.id.)

        buttonAtras.setOnClickListener {
            this.finish()
        }

    }
}
