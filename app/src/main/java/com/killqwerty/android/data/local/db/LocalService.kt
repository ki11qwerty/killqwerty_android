package com.killqwerty.android.data.local.db

import com.killqwerty.android.data.local.dao.SampleDao
import com.killqwerty.android.data.local.entity.SampleEntity
import kotlinx.coroutines.flow.Flow

class LocalService(
    private val sampleDao: SampleDao
) {
    suspend fun add(name: String): Long {
        return sampleDao.insert(SampleEntity(name = name))
    }

    fun observeAll(): Flow<List<SampleEntity>> {
        return sampleDao.observeAll()
    }
}