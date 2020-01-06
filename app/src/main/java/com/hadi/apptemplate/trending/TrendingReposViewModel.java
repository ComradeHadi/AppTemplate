package com.hadi.apptemplate.trending;

import com.hadi.apptemplate.di.ScreenScope;
import com.hadi.apptemplate.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

@ScreenScope
class TrendingReposViewModel {
    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingReposViewModel(){

    }
}
