package com.nguyencodervn.klad08_menuandsnackbar

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

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
        registerForContextMenu(contextMenuBt)
    }

    private fun setupAction() {

        snackBarBt.setOnClickListener {
            val snack = Snackbar.make(
                snackBarBt,
                getString(R.string.snack_bar),
                Snackbar.LENGTH_LONG
            )
            snack.setAction(R.string.click) {
                textView.text = getString(R.string.on_click)
            }
            snack.show()
        }

        customsSnackBarBt.setOnClickListener {
            val snack = Snackbar.make(
                customsSnackBarBt,
                getString(R.string.snack_bar),
                Snackbar.LENGTH_LONG
            )
            snack.setAction(R.string.click) {
                textView.text = getString(R.string.on_click)
            }

            val yellow = ContextCompat.getColor(baseContext, R.color.yellow)
            val teal700 = ContextCompat.getColor(baseContext, R.color.teal_700)
            val white = ContextCompat.getColor(baseContext, R.color.white)

            val tv = snack.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val font = Typeface.createFromAsset(assets, "calibrii.ttf")

            tv.textSize = 20F
            tv.typeface = font

            snack.setActionTextColor(yellow)
            snack.view.setBackgroundColor(teal700)
            snack.setTextColor(white)
            snack.show()

        }
    }

    private fun initView() {
        textView = findViewById(R.id.textView)
        contextMenuBt = findViewById(R.id.contextMenuBt)
        snackBarBt = findViewById(R.id.snackBarBt)
        customsSnackBarBt = findViewById(R.id.customsSnackBarBt)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeMenu -> textView.text = getString(R.string.home_option)
            R.id.shareMenu -> textView.text = getString(R.string.share_option)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu_option, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeMenu -> textView.text = getString(R.string.home_context)
            R.id.shareMenu -> textView.text = getString(R.string.share_context)
        }
        return super.onContextItemSelected(item)
    }
}