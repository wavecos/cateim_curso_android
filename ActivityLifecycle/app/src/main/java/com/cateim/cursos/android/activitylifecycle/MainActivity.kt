package com.cateim.cursos.android.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivityTest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onCreate Finalizado")
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "onStart Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onStart Finalizado")
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "onResume Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onResume Finalizado")
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "onPause Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onPause Finalizado")
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "onStop Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onStop Finalizado")
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "onRestart Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onRestart Finalizado")
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "onDestroy Finalizado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onDestroy Finalizado")
    }
}