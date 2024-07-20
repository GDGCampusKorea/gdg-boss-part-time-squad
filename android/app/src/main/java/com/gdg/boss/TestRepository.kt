package com.gdg.boss

import javax.inject.Inject

class TestRepository @Inject constructor(
    private val service: TestApi
) {
    suspend fun sample(): Entity {
        return service.sample()
    }
}
