package ge.msda.myapplication.db

import androidx.room.*


@Dao
    interface NoteEntityDao {

        @Query("SELECT * FROM NOTES")
        fun getAllNotes(): List<NoteEntity>

        @Query("SELECT * FROM NOTES A WHERE A.Text IN (:carIds)")
        fun getNotesByIds(carIds: IntArray): List<NoteEntity>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
         fun insert(vararg notes: NoteEntity)

        @Delete
        fun deleteNote(car: NoteEntity)

        @Query("DELETE FROM NOTES")
        fun deleteAll()

    }


