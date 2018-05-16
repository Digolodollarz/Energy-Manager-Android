package tech.diggle.energymanager.android

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import tech.diggle.energymanager.android.di.AppComponent
import tech.diggle.energymanager.android.di.DaggerAppComponent
import javax.inject.Inject

class AndroidApp: Application(), HasActivityInjector, HasFragmentInjector {

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
}