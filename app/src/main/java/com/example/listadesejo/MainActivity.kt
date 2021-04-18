package com.example.listadesejo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val FORMULARIO = 1
    private val nomes = arrayListOf<String>()

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var lista: ListView
    private lateinit var listaDeCores: ListaCores

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = findViewById(R.id.listaDesejo)


        this.listaDeCores = ListaCores();
//        tlistaDeCores.add(Cor("Azul", 445566));
        this.lista.adapter = CustomListAdapter(this, listaDeCores)

        val fab: View = findViewById(R.id.btnAdicionar)




        fab.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, Formulario::class.java)
            startActivityForResult(intent, FORMULARIO)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if ( requestCode == FORMULARIO) {
                val desejoObj = data?.getSerializableExtra("objVolta") as? Cor

                if (desejoObj != null) {
                    this.listaDeCores.add(desejoObj)
                }
                Toast.makeText(this, "Item adicionado com sucesso!", Toast.LENGTH_LONG).show()

            }
        }
    }



}