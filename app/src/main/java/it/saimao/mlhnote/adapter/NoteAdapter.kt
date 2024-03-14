package it.saimao.mlhnote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import it.saimao.mlhnote.databinding.AdapterNoteListBinding
import it.saimao.mlhnote.fragment.HomeFragmentDirections.ActionHomeFragmentToEditNoteFragment
import it.saimao.mlhnote.fragment.HomeFragmentDirections.actionHomeFragmentToEditNoteFragment
import it.saimao.mlhnote.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    class NoteViewHolder(val itemBinding: AdapterNoteListBinding) :
        ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.noteTitle == newItem.noteTitle
                    && oldItem.noteDescription == newItem.noteDescription
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            AdapterNoteListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.itemBinding.noteTitle.text = currentNote.noteTitle
        holder.itemBinding.noteDesc.text = currentNote.noteDescription
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(actionHomeFragmentToEditNoteFragment(currentNote))
        }
    }

}