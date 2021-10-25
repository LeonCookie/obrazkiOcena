package com.example.obrazkiocena

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var widac: CheckBox
        lateinit var camera: ImageButton
        lateinit var previous: ImageButton
        lateinit var next: ImageButton
        lateinit var delete: ImageButton
        lateinit var mapa: ImageView

        title="obrazy"
        widac = findViewById<CheckBox>(R.id.checkBoxWidok)
        camera = findViewById<ImageButton>(R.id.imageButtonCamera)
        previous =findViewById<ImageButton>(R.id.imageButtonPrevious)
        next = findViewById<ImageButton>(R.id.imageButtonNext)
        delete = findViewById<ImageButton>(R.id.imageButtonDelete)
        mapa = findViewById<ImageView>(R.id.imageViewMapa)


        widac.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked){

                mapa.setVisibility(View.VISIBLE);

            }else{
                mapa.setVisibility(View.INVISIBLE);
            }

            }

    }


}