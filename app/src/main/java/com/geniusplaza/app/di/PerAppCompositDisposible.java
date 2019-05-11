package com.geniusplaza.app.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Muhammad Nouman
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PerAppCompositDisposible {
}
