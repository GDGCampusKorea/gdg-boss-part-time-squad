package com.gdg.boss

import retrofit2.http.*

interface TestApi {
    @GET("/test")
    suspend fun sample(): Entity
}
