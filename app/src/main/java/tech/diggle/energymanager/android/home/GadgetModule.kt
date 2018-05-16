package tech.diggle.energymanager.android.home

import dagger.Module
import dagger.Provides
import tech.diggle.energymanager.android.util.SchedulerProvider

@Module
class GadgetModule {
    @Provides
    fun provideRepository() = GadgetRepository()

    @Provides
    fun provideService(repository: GadgetRepository) = GadgetService(repository)

    @Provides
    fun provideViewModelFactory(schedulerProvider: SchedulerProvider, service: GadgetService) = GadgetViewModelFactory(service, schedulerProvider)
}