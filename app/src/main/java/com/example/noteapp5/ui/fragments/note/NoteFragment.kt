// NoteFragment.kt
package com.example.noteapp5.ui.fragments.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp5.R
import com.example.noteapp5.databinding.FragmentNoteBinding
import com.example.noteapp5.ui.adapter.NoteAdapter
import com.example.noteapp5.ui.App

class NoteFragment : Fragment() {
    private lateinit var adapter: NoteAdapter
    private lateinit var binding: FragmentNoteBinding
    private var flag = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NoteAdapter()
        val list = App.appDataBase?.noteDao()?.getAllNotes()
        binding.rvNotes.adapter = adapter
        adapter.submitList(list)
        initListener()
    }



    override fun onResume() {
        super.onResume()
        updateNoteList()
    }

    private fun initListener() = with(binding) {
        btnPlus.setOnClickListener {
            findNavController().navigate(R.id.noteDetailFragment)
        }

        imgShape.setOnClickListener {
            if (flag) {
                imgShape.setImageResource(R.drawable.ic_shape)
                binding.rvNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                flag = false
            }else{
                imgShape.setImageResource(R.drawable.ic_shape_line)
                binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
                flag = true
            }
        }
    }

    private fun updateNoteList() {
        val notes = App().getInstance()?.noteDao()?.getAllNotes()
        adapter.submitList(notes)
    }
}