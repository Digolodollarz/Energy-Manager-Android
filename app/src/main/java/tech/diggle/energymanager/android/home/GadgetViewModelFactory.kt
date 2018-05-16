package tech.diggle.energymanager.android.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import tech.diggle.energymanager.android.util.SchedulerProvider

class GadgetViewModelFactory(val service: GadgetService, val schedulerProvider: SchedulerProvider) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GadgetViewModel::class.java))
            return GadgetViewModel(service, schedulerProvider) as T
        throw IllegalArgumentException("Eh What?")
    }
}