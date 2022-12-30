package com.wenubey.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.wenubey.dictionaryapp.data.local.Converters
import com.wenubey.dictionaryapp.data.local.WordInfoDatabase
import com.wenubey.dictionaryapp.data.remote.DictionaryApi
import com.wenubey.dictionaryapp.data.repository.DictionaryRepository
import com.wenubey.dictionaryapp.data.util.GsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object DictionaryInfoModule {

    @Provides
    @Singleton
    fun provideDictionaryRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ) : DictionaryRepository {
        return DictionaryRepository(api = api, dao = db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}