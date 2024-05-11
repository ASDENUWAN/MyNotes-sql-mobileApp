package com.example.mynotes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mynotes.databinding.ActivityEditNotesBinding

class EditNotes : AppCompatActivity() {
    private lateinit var binding: ActivityEditNotesBinding
    private lateinit var db: NoteDb
    private var noteId:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDb(this)

        noteId = intent.getIntExtra("note_id",-1)
        if(noteId==-1){
            finish()
            return
        }

        val note = db.getNoteById(noteId)
        binding.editTitleEditText.setText(note.title)
        binding.editContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener{
            val newTitle = binding.editTitleEditText.text.toString()
            val newContent = binding.editContentEditText.text.toString()
            val updateNote = Note(noteId,newTitle,newContent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
        }



    }
}