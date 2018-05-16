package tech.diggle.energymanager.android.home

import io.reactivex.Single

class GadgetRepository{
    fun getGreeting(): Single<String> {
        return Single.just("Hello from CommonGreetingRepository")
    }

}