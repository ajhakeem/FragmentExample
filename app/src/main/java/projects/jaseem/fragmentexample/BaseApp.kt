package projects.jaseem.fragmentexample

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import projects.jaseem.fragmentexample.di.DaggerAppComponent

class BaseApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}