package tech.diggle.energymanager.android

import io.reactivex.Single
import tech.diggle.energymanager.android.api.ApiService
import tech.diggle.energymanager.android.api.IpAddress
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getDataFromApi(): Single<IpAddress> = apiService.getJsonResponse()

}