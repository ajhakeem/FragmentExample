package projects.jaseem.fragmentexample.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import projects.jaseem.fragmentexample.ui.main.MainFragment


@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

}