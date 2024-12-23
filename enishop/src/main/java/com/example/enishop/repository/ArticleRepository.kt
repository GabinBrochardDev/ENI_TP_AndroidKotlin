package com.example.enishop.repository

import com.example.enishop.bo.Article
import com.example.enishop.dao.DaoFactory
import com.example.enishop.dao.DaoType

object ArticleRepository {
    val memoryDao = DaoFactory.getDao(DaoType.MEMORY)
    val networkDao = DaoFactory.getDao(DaoType.NETWORK)

    fun getAll() = memoryDao.findAll()
    fun getById(id:Long) = memoryDao.findById(id)

    fun add(article: Article) = memoryDao.insert(article)

    fun addAll(articles: List<Article>) =
        memoryDao.insertAll(articles)

    fun getCategories() = getAll().map { it.category }.distinct()
}