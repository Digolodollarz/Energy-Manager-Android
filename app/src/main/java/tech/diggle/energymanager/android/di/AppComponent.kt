package tech.diggle.energymanager.android.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import tech.diggle.energymanager.android.AndroidApp
import tech.diggle.energymanager.android.home.GadgetModule
import tech.diggle.energymanager.android.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        GadgetModule::class,
        AppModule::class,
        ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidApp)
    fun inject(homeFragment: HomeFragment)
}