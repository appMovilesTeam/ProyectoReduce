package salgadomontoya.anasofia.myreduce

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_home_blog.*
import kotlinx.android.synthetic.main.celda_imagen.view.*
import kotlinx.android.synthetic.main.celda_imagen.view.picture_set2
import kotlinx.android.synthetic.main.cell_pictures.view.*

class HomeBlog : AppCompatActivity() {

    var entrada = ArrayList<EntradaBlog>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_blog)

        val buttonRegresar : ImageButton =findViewById(R.id.retroceder) as ImageButton

        buttonRegresar.setOnClickListener {
            var intent: Intent = Intent(this, PaginaPrincipal::class.java)
            startActivity(intent)
        }




        var adapter = AdaptadorEntradas(this, entrada)
        list_product.adapter = adapter
    }



    private class AdaptadorEntradas: BaseAdapter {
        var contexto: Context?= null
        var entradas= ArrayList<EntradaBlog>()

        constructor(contexto: Context, entradas:ArrayList<EntradaBlog>){
            this.contexto=contexto
            this.entradas=entradas
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var ent= entradas[position]
            var inflator= LayoutInflater.from(contexto)
            var vista= inflator.inflate(R.layout.cell_pictures, null)

            vista.picture_set2.setImageResource(ent.image)
            if(ent.corazon)
              //  vista.button_corazon.setImageResource(R.drawable)
            if(ent.estrella)
                    //
            return vista

        }

        override fun getItem(position: Int): Any {
            return entradas
        }

        override fun getItemId(position: Int): Long {
            return 1
        }

        override fun getCount(): Int {
            return entradas.size
        }
    }



}
