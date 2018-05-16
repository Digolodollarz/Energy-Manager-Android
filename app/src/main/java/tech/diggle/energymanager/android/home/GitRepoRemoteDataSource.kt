package tech.diggle.energymanager.android.home

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GitRepoRemoteDataSource {

    fun getRepositories() : Observable<ArrayList<Gadget>> {
        var arrayList = ArrayList<Gadget>()
        arrayList.add(Gadget("First from remote", "Owner 1", 100.0, 445.3))
        arrayList.add(Gadget("Second from remote", "Owner 2", 30.0, 445.3))
        arrayList.add(Gadget("Third from remote", "Owner 3", 430.0, 445.3))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }
}