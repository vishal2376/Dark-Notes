package com.vishal.darknotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_note.*

class ViewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)

        val title = intent.getStringExtra("TITLE")
        val desc = intent.getStringExtra("DESCRIPTION")

        loadNote(title, desc)

        //back button
        imgBack.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        // edit button
        fabEdit.setOnClickListener {
            val i = Intent(this, EditNoteActivity::class.java)
            i.putExtra("M_TITLE",title)
            i.putExtra("M_DESCRIPTION",desc)
            startActivity(i)
        }

    }

    private fun loadNote(title: String?, desc: String?) {
        tvTitle.text = title
        tvDescription.text = desc
    }
}