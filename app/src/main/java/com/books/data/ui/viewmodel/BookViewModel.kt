package com.books.data.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.data.model.Book
import com.books.data.repository.BookRepositoryImpl
import kotlinx.coroutines.launch


class BookViewModel(private val repository: BookRepositoryImpl) : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    fun loadBooks() {
        viewModelScope.launch {
            _books.value = repository.getBooks()
        }
    }
}
