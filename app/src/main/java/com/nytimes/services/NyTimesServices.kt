package com.iii.photoapp.services

import com.google.gson.Gson
import com.nytimes.flows.dashboard.model.NyTimesResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface NyTimesServices {

    @GET("svc/mostpopular/v2/mostviewed/{sections}/{days}.json")
    fun fetchDetails(@Path("sections")sections:String,  @Path("days")days:String, @Query ("api-key") key:String): Observable<NyTimesResponse>

    object NyTimesServicesCreator {
        fun newService(gson: Gson): NyTimesServices {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(interceptor)
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
            httpClientBuilder.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }

            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.nytimes.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClientBuilder.build())
                .build()
            return retrofit.create(NyTimesServices::class.java)
        }
    }
}