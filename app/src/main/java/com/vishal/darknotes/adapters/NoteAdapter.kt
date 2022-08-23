package com.vishal.darknotes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vishal.darknotes.R
import com.vishal.darknotes.models.noteData
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(private var noteData: MutableList<noteData>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.title.text = noteData[position].title
        holder.desc.text = noteData[position].desc
    }

    override fun getItemCount(): Int {
        return noteData.size
    }

    class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.tvTitle
        val desc: TextView = itemView.tvDescription
    }

}