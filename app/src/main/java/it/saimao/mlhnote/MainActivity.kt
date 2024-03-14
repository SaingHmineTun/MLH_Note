package it.saimao.mlhnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import it.saimao.mlhnote.model.Note
import it.saimao.mlhnote.viewmodel.NoteViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}