package tech.diggle.energymanager.android.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposables
import tech.diggle.energymanager.android.util.SchedulerProvider

class GadgetViewModel(val service: GadgetService, val schedulerProvider: SchedulerProvider) : ViewModel() {
    val gadgets: MutableLiveData<Gadget> = MutableLiveData()
    val disposables = CompositeDisposable()
    val TAG = "tech.diggle.GVM"

    override fun onCleared() {
        super.onCleared()
    }

    fun gadgets() = gadgets

    fun loadGadgets() {
        disposables.add(service.execute()
                .subscribeOn(schedulerProvider.backgroundScheduler)
                .observeOn(schedulerProvider.foregroundScheduler)
                .doOnSubscribe { _ -> Log.d(TAG, "Getting them gadgets") }
                .subscribe({ _ ->
                    gadgets.value = Gadget("Stoff", "le im", 0.3)
                }, { error -> Log.e(TAG, "loadGadgets", error) }))
    }
}