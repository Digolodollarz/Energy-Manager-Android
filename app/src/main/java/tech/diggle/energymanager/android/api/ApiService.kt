package tech.diggle.energymanager.android.api

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    fun getJsonResponse(): Single<IpAddress>
}