package ge.msda.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val savedText = sharedPreferences.getString("NOTES", "")
        initView(sharedPreferences)
        notes(savedText)

        addBtn.setOnClickListener {

            val input = inputText.text.toString()

            if (!TextUtils.isEmpty(input)) {

                addNote(input)
                inputText.setText("")


            }

        }

    }


    private fun initView(sharedPreferences: SharedPreferences) {
        noteAdapter = NoteAdapter(ArrayList(), sharedPreferences)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = noteAdapter
    }


    private fun notes(noteStr: String?) {
        if (noteStr != null) {
            val notes: MutableList<Note> = mutableListOf()
            noteStr.lines().dropLast(1).forEach {
                notes.add(Note(it))
            }
            noteAdapter.updateNotes(
                notes
            )
        }
    }


    private fun addNote(text: String) {

        noteAdapter.addNote(Note(text))

    }


}