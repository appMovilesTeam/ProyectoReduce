package salgadomontoya.anasofia.myreduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class Principal_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_sesion)


        val bundle= intent.extras
        if(bundle != null){
            val nombre= bundle.getString("name")
            val correo= bundle.getString("email")

        }




    }
}
