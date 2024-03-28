package com.newproject.calculator.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Calculation::class],
    version = 1
)
abstract class CalculationDatabase : RoomDatabase() {

    abstract val dao : CalculationDao


}