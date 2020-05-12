package salgadomontoya.anasofia.myreduce

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.actividades_celdas.view.*
import kotlinx.android.synthetic.main.activity_agregar_actividad.*
import kotlinx.android.synthetic.main.celda_imagen.view.*

class AgregarActividad : AppCompatActivity() {

    var entradas = ArrayList<MasInfoBlog>()
    var adaptador:EntradasActividadAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_actividad)

        val buttonAtras : ImageButton=findViewById(R.id.regresar_atras) as ImageButton

        buttonAtras.setOnClickListener {
            var intent: Intent = Intent(this, PaginaPrincipal::class.java)
            startActivity(intent)
        }

        cargarEntradas()
        adaptador = EntradasActividadAdapter(this, entradas)
        lista_entradas_actividad.adapter = adaptador
    }

        fun cargarEntradas(){
            entradas.add(MasInfoBlog("Conciencia importante", "En este apartado marcan de forma concreta que el mundo debe de ser cuidado", R.drawable.articulo_2_2, "Mundo Saludable","Lucia Mendez",R.drawable.perfil2,"Cuidemos el planeta para tener un futuro sano y libre de contaminantes"))
            entradas.add(MasInfoBlog("Limpieza en el ambiente", "Expresa la importancia de limpiar", R.drawable.articulo_3_3, "Limpieza Profunda","Mario Costa",R.drawable.perfil3,"Se tiene que tener un ambiente limpio para una vida limpia"))
            entradas.add(MasInfoBlog("Conciencia ante todo", "Animan a la gente a plantar y a tener conciencia", R.drawable.articulo_4_4, "Plantas en todas partes","Maria Peña",R.drawable.perfil4,"Cuidemos el planeta para tener un futuro sano y libre de contaminantes"))

        }
        class EntradasActividadAdapter: BaseAdapter {
            var context: Context? =null
            var entradas = ArrayList<MasInfoBlog>()

            constructor(context: Context, entradas: ArrayList<MasInfoBlog>){
                this.context = context
                this.entradas = entradas
            }
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                var entrada = entradas[position]
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var vista = inflator.inflate(R.layout.actividades_celdas, null)
                Log.d("objeto", entrada.toString())
                vista.titulo_comentario.setText(entrada.textoTitulo)
                vista.comentario.setText(entrada.contenido)
                vista.picture_set3.setImageResource(entrada.imagen)

                //   vista.lista_contenido.setImageResourse(entrada.imagen)
                //  vista.button_corazon.setImageResource(R.drawab
                //  le)
                vista.picture_set3.setOnClickListener{
                    var intento = Intent(context, Detalle_articulo::class.java)
                    intento.putExtra("imagenArticulo", entrada.imagen)
                    intento.putExtra("titulo",entrada.titulo)
                    intento.putExtra("autor",entrada.autor)
                    intento.putExtra("imagen",entrada.imagenDelAutor)
                    intento.putExtra("contenido",entrada.contenido)
                    context!!.startActivity(intento)
                }
                return vista
            }

            override fun getItem(position: Int): Any {
                return 1
            }

            override fun getItemId(position: Int): Long {
                return 1
            }

            override fun getCount(): Int {
                return entradas.size
            }
        }

    }

