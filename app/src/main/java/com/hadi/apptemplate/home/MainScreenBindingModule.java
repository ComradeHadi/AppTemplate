package com.hadi.apptemplate.home;

import com.bluelinelabs.conductor.Controller;
import com.hadi.apptemplate.di.ControllerKey;
import com.hadi.apptemplate.trending.TrendingReposComponent;
import com.hadi.apptemplate.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TrendingReposComponent.class})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
