package com.example.listadesejo

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast

class Formulario : AppCompatActivity() {
    private var hexColorDefault = "#000000";

    private lateinit var  vermelhoSeek: SeekBar;
    private lateinit var  verdeSeek: SeekBar;
    private lateinit var  azulSeek: SeekBar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etCor: EditText = findViewById(R.id.etCor)

        vermelhoSeek= findViewById(R.id.sbvermelho)
        verdeSeek = findViewById(R.id.sbverde)
        azulSeek = findViewById(R.id.sbazul)

        val corDisplay: Button = findViewById(R.id.btCorDisplay)


        corDisplay.text = hexColorDefault;

        val btnCadastrar: Button = findViewById(R.id.btnCadastrar)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)


        vermelhoSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                corDisplay.setText(colorStr.replace("#","").toUpperCase())
                corDisplay.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        verdeSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                corDisplay.setText(colorStr.replace("#","").toUpperCase())
                corDisplay.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        azulSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                corDisplay.setText(colorStr.replace("#","").toUpperCase())
                corDisplay.setBackgroundColor(Color.parseColor(colorStr))
            }
        })






        btnCadastrar.setOnClickListener {
            val intent = Intent()

            val corNome = etCor.text.toString()
            val codigo = corDisplay.text.toString().toInt()

            val obj = Cor(corNome, codigo)

            if (corNome.length > 0) {
                intent.putExtra("objVolta", obj)
                Toast.makeText(this, obj.toString(), Toast.LENGTH_LONG).show()
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "Preencha os campos!", Toast.LENGTH_LONG).show()
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }

    }

    fun getColorString(): String {
        var r = Integer.toHexString(((255*vermelhoSeek.progress)/255))
        if(r.length==1) r = "0"+r
        var g = Integer.toHexString(((255*verdeSeek.progress)/255))
        if(g.length==1) g = "0"+g
        var b = Integer.toHexString(((255*azulSeek.progress)/255))
        if(b.length==1) b = "0"+b
        return "#" + r + g + b
    }

}