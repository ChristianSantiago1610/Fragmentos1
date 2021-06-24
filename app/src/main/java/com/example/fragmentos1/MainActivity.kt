package com.example.fragmentos1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fragmentos1.fragmentos.PrimerFragment
import com.example.fragmentos1.fragmentos.SegundoFragment

class MainActivity : AppCompatActivity() {
    lateinit var btnFragmento1:Button
    lateinit var btnFragmento2:Button
    lateinit var btnFragmento3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragmento1 = findViewById(R.id.btn1)
        btnFragmento2 = findViewById(R.id.btnc2)
        btnFragmento3 = findViewById(R.id.btna3)

        btnFragmento1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor,PrimerFragment.newInstance("ndo","dsf"))
                .commitNow()
        }

        btnFragmento2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor,SegundoFragment.newInstance("https://google.com",))
                .commitNow()
        }

        btnFragmento3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor,TercerFragment.newInstance("ndo","dsf"))
                .commitNow()
        }
    }
}