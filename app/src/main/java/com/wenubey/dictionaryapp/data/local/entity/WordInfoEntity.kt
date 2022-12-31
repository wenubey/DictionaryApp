package com.wenubey.dictionaryapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wenubey.dictionaryapp.domain.model.Meaning
import com.wenubey.dictionaryapp.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val phonetic: String?,
    val word: String,
    @PrimaryKey val id: Int? = null,
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            phonetic = phonetic ?: ""
        )
    }
}