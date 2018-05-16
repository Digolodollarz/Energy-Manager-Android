package tech.diggle.energymanager.android.home

import dagger.Provides
import javax.inject.Inject

class GadgetService @Inject constructor(var gadgetRepository: GadgetRepository) {

    fun execute() = gadgetRepository.getGreeting()
}