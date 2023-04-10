package com.arghamnegargroup.core.features.department.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.department.domain.model.Department


@Dao
interface DepartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDepartment(entity: Department)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDepartments(entities: List<Department>)

    @Query("DELETE FROM department")
    suspend fun deleteDepartments()

    @Query("SELECT * FROM department")
    suspend fun getDepartments(): List<Department>

}