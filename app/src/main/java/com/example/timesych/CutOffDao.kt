package com.example.timesych

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CutOffDao {

    // Вставка данных в базу
    @Insert
    suspend fun insert(cutOffData: CutOffTime)
    
// Получение последней записи (для примера)
//    @Query("SELECT * FROM cutoff_times ORDER BY id DESC LIMIT 1")
//    suspend fun getLast(): CutOffTime
//
//    // Вставить новое время отсечки
//    @Insert
//    suspend fun insertCutOffTime(cutOffTime: CutOffTime)



    @Query("SELECT * FROM cutoff_times")
    public abstract suspend fun getAll(): List<CutOffTime>

    @Query("SELECT MAX(number) FROM cutoff_times")
    suspend fun getMaxListNumber(): Int?

    @Query("DELETE FROM cutoff_times WHERE number = :listNumber")
    suspend fun deleteByListNumber(listNumber: Int)

    @Query("DELETE FROM cutoff_times")
    suspend fun deleteAll()
//
//    // Обновить текст для конкретной отсечки
//    @Update
//    suspend fun updateCutOffText(cutOffTime: CutOffTime)
//
//    @Query("SELECT * FROM cutoff_times WHERE id IN (:userIds)")
//    suspend fun loadAllByIds(userIds: IntArray): List<CutOffTime>
//
//    @Delete // изменить удалять по id
//    suspend fun delete(cutOffTime: CutOffTime)
}
