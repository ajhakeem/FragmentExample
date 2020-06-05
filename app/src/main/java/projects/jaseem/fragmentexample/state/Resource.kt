package projects.jaseem.fragmentexample.state

data class Resource<T> constructor(
    val state: ResourceState,
    val data: T? = null,
    val message: String? = null
)