package com.killqwerty.android.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.killqwerty.android.data.local.dao.SampleDao
import com.killqwerty.android.data.local.entity.SampleEntity

@Database(
    entities = [SampleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class KQDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}