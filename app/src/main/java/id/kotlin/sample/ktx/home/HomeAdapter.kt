package id.kotlin.sample.ktx.home

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kotlin.sample.ktx.R
import id.kotlin.sample.ktx.home.HomeAdapter.MainHolder
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(
        private val menu: List<String>,
        private val listener: MenuListener
) : Adapter<MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder =
            MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bindView(menu[holder.adapterPosition])
    }

    override fun getItemCount(): Int = menu.size

    inner class MainHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(menuItem: String) {
            itemView.text_menu.text = menuItem
            itemView.rootView.setOnClickListener { listener.onClick(adapterPosition) }
            if (adapterPosition == 2) itemView.divider.visibility = View.GONE
        }
    }

    interface MenuListener {

        fun onClick(position: Int)
    }
}