package com.hadi.apptemplate.base;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.hadi.apptemplate.di.Injector;

public abstract class BaseController extends Controller {

    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        if(!injected){
            Injector.inject(this);
            injected = true;

        }
        super.onContextAvailable(context);
    }
}
