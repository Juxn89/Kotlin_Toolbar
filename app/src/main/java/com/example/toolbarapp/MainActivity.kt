package com.example.toolbarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        //toolbar?.title = "Titulo del toolbar"
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        val bIr = findViewById<Button>(R.id.bIr)
        bIr.setOnClickListener {
            val intent = Intent(this, PantallaSecundaria::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // onCreateOptionsMenu - cuándo se está creando las opciones
        menuInflater.inflate(R.menu.menu, menu)

        val itemBusqueda = menu?.findItem(R.id.busqueda)
        val vistaBusqueda = itemBusqueda?.actionView as SearchView

        vistaBusqueda?.queryHint = "Escribe tu nombre..."
        vistaBusqueda?.setOnQueryTextFocusChangeListener { v, hasFocus ->
            Log.d("LISTENER_FOCUS", hasFocus.toString())
        }
        vistaBusqueda?.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("onQueryTextChange", newText)
                return  true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("onQueryTextSubmit", query)
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Se agrega eventos a elemento seleccionado
        when(item?.itemId){
            R.id.bFav -> {
                Toast.makeText(this, "Elemento añadido como favorito", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
