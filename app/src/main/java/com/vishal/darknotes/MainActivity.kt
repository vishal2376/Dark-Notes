package com.vishal.darknotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.vishal.darknotes.adapters.NoteAdapter
import com.vishal.darknotes.models.noteData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadNotes()

        rvNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // add button click
        fabAdd.setOnClickListener {
            val i = Intent(this, NewNoteActivity::class.java)
            startActivity(i)
        }
    }

    private fun loadNotes(){
        val db = FirebaseFirestore.getInstance()
        val tempNotes = mutableListOf<noteData>()
        db.collection("notes")
            .get()
            .addOnSuccessListener { result ->
                for (note in result) {
                    val id = note.id
                    val title = note.data["title"].toString()
                    val desc = note.data["description"].toString()

                    tempNotes += noteData(id,title, desc)

                }
                rvNotes.adapter = NoteAdapter(this,tempNotes)
            }

    }
}