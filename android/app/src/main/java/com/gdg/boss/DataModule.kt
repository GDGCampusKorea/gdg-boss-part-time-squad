package com.gdg.boss

import com.gdg.boss.partTimeJobPosting.PartTimeJobPostingService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .build()

            chain.proceed(newRequest)
        }

        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.connectTimeout(10, TimeUnit.SECONDS)

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(
        retrofit: Retrofit
    ): TestApi = retrofit.create(TestApi::class.java)

    @Singleton
    @Provides
    fun providePartTimeJobPostingService(
        retrofit: Retrofit
    ): PartTimeJobPostingService = retrofit.create(PartTimeJobPostingService::class.java)
}
