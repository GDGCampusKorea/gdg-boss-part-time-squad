package com.gdg.boss.partTimeJobPosting

import javax.inject.Inject

class PartTimeJobPostingRepository @Inject constructor(
    private val partTimeJobPostingService: PartTimeJobPostingService
) {
    suspend fun postPartTimeJob(request: PostPartTImeJobParm) {
        return partTimeJobPostingService.postPartTimeJobApi(
            request = request
        )
    }
}
