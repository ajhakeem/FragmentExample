package projects.jaseem.fragmentexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import projects.jaseem.fragmentexample.MainActivity
import projects.jaseem.fragmentexample.di.main.MainFragmentBuildersModule
import projects.jaseem.fragmentexample.di.main.MainViewModelModule


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuildersModule::class,
            MainViewModelModule::class
        ]
    )
    abstract fun contributesMainActivity(): MainActivity

}