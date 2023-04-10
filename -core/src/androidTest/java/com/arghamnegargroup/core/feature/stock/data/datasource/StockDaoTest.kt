package com.arghamnegargroup.core.feature.stock.data.datasource

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.stock.data.datasource.StockDao
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class StockDaoTest {

    private lateinit var database: BaranDatabase
    private lateinit var dao: StockDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BaranDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.stockDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertStocks() = runTest {
        val stocks = listOf(
            Stock("1", "A"),
            Stock("2", "B"),
            Stock("3", "C"),
        )
        stocks.forEach { stock -> dao.saveStock(stock) }

        val allStocks = dao.getStocks()
        assertThat(allStocks).isEqualTo(stocks)
    }
}