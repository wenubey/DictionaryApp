package com.wenubey.dictionaryapp.presentation

import com.wenubey.dictionaryapp.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)