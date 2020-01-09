package com.hadi.apptemplate.users;

import com.hadi.apptemplate.R;
import com.hadi.apptemplate.di.ScreenScope;
import com.hadi.apptemplate.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

import io.reactivex.Observable;
import timber.log.Timber;

@ScreenScope
class TrendingReposViewModel {
    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingReposViewModel(){


    }

    //Exposing the BehaviourRelays to the views as observables

    Observable<List<Repo>> repos(){
        return reposRelay;
    }

    Observable<Integer> error(){
        return errorRelay;
    }

    Observable<Boolean> loading(){
        return loadingRelay;
    }



    //Passing on data to our presenters

    Consumer<List<Repo>> reposUpdated(){
        errorRelay.accept(-1);
        return reposRelay;

    }

    Consumer<Boolean> loadingUpdated(){

        return loadingRelay;

    }

    Consumer<Throwable> onError(){
        return throwable -> {

            Timber.e(throwable, "Error loading repos");
            errorRelay.accept(R.string.relay_error_int);

        };
    }
}
