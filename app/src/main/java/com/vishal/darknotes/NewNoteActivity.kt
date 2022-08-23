package com.vishal.darknotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        db = FirebaseFirestore.getInstance()

        //back button
        imgBack.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }

        //save note button
        fabSave.setOnClickListener {

            val title = etTitle.text.toString()
            val desc = etDescription.text.toString()

            if (title.isNotEmpty() and desc.isNotEmpty()) {
                saveNote(title, desc)
            }
            else{
                Toast.makeText(this,"Can't save empty note",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun saveNote(title: String, desc: String) {
        val tempNote = hashMapOf(
            "title" to title,
            "description" to desc
        )

        db.collection("notes")
            .add(tempNote)
            .addOnSuccessListener {
                Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show()
                val i = Intent(this,MainActivity::class.java)
                startActivity(i)
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

    }
}