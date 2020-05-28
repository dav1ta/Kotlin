package ge.msda.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import ge.msda.myapplication.db.NoteEntity
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

            var note = NoteEntity(0,input)
            if (!TextUtils.isEmpty(input)) {

                App.instance.db.getNoteDao().insert(note)

                addNote(input)
                inputText.setText("")


            }

        }



        clrBtn.setOnClickListener {
            inputText.setText("")
            noteAdapter.updateNotes(ArrayList())
            App.instance.db.getNoteDao().deleteAll()
        }


        App.instance.db.getNoteDao().getAllNotes().forEach { nt ->
            Log.d("Mydata", nt.toString())
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