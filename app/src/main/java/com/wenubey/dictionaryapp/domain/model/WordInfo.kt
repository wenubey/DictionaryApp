package com.wenubey.dictionaryapp.domain.model

data class WordInfo(
    val word: String,
    val meanings: List<Meaning>,
    val phonetic: String,
)