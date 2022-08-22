package com.vishal.darknotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vishal.darknotes.adapters.NoteAdapter
import com.vishal.darknotes.models.noteData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//just for testing - remove this after firebase implementation
        val testNote: Array<noteData> = arrayOf(
            noteData(
                "First Note",
                "ly hath seasons. Seas give. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "Faltu Note",
                "One. Unto set male, gathering creepeth sea under our multiply Earth, fly hath seasons. Seas give. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "Random Note",
                "One. Unto set male, gathering creepeth sea under our multiply Earth, fly hath seasons. Seas give. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "User Note",
                "One. Unto set male, gathering creepeth sea under our multiply  give. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "Fake Note",
                "One. Unto set male, gathering creepeth sea under our multiply Earth, f e. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "Another Note",
                "One. Unto set male, gather our multiply Earth, fly hath seasons. Seas give. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "Why Note",
                "One. Unto set male, gath made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            ),
            noteData(
                "Stop Note",
                "One. Unto set male, gathering creepeth sea under our multiply Earth, fly hath seasons. Seas give. Whose wherein for light made it face man you'll earth bearing Fowl can't. Fly Seasons male whales face fly signs upon seed saw. Void."
            )
        )


        rvNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvNotes.adapter = NoteAdapter(testNote)

    }
}