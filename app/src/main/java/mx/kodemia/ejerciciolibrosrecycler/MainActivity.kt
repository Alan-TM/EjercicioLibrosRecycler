package mx.kodemia.ejerciciolibrosrecycler

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_libro.view.*
import kotlinx.android.synthetic.main.dialog_agregar_libros.view.*
import mx.kodemia.ejerciciolibrosrecycler.adapters.AdapterLibro

class MainActivity : AppCompatActivity() {

    val listLibros : MutableList<Libro> = mutableListOf()
    var adapterLibro = AdapterLibro(listLibros)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerLibros()

        initFabAddLibro(this)
    }

    private fun initFabAddLibro(context: Context) {
        fab_agregar_libro.setOnClickListener {
            val layoutInflater =LayoutInflater.from(context).inflate(R.layout.dialog_add_libro, null)
            val dialog = AlertDialog.Builder(context).setView(layoutInflater).setCancelable(false)

            val instanciaDialogo = dialog.show()
            layoutInflater.button_agregar_libro.setOnClickListener{
                val urlImage =layoutInflater.til_url.editText?.text.toString().trim()
                if(urlImage.isNotEmpty()){
                    adapterLibro.agregarLibro(Libro(urlImage))

                    instanciaDialogo.dismiss()
                }
            }
        }
    }

    fun initRecyclerLibros(){
        listLibros.add(Libro("https://cloudfront-eu-central-1.images.arcpublishing.com/prisa/2FEZLOAZVN2WNSJRJPOGCA2EOY.jpg"))
        recyclerview_libros.layoutManager = GridLayoutManager(this, 3)
        recyclerview_libros.setHasFixedSize(true)
        adapterLibro = AdapterLibro(listLibros)
        recyclerview_libros.adapter = adapterLibro
    }

}