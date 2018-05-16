package tech.diggle.energymanager.android.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tech.diggle.energymanager.android.MainActivity
import tech.diggle.energymanager.android.MainActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}