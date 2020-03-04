package com.example.toolbarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class PantallaSecundaria : AppCompatActivity() {

    var toolbar:Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_secundaria)

        toolbar = findViewById<Toolbar>(R.id.toolbar_secundario)
        toolbar?.setTitle(R.string.app_name)

        setSupportActionBar(toolbar)
        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_secundario, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
