package tech.diggle.energymanager.android.home

import io.reactivex.Single

class GadgetRepository {
    fun getGreeting(): Single<String> {
        return Single.just("Hello from CommonGreetingRepository")
    }

    fun getGadgets(): Single<ArrayList<Gadget>> {
        val list = arrayListOf<Gadget>()
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        list.add(Gadget("Stoff", "le im", 0.3, 30.0))
        return Single.just(list)
    }
}