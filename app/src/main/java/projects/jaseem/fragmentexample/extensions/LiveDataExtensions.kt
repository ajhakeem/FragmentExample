package projects.jaseem.fragmentexample.extensions

import androidx.lifecycle.MutableLiveData
import projects.jaseem.fragmentexample.state.Resource
import projects.jaseem.fragmentexample.state.ResourceState

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(errorMessage: String? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            errorMessage
        )
    )