package projects.jaseem.fragmentexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import projects.jaseem.fragmentexample.extensions.setError
import projects.jaseem.fragmentexample.extensions.setLoading
import projects.jaseem.fragmentexample.extensions.setSuccess
import projects.jaseem.fragmentexample.state.Resource
import javax.inject.Inject

class MainViewModel
@Inject constructor() : ViewModel() {

    val gridLiveData = MutableLiveData<Resource<List<String>>>()
    private val compositeDisposable = CompositeDisposable()

    val items = listOf(
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen"
    )

    fun getItems() {
        compositeDisposable.add(
            Single.just(items.shuffled())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    gridLiveData.setLoading()
                }
                .subscribe({
                    gridLiveData.setSuccess(it)
                }, {
                    gridLiveData.setError(it.message)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
