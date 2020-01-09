package com.hadi.apptemplate.users;


import com.hadi.apptemplate.data.RepoRequester;
import com.hadi.apptemplate.di.ScreenScope;
import com.hadi.apptemplate.model.Repo;

import javax.inject.Inject;

@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    public TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester) {
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;

        loadRepos();
    }

    private void loadRepos() {

        repoRequester.getTrendingRepos()
                .doOnSubscribe(__->viewModel.loadingUpdated().accept(true))
                .doOnEvent((d,t)->viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
