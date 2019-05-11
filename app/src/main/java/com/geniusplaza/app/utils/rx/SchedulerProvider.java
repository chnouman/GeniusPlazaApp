package com.geniusplaza.app.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Muhammad Nouman.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

    Scheduler newThread();

}
