package com.vishal.darknotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        fabSave.setOnClickListener {

            var title = etTitle.text.toString()
            var desc = etDescription.text.toString()

            if title.isNotEmpty() and desc.isNotEmpty(){

                saveNote()
            }
        }

    }
}