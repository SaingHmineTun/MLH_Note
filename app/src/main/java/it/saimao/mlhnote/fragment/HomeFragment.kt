package it.saimao.mlhnote.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import it.saimao.mlhnote.MainActivity
import it.saimao.mlhnote.R
import it.saimao.mlhnote.adapter.NoteAdapter
import it.saimao.mlhnote.databinding.FragmentHomeBinding
import it.saimao.mlhnote.model.Note
import it.saimao.mlhnote.viewmodel.NoteViewModel

/*
 * Tutorial Link : https://www.youtube.com/watch?v=-XZXvLvL3II
 */

class HomeFragment : Fragment(R.layout.fragment_home), MenuProvider {

    lateinit var homeBinding: FragmentHomeBinding
    lateinit var viewModel: NoteViewModel
    lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add Menu
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // View Model
        viewModel = (activity as MainActivity).viewModel
        viewModel.addNote(
            Note(
                noteTitle = "Kham Hom",
                noteDescription = "I love her! She is my girlfriend!"
            )
        )

        homeBinding.fabAddNote.setOnClickListener {
            it.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToAddNoteFragment())
        }
    }

    private fun updateUi(notes: List<Note>?) {
        if (notes != null) {
            if (notes.isNotEmpty()) {
                homeBinding.imgEmptyNote.visibility = View.GONE
                homeBinding.rclHome.visibility = View.VISIBLE
            } else {

                homeBinding.imgEmptyNote.visibility = View.VISIBLE
                homeBinding.rclHome.visibility = View.GONE
            }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        TODO("Not yet implemented")
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        TODO("Not yet implemented")
    }


}