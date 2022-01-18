package mx.kodemia.ejerciciolibrosrecycler.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.dialog_agregar_libros.view.*
import mx.kodemia.ejerciciolibrosrecycler.Libro
import mx.kodemia.ejerciciolibrosrecycler.R

class AdapterLibro(val libros: MutableList<Libro>) :
    RecyclerView.Adapter<AdapterLibro.LibroHolder>() {
    class LibroHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val cardView : MaterialCardView = view.findViewById(R.id.cardView_agregar_libro)
        val imagenView : ImageView = view.findViewById(R.id.imageView_libro)

        fun setImagen(imagen: Libro){
            Glide.with(view).load(imagen.url).diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imagenView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LibroHolder(layoutInflater.inflate(R.layout.dialog_agregar_libros, parent, false))
    }

    override fun onBindViewHolder(holder: LibroHolder, position: Int) {
        holder.setImagen(libros[position])
    }

    override fun getItemCount(): Int = libros.size

    fun agregarLibro(libro: Libro){
        this.libros.add(libro)
        notifyItemInserted(itemCount)
    }
}