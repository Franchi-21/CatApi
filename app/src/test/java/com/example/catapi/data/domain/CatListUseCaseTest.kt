package com.example.catapi.data.domain

import com.example.catapi.BuildConfig
import com.example.catapi.data.domain.entities.ApiService
import com.example.catapi.data.domain.entities.Cat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

internal class CatListUseCaseTest {
    private lateinit var apiServiceMock: ApiService
    private lateinit var catListUseCase: CatListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        apiServiceMock = mockk(relaxed = true)
        catListUseCase = CatListUseCase(apiService = apiServiceMock)
    }

    @Test
    fun `when the response is successful then return its body`() = runBlocking {
        val mockedCatList = Response.success(
            listOf(
                Cat(
                    breeds = emptyList(),
                    categories = emptyList(),
                    height = 0,
                    id = "1",
                    url = "",
                    width = 0,
                ),
            ),
        )

        // Given
        coEvery {
            apiServiceMock.getAllCats(apiKey = BuildConfig.API_KEY, limit = "25")
        } returns mockedCatList

        // When
        val catList = catListUseCase.getAllCats()

        // Then
        assert(catList.first().id == "1")
    }

    @Test
    fun `when the response is null then return an empty list`() = runBlocking {
        val mockedCatList = Response.success<List<Cat>>(null)

        // Given
        coEvery {
            apiServiceMock.getAllCats(apiKey = BuildConfig.API_KEY, limit = "25")
        } returns mockedCatList

        // When
        val catList = catListUseCase.getAllCats()

        // Then
        assert(catList.isEmpty())
    }
}
