package tech.diggle.energymanager.android.home


import android.annotation.SuppressLint
import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
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
import tech.diggle.energymanager.android.AndroidApp
import timber.log.Timber;

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var gadgetService: GadgetService

    @Inject
    lateinit var gadgetViewModelFactory: GadgetViewModelFactory

    @BindView(R.id.fragment_hello)
    lateinit var fragmentHelloTextView: TextView

    lateinit var unbinder: Unbinder
    lateinit var viewModel: GadgetViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)
        unbinder = ButterKnife.bind(this, view)

        viewModel = ViewModelProviders.of(this, gadgetViewModelFactory)
                .get(GadgetViewModel::class.java)

        viewModel.gadgets.observe(this, Observer { data -> fragmentHelloTextView.text = data!!.name  })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sayFragmentHello()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    @SuppressLint("SetTextI18n")
    private fun sayFragmentHello() {
        fragmentHelloTextView.text = "THis Is Cheff"
        viewModel.loadGadgets()
    }
}
