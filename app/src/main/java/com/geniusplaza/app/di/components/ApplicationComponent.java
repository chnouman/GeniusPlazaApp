package com.geniusplaza.app.di.components;


import com.geniusplaza.app.GeniusPlazaApp;
import com.geniusplaza.app.di.builder.ActivityBuilder;
import com.geniusplaza.app.di.modules.ApplicationModule;
import com.geniusplaza.app.ui.main.MainActivity;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class, ActivityBuilder.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(GeniusPlazaApp momentApp);

        Builder applicationModule(ApplicationModule applicationModule);

        ApplicationComponent build();
    }

    void inject(GeniusPlazaApp momentApp);

}
