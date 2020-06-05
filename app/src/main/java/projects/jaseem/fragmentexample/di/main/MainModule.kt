package projects.jaseem.fragmentexample.di.main

import dagger.Module
import dagger.Provides
import projects.jaseem.fragmentexample.di.network.MainApi
import retrofit2.Retrofit


@Module
class MainModule {

    @Provides
    fun providesMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }

}