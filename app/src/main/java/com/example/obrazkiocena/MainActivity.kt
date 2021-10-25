package com.example.obrazkiocena

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var widac: CheckBox
        lateinit var camera: Button
        lateinit var previous: Button
        lateinit var next: Button
        lateinit var delete: Button
        title="obrazy"
        widac = findViewById(R.id.checkBoxWidok)
        camera = findViewById(R.id.imageButtonCamera)
        previous =findViewById(R.id.imageButtonPrevious)
        next = findViewById(R.id.imageButtonNext)
        delete = findViewById(R.id.imageButtonDelete)
    }


}