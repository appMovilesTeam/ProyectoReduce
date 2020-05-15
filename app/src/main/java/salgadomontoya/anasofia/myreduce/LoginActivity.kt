package salgadomontoya.anasofia.myreduce

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    val RC_SIGN_IN: Int = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var inicioSesionGoogle: SignInButton = findViewById(R.id.inicio_sesion_google) as SignInButton
        reDesignGoogleButton(inicioSesionGoogle)
        googleLogIn()
    }

    fun googleLogIn() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build())

        inicio_sesion_google.setOnClickListener{
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                Toast.makeText(this,"Bienvenido, ${user!!.displayName}", android.widget.Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Principal_Activity::class.java))
                finish()
            } else {
                when(response?.getError()?.getErrorCode()) {
                    // Sign in failed. If response is null the user canceled the
                    // sign-in flow using the back button. Otherwise check
                    // response.getError().getErrorCode() and handle the error.
                    ErrorCodes.NO_NETWORK -> Toast.makeText(this,"No tienes conexión a internet", android.widget.Toast.LENGTH_SHORT).show()
                    ErrorCodes.PROVIDER_ERROR -> Toast.makeText(this,"Ocurrió un error con el proveedor de inicio de sesión", android.widget.Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this,"Ha fallado el inicio de sesión por un error desconocido", android.widget.Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun reDesignGoogleButton(signInButton: SignInButton) {
        for (i in 0 until signInButton.childCount) {
            val v = signInButton.getChildAt(i)
            if (v is TextView) {
                v.setBackgroundResource(android.R.color.transparent) //setting transparent color that will hide google image and white background
                v.setTextColor(resources.getColor(R.color.common_google_signin_btn_text_light)) // text color here
                v.typeface = Typeface.DEFAULT_BOLD // even typeface
                return
            }
        }
    }
}
