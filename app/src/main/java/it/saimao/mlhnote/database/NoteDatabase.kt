package it.saimao.mlhnote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import it.saimao.mlhnote.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}