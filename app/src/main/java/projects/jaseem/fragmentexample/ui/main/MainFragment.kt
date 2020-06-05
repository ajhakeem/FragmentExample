package projects.jaseem.fragmentexample.ui.main

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import projects.jaseem.fragmentexample.R
import projects.jaseem.fragmentexample.state.Resource
import projects.jaseem.fragmentexample.state.ResourceState
import projects.jaseem.fragmentexample.ui.ActivityListener
import projects.jaseem.fragmentexample.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var listener: ActivityListener
    private lateinit var viewModel: MainViewModel
    private lateinit var gridAdapter: GridAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = activity as ActivityListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getItems()
        viewModel.gridLiveData.observe(viewLifecycleOwner, Observer {
            updateItems(it)
        })

        gridAdapter = GridAdapter()
        rvItems.layoutManager = GridLayoutManager(context, 2)
        rvItems.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
                outRect.apply {
                    left = 2
                    top = 2
                    right = 2
                    bottom = 2
                }
            }
        })
        rvItems.adapter = gridAdapter

        bFlicker.setOnClickListener {
            viewModel.getItems()
        }

        bNext.setOnClickListener {
            listener.onNextClicked()
        }
    }

    private fun updateItems(resource: Resource<List<String>>?) {
        resource?.let { rsc ->
            when (rsc.state) {
                ResourceState.LOADING -> {
                    pbLoading.visibility = View.VISIBLE
                }
                ResourceState.SUCCESS -> {
                    rsc.data?.let { items ->
                        pbLoading.visibility = View.GONE
                        gridAdapter.updateItems(items)
                    }
                }
                ResourceState.ERROR -> {
                    pbLoading.visibility = View.GONE
                }
            }
        }
    }

}
