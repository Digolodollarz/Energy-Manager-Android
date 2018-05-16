package tech.diggle.energymanager.android;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import tech.diggle.energymanager.android.home.HomeFragment;
import tech.diggle.energymanager.android.util.SchedulerProvider;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract HomeFragment provideHomeFragmentFactory();

    @Provides
    static MainActivityViewModel  provideViewModel(Repository repository,SchedulerProvider schedulerProvider){
        return new MainActivityViewModel(repository, schedulerProvider);
    }

}