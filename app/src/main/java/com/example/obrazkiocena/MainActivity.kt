package com.example.obrazkiocena

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

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

        var  images = arrayListOf<Int>(R.drawable.shock,R.drawable.cringe,R.drawable.what,R.drawable.horny)
        var i:Int = 0

        title="obrazy"
        widac = findViewById<CheckBox>(R.id.checkBoxWidok)
        camera = findViewById<ImageButton>(R.id.imageButtonCamera)
        previous =findViewById<ImageButton>(R.id.imageButtonPrevious)
        next = findViewById<ImageButton>(R.id.imageButtonNext)
        delete = findViewById<ImageButton>(R.id.imageButtonDelete)
        mapa = findViewById<ImageView>(R.id.imageViewObraek)


        widac.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked){


                mapa.setVisibility(View.INVISIBLE);

            }else{
                mapa.setVisibility(View.VISIBLE);
            }

            }

        next.setOnClickListener {
            if(i<3){
                i++
                mapa.setImageResource(images[i])
            }else{
                Toast.makeText(applicationContext, "ostatni obraz", Toast.LENGTH_SHORT ).show()
                i=3
            }

        }
        previous.setOnClickListener {
            if(i>0){
                i--
                mapa.setImageResource(images[i])
            }else{
                Toast.makeText(applicationContext, "pierwszy obraz", Toast.LENGTH_SHORT ).show()
                i=0
            }


        }
        camera.setOnClickListener {

        }
        delete.setOnClickListener {
            mapa.setImageResource(0)

        }
    }


}