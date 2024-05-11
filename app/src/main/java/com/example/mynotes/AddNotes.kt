package com.example.mynotes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mynotes.databinding.ActivityAddNotesBinding

class AddNotes : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var db: NoteDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        db = NoteDb(this)
        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            db.addtNote(note)
            finish()
            Toast.makeText(this, "Note Save", Toast.LENGTH_SHORT).show()
        }

    }
}