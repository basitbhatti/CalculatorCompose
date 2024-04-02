package com.newproject.calculator.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalculationDao {

    @Insert()
    suspend fun upsert(calculation: Calculation)

    @Delete
    suspend fun delete(calculation: Calculation)

    @Query("SELECT * FROM calculations_table")
    fun getCalculations(): List<Calculation>

}