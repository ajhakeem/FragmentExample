package projects.jaseem.fragmentexample.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import projects.jaseem.fragmentexample.viewmodels.ViewModelProviderFactory


@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}