package com.books.data.repository

import com.books.data.model.Book

interface BookRepositoryImpl {
    suspend fun getBooks(): List<Book>
}
