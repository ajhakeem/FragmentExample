package projects.jaseem.fragmentexample.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import projects.jaseem.fragmentexample.di.ViewModelKey
import projects.jaseem.fragmentexample.ui.listfragment.ListViewModel
import projects.jaseem.fragmentexample.ui.main.MainViewModel


@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindsListViewModel(viewModel: ListViewModel): ViewModel

}