package com.killqwerty.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.killqwerty.android.data.local.entity.SampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: SampleEntity): Long

    @Query("SELECT * FROM sample_items ORDER BY id DESC")
    fun observeAll(): Flow<List<SampleEntity>>
}