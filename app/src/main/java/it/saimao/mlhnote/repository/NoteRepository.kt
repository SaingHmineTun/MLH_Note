package it.saimao.mlhnote.repository

import androidx.lifecycle.LiveData
import it.saimao.mlhnote.database.NoteDao
import it.saimao.mlhnote.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val dao: NoteDao) {
    suspend fun addNote(note: Note) = dao.addNote(note)
    suspend fun updateNote(note: Note) = dao.updateNote(note)
    suspend fun deleteNote(note: Note) = dao.deleteNote(note)
    fun getAllNotes(): LiveData<List<Note>> = dao.getAllNotes()
    fun searchNote(query: String): LiveData<List<Note>> = dao.searchNote(query)


}