package com.books.data.di

import com.books.data.repository.BookRepository
import com.books.data.repository.BookRepositoryImpl
import com.books.data.ui.viewmodel.BookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<BookRepositoryImpl> { BookRepository(get()) }
    viewModel { BookViewModel(get()) }
}