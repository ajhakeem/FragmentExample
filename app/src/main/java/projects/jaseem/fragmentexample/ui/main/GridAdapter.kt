package projects.jaseem.fragmentexample.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_item_view.view.*
import projects.jaseem.fragmentexample.R


class GridAdapter : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    private var items = listOf<String>()

    fun updateItems(newItems: List<String>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view, null)
        return GridViewHolder(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.tvText.text = items[position]
    }

    inner class GridViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val tvText = v.tvText
    }

}