package com.books.data.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.books.data.model.Book
import com.books.data.ui.adapter.BookAdapter
import com.books.data.ui.viewmodel.BookViewModel
import com.books.databinding.FragmentBookListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment() {

    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.books.observe(viewLifecycleOwner) { books ->
            binding.recyclerView.adapter = BookAdapter(books) { book ->
                showBookDialog(book)
            }
        }
        viewModel.loadBooks()
    }

    private fun showBookDialog(book: Book) {
        AlertDialog.Builder(requireContext())
            .setTitle(book.title)
            .setMessage(book.description)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

