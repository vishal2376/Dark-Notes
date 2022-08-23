package com.vishal.darknotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_note.*
import kotlinx.android.synthetic.main.activity_edit_note.imgBack
import kotlinx.android.synthetic.main.activity_new_note.*

class EditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)


        val title = intent.getStringExtra("M_TITLE")
        val desc = intent.getStringExtra("M_DESCRIPTION")

        loadNote(title, desc)

        //back button
        imgBack.setOnClickListener {
            val i = Intent(this, ViewNoteActivity::class.java)
            startActivity(i)
            finish()
        }

        //modify button
        fabModify.setOnClickListener {
            modifyNote()
        }

    }

    private fun modifyNote() {
        TODO("Not yet implemented")
    }

    private fun loadNote(title: String?, desc: String?) {
        etModifyTitle.setText(title)
        etModifyDescription.setText(desc)
    }

}