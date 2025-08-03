package com.books.data.repository

import android.content.Context
import com.books.data.model.Book
import com.google.gson.Gson

class BookRepository(private val context: Context) : BookRepositoryImpl {
    override suspend fun getBooks(): List<Book> {
        val json = context.assets.open("books.json")
            .bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(json, Array<Book>::class.java).toList()
    }
}
