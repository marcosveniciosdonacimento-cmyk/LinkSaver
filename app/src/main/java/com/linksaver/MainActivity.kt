package com.linksaver

import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val savedLinks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnSave = findViewById<TextView>(R.id.btnSave)
        val scrollContainer = findViewById<ScrollView>(R.id.scrollContainer)
        val linksContainer = findViewById<LinearLayout>(R.id.linksContainer)

        btnSave.setOnClickListener {
            val url = etUrl.text.toString().trim()
            if (url.isNotEmpty()) {
                savedLinks.add(url)
                etUrl.text.clear()
                addLinkView(url, linksContainer)
                Toast.makeText(this, "Link salvo!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Digite um link", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addLinkView(url: String, container: LinearLayout) {
        val tv = TextView(this)
        tv.text = url
        tv.textSize = 16f
        tv.setPadding(16, 16, 16, 16)
        tv.setOnClickListener {
            val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(url))
            startActivity(intent)
        }
        tv.setBackgroundColor(0xFFEEEEEE.toInt())
        tv.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            bottomMargin = 8
        }
        container.addView(tv)
    }
}
