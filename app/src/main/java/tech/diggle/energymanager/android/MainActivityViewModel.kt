package tech.diggle.energymanager.android

import io.reactivex.Single
import tech.diggle.energymanager.android.api.IpAddress
import tech.diggle.energymanager.android.util.SchedulerProvider

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<IpAddress> = repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())
}