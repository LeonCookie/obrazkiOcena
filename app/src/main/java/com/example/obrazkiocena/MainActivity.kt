package com.example.obrazkiocena

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.imageButtonCamera).isEnabled = false
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions( this, arrayOf(android.Manifest.permission.CAMERA), 111)
        }
        else
            findViewById<ImageButton>(R.id.imageButtonCamera).isEnabled = true

        lateinit var widac: CheckBox
        lateinit var camera: ImageButton
        lateinit var previous: ImageButton
        lateinit var next: ImageButton
        lateinit var delete: ImageButton
        lateinit var mapa: ImageView
        lateinit var Suwak: SeekBar
        lateinit var Naten: SeekBar
        lateinit var Skala: Button
        lateinit var TextSkala: EditText
        lateinit var ColorRed: Button
        lateinit var ColorGreen: Button
        lateinit var ColorBlue: Button

        var images =
            arrayListOf<Int>(R.drawable.shock, R.drawable.cringe, R.drawable.what, R.drawable.horny)
        var i: Int = 0
        var s:Int
        var l:Float
        var n:Float

        findViewById<Button>(R.id.buttonSkala)

        title = "Leon Rewers"
        widac = findViewById<CheckBox>(R.id.checkBoxWidok)
        camera = findViewById<ImageButton>(R.id.imageButtonCamera)
        previous = findViewById<ImageButton>(R.id.imageButtonPrevious)
        next = findViewById<ImageButton>(R.id.imageButtonNext)
        delete = findViewById<ImageButton>(R.id.imageButtonDelete)
        mapa = findViewById<ImageView>(R.id.imageViewObraek)
        Suwak = findViewById<SeekBar>(R.id.seekBar2)
        Skala = findViewById<Button>(R.id.buttonSkala)
        Naten = findViewById(R.id.seekBarNat)
        TextSkala = findViewById<EditText>(R.id.editTextNumberSkala)

        ColorRed  = findViewById<Button>(R.id.buttonColorRed)
        ColorGreen= findViewById<Button>(R.id.buttonColorGreen)
        ColorBlue = findViewById<Button>(R.id.buttonColorBlue)







        widac.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {


                mapa.setVisibility(View.INVISIBLE);

            } else {
                mapa.setVisibility(View.VISIBLE);
            }

        }

        next.setOnClickListener {
            if (i < 3) {
                i++
                mapa.setImageResource(images[i])
            } else {
                Toast.makeText(applicationContext, "ostatni obraz", Toast.LENGTH_SHORT).show()
                i = 3
            }

        }
        previous.setOnClickListener {
            if (i > 0) {
                i--
                mapa.setImageResource(images[i])
            } else {
                Toast.makeText(applicationContext, "pierwszy obraz", Toast.LENGTH_SHORT).show()
                i = 0
            }


        }
        camera.setOnClickListener {
            var x = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(x,101)


        }
        delete.setOnClickListener {
            mapa.setImageResource(0)
        }
        Skala.setOnClickListener{
             s = TextSkala.text.toString().toInt()

            if(s>=1 && s<=360) {
                mapa.rotation= s.toFloat()




            }else{
                Toast.makeText(applicationContext, "zakres od 1 do 360", Toast.LENGTH_SHORT).show()
            }

        }

        Suwak.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,fromUser: Boolean) {

                //mapa.setRotation(Suwak.progress.toFloat())

                l = (progress.toFloat()/10)
                mapa.alpha= l

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        Naten.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,fromUser: Boolean) {

               //natez

                n = (progress.toFloat()/10)


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101){
            var pic = data?.getParcelableExtra<Bitmap>("data")
            findViewById<ImageView>(R.id.imageViewObraek).setImageBitmap(pic)
        }
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            findViewById<ImageButton>(R.id.imageButtonCamera).isEnabled = true
        }
    }







}


