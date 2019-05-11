package com.geniusplaza.app.data;

import com.geniusplaza.app.data.db.DbHelper;
import com.geniusplaza.app.data.prefs.PreferencesHelper;
import com.geniusplaza.app.data.remote.ApiHelper;

import java.util.Map;

import io.reactivex.Observable;

public interface DataManager extends DbHelper, ApiHelper, PreferencesHelper {
    void syncAnonymously(Map<String, Object> map);

    Map<String, Object> getDeviceDetails();

    Observable<Boolean> syncMixPanel();

    Observable<ExperimentalGroupResponse> checkToEnrollInExperimentGroup();

    Observable<Boolean> startSyncingAppPickups();
}
