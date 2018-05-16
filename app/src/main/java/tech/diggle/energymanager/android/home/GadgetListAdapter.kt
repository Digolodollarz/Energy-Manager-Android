package tech.diggle.energymanager.android.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import tech.diggle.energymanager.android.R

class GadgetListAdapter(var gadgets: ArrayList<Gadget>,
                        val context: Context,
                        val listener: RecyclerViewClickListener) : RecyclerView.Adapter<GadgetListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = gadgets[position]
        holder.tvGadgetName.text = item.name
        holder.tvUsage.text = item.usage.toString()
        holder.tvLimits.text = item.limit.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.gadget_card, parent, false)
        return ViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return gadgets.count()
    }


    inner class ViewHolder(view: View, clickListener: RecyclerViewClickListener) : RecyclerView.ViewHolder(view), View.OnClickListener {

        @BindView(R.id.tvGadgetName)
        lateinit var tvGadgetName: TextView

        @BindView(R.id.tvUsage)
        lateinit var tvUsage: TextView

        @BindView(R.id.tvLimits)
        lateinit var tvLimits: TextView

        @BindView(R.id.btnMoreDetails)
        lateinit var btnMoreDetails: Button

        private var viewClickListener: RecyclerViewClickListener? = null


        init {
            ButterKnife.bind(this, view)
            viewClickListener = clickListener
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            viewClickListener?.onClick(v, adapterPosition)
        }
    }

    interface RecyclerViewClickListener {
        fun onClick(view: View, position: Int)
    }
}