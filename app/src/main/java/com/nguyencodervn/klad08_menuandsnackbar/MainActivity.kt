package com.nguyencodervn.klad08_menuandsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var contextMenuBt: Button
    private lateinit var snackBarBt: Button
    private lateinit var customsSnackBarBt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setupAction()
    }

    private fun setupAction() {

        snackBarBt.setOnClickListener {

        }

        customsSnackBarBt.setOnClickListener {

        }
    }

    private fun initView() {
        textView = findViewById(R.id.textView)
        contextMenuBt = findViewById(R.id.contextMenuBt)
        snackBarBt = findViewById(R.id.snackBarBt)
        customsSnackBarBt = findViewById(R.id.customsSnackBarBt)
    }
}