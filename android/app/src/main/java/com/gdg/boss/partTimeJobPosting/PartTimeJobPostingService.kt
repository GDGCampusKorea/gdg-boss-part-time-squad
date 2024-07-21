package com.gdg.boss.partTimeJobPosting

import retrofit2.http.Body
import retrofit2.http.POST

interface PartTimeJobPostingService {

    @POST("/recruit-posts/")
    suspend fun postPartTimeJobApi(
        @Body request : PostPartTImeJobParm
    )
}