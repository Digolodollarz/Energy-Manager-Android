package tech.diggle.energymanager.android.home


import android.annotation.SuppressLint
import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import tech.diggle.energymanager.android.R

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home_fragment.*
import tech.diggle.energymanager.android.AndroidApp
import timber.log.Timber;

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment(), GadgetListAdapter.RecyclerViewClickListener {
    override fun onClick(view: View, position: Int) {
        Timber.d("Wat")
    }

    @Inject
    lateinit var gadgetService: GadgetService

    @Inject
    lateinit var gadgetViewModelFactory: GadgetViewModelFactory

//    @BindView(R.id.rvGadgets) lateinit var rvGadgets: RecyclerView
    private lateinit var mAdapter: GadgetListAdapter
    private var gadgets = ArrayList<Gadget>()

    lateinit var unbinder: Unbinder
    lateinit var viewModel: GadgetViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)
        unbinder = ButterKnife.bind(this, view)

        viewModel = ViewModelProviders.of(this, gadgetViewModelFactory)
                .get(GadgetViewModel::class.java)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = GadgetListAdapter(gadgets, context!!, this)
        rvGadgets.layoutManager = LinearLayoutManager(context)
        rvGadgets.itemAnimator = DefaultItemAnimator()
        rvGadgets.adapter = mAdapter
        viewModel.gadgets.observe(this, Observer { data ->
            if (data != null) {
                mAdapter.gadgets = data
                mAdapter.notifyDataSetChanged()
            }
        })
        getGadgets()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    private fun getGadgets() = viewModel.loadGadgets()
}
