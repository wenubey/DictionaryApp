package com.wenubey.dictionaryapp.domain.model

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
)
