package com.vishal.darknotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_view_note.*

class ViewNoteActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)

        db = FirebaseFirestore.getInstance()

        val id = intent.getStringExtra("ID")
        val title = intent.getStringExtra("TITLE")
        val desc = intent.getStringExtra("DESCRIPTION")

        loadNote(title, desc)

        //back button
        imgBack.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        //delete button
        imgDelete.setOnClickListener {
            deleteNote(id)
        }

        // edit button
        fabEdit.setOnClickListener {
            val i = Intent(this, EditNoteActivity::class.java)
            i.putExtra("M_TITLE", title)
            i.putExtra("M_DESCRIPTION", desc)
            startActivity(i)
        }

    }

    private fun deleteNote(id: String?) {
        if (id != null) {
            db.collection("notes").document(id)
                .delete()
                .addOnSuccessListener {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"Failed to Delete",Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun loadNote(title: String?, desc: String?) {
        tvTitle.text = title
        tvDescription.text = desc
    }
}