package com.gdg.boss.partTimeJobPosting

data class PostPartTImeJobParm (
    val title: String,
    val content: String,
    val workTime: String,
    val hourlyWage: Int,
    val location: String,
)