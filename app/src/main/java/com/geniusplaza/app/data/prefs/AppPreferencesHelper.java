package com.geniusplaza.app.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.geniusplaza.app.di.ApplicationContext;
import com.geniusplaza.app.di.PreferenceInfo;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_INSTALL_DATE = "INSTALL_DATE";
    private static final String PREF_FIRST_LAUNCH = "PREF_FIRST_LAUNCH";
    private static final String PREF_PURCHASEDPREMIUM_DATE = "PREF_PURCHASEDPREMIUM_DATE";
    private static final String PREF_SHOWNTHANKYOUFOR_BUYING_PRO = "PREF_SHOWNTHANKYOUFOR_BUYING_PRO";
    private static final String PREF_SHOWNTHANKYOU_FOR_BUYING_PREMIUM = "PREF_SHOWNTHANKYOU_FOR_BUYING_PREMIUM";
    private static final String PREF_PITCHED_PREMIUM_WITH_PERCETILE_RANK = "PREF_PITCHED_PREMIUM_WITH_PERCETILE_RANK";
    private static final String PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_THOUSAND_MINUTES = "PREF_PITCHED_COACH_THOUSAND_MINUTES";
    private static final String PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_HUNDRED_THOUSAND_MINUTES = "PREF_PITCHED_COACH_HUNDRED_THOUSAND_MINUTES";
    private static final String PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_FIFTY_THOUSAND_MINUTES = "PREF_PITCHED_COACH_FIFTY_THOUSAND_MINUTES";
    private static final String PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_TEN_THOUSAND_MINUTES = "PREF_PITCHED_COACH_TEN_THOUSAND_MINUTES";
    private final SharedPreferences mPrefs;
    private final static String PREF_DAILYLIMIT_SOUND = "PREF_DAILYLIMIT_SOUND";
    private final static String PREF_DAILYLIMIT_VALUE = "PREF_DAILYLIMIT_VALUE";
    private final static String PREF_DAILYLIMIT_SOUND_URI = "PREF_DAILYLIMIT_SOUND_URI";
    private final static String PREF_PICKUPS_SOUND = "PREF_PICKUPS_SOUND";
    private final static String PREF_PICKUPS_SOUND_VALUE = "PREF_PICKUPS_SOUND_VALUE";
    private final static String PREF_PICKUPS_SOUND_URI = "PREF_PICKUPS_SOUND_URI";
    private final static String PREF_PICKUPS_GOAL_TIME = "PREF_PICKUPS_GOAL_TIME";
    private final static String PREF_TINYREMINDER_TIME = "PREF_TINYREMINDER_TIME";
    private final static String PREF_TINYREMINDER_SOUND = "PREF_TINYREMINDER_SOUND";
    private final static String PREF_TINYREMINDER_SOUND_URI = "PREF_TINYREMINDER_SOUND_URI";
    private final static String PREF_PURCHASED_VALUE = "PREF_PURCHASED_VALUE";
    private final static String PREF_IN_APP_SUBSCRIPTION_PURCHASED_VALUE = "PREF_IN_APP_SUBSCRIPTION_PURCHASED_VALUE";

    private final static String PREF_DAILYLIMIT_FORCEMEOVER_VALUE = "PREF_DAILYLIMIT_FORCEMEOVER_VALUE";
    private final static String PREF_SCREEN_FREEN_TIME_OFF = "PREF_SCREEN_FREEN_TIME_OFF";
    private final static String PREF_SCREEN_FREEN_TIME_SCHEDULE = "PREF_SCREEN_FREEN_TIME_SCHEDULE";
    private final static String PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_FROM = "PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_FROM";
    private final static String PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_TO = "PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_TO";
    private final static String PREF_SCREEN_FREEN_TIME_SCHEDULE_FROM = "PREF_SCREEN_FREEN_TIME_SCHEDULE_FROM";
    private final static String PREF_SCREEN_FREEN_TIME_SCHEDULE_TO = "PREF_SCREEN_FREEN_TIME_SCHEDULE_TO";
    private final static String PREF_BRILLIANTCOURSE = "PREF_BRILLIANTCOURSE";
    private final static String PREF_SCREEN_TIME_DETECTION_STATUS = "PREF_SCREEN_TIME_DETECTION_STATUS";
    private final static String PREF_SCREEN_TIME_DETECTION_SCHEDULE = "PREF_SCREEN_TIME_DETECTION_SCHEDULE";
    private final static String PREF_SCREEN_TIME_DETECTION_SCHEDULE_FROM = "PREF_SCREEN_TIME_DETECTION_SCHEDULE_FROM";
    private final static String PREF_SCREEN_TIME_DETECTION_SCHEDULE_TO = "PREF_SCREEN_TIME_DETECTION_SCHEDULE_TO";
    private final static String PREF_SCREEN_TIME_DETECTION_DISABLE_TIME = "PREF_SCREEN_TIME_DETECTION_DISABLE_TIME";
    private final static String PREF_INSIGHT_NOTIFICATION_SCHEDULE = "PREF_INSIGHT_NOTIFICATION_SCHEDULE";
    private final static String PREF_SIMPLE_MODE_ENABLED = "PREF_SIMPLE_MODE_SCHEDULE_ENABLED";
    private final static String PREF_SIMPLE_MODE_SCHEDULE = "PREF_SIMPLE_MODE_SCHEDULE";
    private final static String PREF_SIMPLE_MODE_SCHEDULE_FROM = "PREF_SIMPLE_MODE_SCHEDULE_FROM";
    private final static String PREF_SIMPLE_MODE_SCHEDULE_DEFAULT_LAUNCHER = "PREF_SIMPLE_MODE_SCHEDULE_DEFAULT_LAUNCHER";
    private final static String PREF_SIMPLE_MODE_SCHEDULE_TO = "PREF_SIMPLE_MODE_SCHEDULE_TO";
    private final static String PREF_SIMPLE_MODE_MANUAL_END = "PREF_SIMPLE_MODE_MANUAL_END";
    private final static String PREF_FOCUSING_GOALS = "PREF_FOCUSING_GOALS";
    //GOALS ACTIVATERS
    private final static String PREF_HAVE_A_PICKUP_GOAL = "PREF_HAVE_A_PICKUP_GOAL";
    private final static String PREF_HAVE_A_SCREENTIME_GOAL = "PREF_HAVE_A_SCREENTIME_GOAL";
    //NUDGET
    private final static String PREF_NUDGE_ME_FOR_PICKUPS = "PREF_NUDGE_ME_FOR_PICKUPS";
    private final static String PREF_NUDGE_ME_FOR_SCREENTIME = "PREF_NUDGE_ME_FOR_SCREENTIME";
    //Goal Values
    private final static String PREF_PICKUPS_GOAL_VALUE = "PREF_PICKUPS_GOAL_VALUE";
    private final static String PREF_ON_BOARDING = "PREF_ON_BOARDING";
    private final static String PREF__PITCHEDPREMIUMWITHCOMPARISION = "PREF__PITCHEDPREMIUMWITHCOMPARISION";
    private final static String PREF__DELAYMARKETINGPROMPTSUNTIL = "PREF__DELAYMARKETINGPROMPTSUNTIL";

    private static final String IS_TWEAK_SET = "IS_TWEAK_SET";

    private static final String APP_LIMIT_MODE_ON = "APP_LIMIT_MODE_ON";
    private static final String ANY_APP_LIMIT_CATEGORY_SELECTED = "ANY_APP_LIMIT_CATEGORY_SELECTED";

    private static final String CURRENT_FOREGROUND_PACKAGE = "CURRENT_FOREGROUND_PACKAGE";
    private final static String PREF__SHOWCOUNTERUNTIL = "PREF__SHOWCOUNTERUNTIL";

    private final static String PREF__GOALCONGRATULATIONS_SHOWUNTIL = "PREF__GOALCONGRATULATIONS_SHOWUNTIL";
    private final static String PREF__ASKFORSUBSCRIBE = "PREF__ASKFORSUBSCRIBE";

    private final static String PREF_SHOULD_ASK_FOR_REVIEEW_AFTER_DAYS = "PREF_SHOULD_ASK_FOR_REVIEEW_AFTER_DAYS";
    private final static String PREF_SHOULD_ASK_FOR_REVIEW = "PREF_SHOULD_ASK_FOR_REVIEW";

    private final static String PREF_ONBOARD_EMAIL = "PREF_ONBOARD_EMAIL";

    private final static String PREF_LAST_ANONYMOUS_SYNC_TIME = "PREF_LAST_ANONYMOUS_SYNC_TIME";

    private final static String PREF_EXPERIMENTAL_GROUP = "PREF_EXPERIMENTAL_GROUP";

    private static final String NOTIFICATION_DEFAULT_MODE = "NOTIFICATION_DEFAULT_MODE";
    private static final String SHOULD_SHOW_NOTIFICATION_DEFAULT_OFF_SCREEN = "SHOULD_SHOW_NOTIFICATION_DEFAULT_OFF_SCREEN";

    private static final String SHOULD_SHOW_APPLIMIT_SETTING_SCREEN = "SHOULD_SHOW_APPLIMIT_SETTING_SCREEN";

    private static final String PREF_DEVICE_VENDOR_ID = "PREF_DEVICE_VENDOR_ID";

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void setAppInstalDate() {
        mPrefs.edit().putString(PREF_INSTALL_DATE, new Date().getTime() + "").apply();
    }

    @Override
    public Date getAppInstalDate() {
        return new Date(Long.valueOf(mPrefs.getString(PREF_INSTALL_DATE, "-1")));
    }

    @Override
    public String getTinyReminderSelectedSound() {
        return mPrefs.getString(PREF_TINYREMINDER_SOUND, AppConstants.DEFAULT_TINYLIMIT_SOUND);
    }

    @Override
    public void setTinyReminderSelectedSound(String tinyReminderSelectedSound) {
        mPrefs.edit().putString(PREF_TINYREMINDER_SOUND, tinyReminderSelectedSound).apply();
    }

    @Override
    public String getDailyLimitSelectedSound() {
        return mPrefs.getString(PREF_DAILYLIMIT_SOUND, AppConstants.DEFAULT_DAILYLIMIT_SOUND);
    }

    @Override
    public void setDailyLimitSelectedSound(String dailyLimitSelectedSound) {
        mPrefs.edit().putString(PREF_DAILYLIMIT_SOUND, dailyLimitSelectedSound).apply();

    }

    @Override
    public String getTinyReminderTime() {
        return mPrefs.getString(PREF_TINYREMINDER_TIME, AppConstants.DEFAULT_TINYREMINDER_TIME);
    }

    @Override
    public void setTinyReminderTime(String tinyReminderTime) {
        mPrefs.edit().putString(PREF_TINYREMINDER_TIME, tinyReminderTime).apply();
    }

    @Override
    public String getDailyLimit() {
        return mPrefs.getString(PREF_DAILYLIMIT_VALUE, AppConstants.DEFAULT_DAILYLIMIT_LIMIT);
    }

    @Override
    public void setDailyLimit(String dailyLimit) {
        mPrefs.edit().putString(PREF_DAILYLIMIT_VALUE, dailyLimit).apply();

    }

    @Override
    public boolean getForceMeOffValue() {
        return mPrefs.getBoolean(PREF_DAILYLIMIT_FORCEMEOVER_VALUE, true);
    }

    @Override
    public void setForceMeOffValue(boolean forceMeOffValue) {
        putBoolean(PREF_DAILYLIMIT_FORCEMEOVER_VALUE, forceMeOffValue);

    }


    @Override
    public boolean isPurchased() {
        return getBoolsElseFalse(PREF_PURCHASED_VALUE);
    }

    @Override
    public void setPurchased(boolean purchased) {
        putBoolean(PREF_PURCHASED_VALUE, purchased);
    }

    @Override
    public boolean isInAppSubsPurchased() {
        return getBoolsElseFalse(PREF_IN_APP_SUBSCRIPTION_PURCHASED_VALUE);
    }

    @Override
    public void setInAppSubsPurchased(boolean purchased) {
        putBoolean(PREF_IN_APP_SUBSCRIPTION_PURCHASED_VALUE, purchased);
    }

    @Override
    public ArrayList<SoundPOJO> getDailyLimitSounds() {

        String favourtie = getDailyLimitSelectedSound();

        ArrayList<SoundPOJO> soundPOJOArrayList = new ArrayList<>();
        soundPOJOArrayList.add(new SoundPOJO("Pop", "" + R.raw.pop, false));
        soundPOJOArrayList.add(new SoundPOJO("Peeper", "" + R.raw.peeper, false));
        soundPOJOArrayList.add(new SoundPOJO("Chuckle", "" + R.raw.chuckle, false));
        soundPOJOArrayList.add(new SoundPOJO("Bowl", "" + R.raw.bowl, false));
        soundPOJOArrayList.add(new SoundPOJO("Chirp", "" + R.raw.chirp, false));
        soundPOJOArrayList.add(new SoundPOJO("Thunder", "" + R.raw.thunder, false));
        soundPOJOArrayList.add(new SoundPOJO("Siren", "" + R.raw.siren, false));
        soundPOJOArrayList.add(new SoundPOJO("Dumb & Dumber", "" + R.raw.dumber, false));
        soundPOJOArrayList.add(new SoundPOJO("Buzzer", "" + R.raw.buzzer, false));
        soundPOJOArrayList.add(new SoundPOJO("Alarm Clock", "" + R.raw.alarmclock, false));
        soundPOJOArrayList.add(new SoundPOJO("Most Annoying Sound Ever", "" + R.raw.annoying, false));
        soundPOJOArrayList.add(new SoundPOJO("Silence", "" + R.raw.silence, false));

        if (favourtie != null) {
            for (int i = 0; i < soundPOJOArrayList.size(); i++) {
                if (soundPOJOArrayList.get(i).getTitle().equals(favourtie)) {
                    soundPOJOArrayList.get(i).setSelected(true);
                }
            }
        }

        return soundPOJOArrayList;
    }

    @Override
    public ArrayList<SoundPOJO> getTinyReminderSounds() {
        String favourtie = getTinyReminderSelectedSound();
        ArrayList<SoundPOJO> soundPOJOArrayList = new ArrayList<>();
        soundPOJOArrayList.add(new SoundPOJO("Pop", "" + R.raw.pop, false));
        soundPOJOArrayList.add(new SoundPOJO("Peeper", "" + R.raw.peeper, false));
        soundPOJOArrayList.add(new SoundPOJO("Chuckle", "" + R.raw.chuckle, false));
        soundPOJOArrayList.add(new SoundPOJO("Bowl", "" + R.raw.bowl, false));
        soundPOJOArrayList.add(new SoundPOJO("Chirp", "" + R.raw.chirp, false));
        soundPOJOArrayList.add(new SoundPOJO("Thunder", "" + R.raw.thunder, false));
        soundPOJOArrayList.add(new SoundPOJO("Siren", "" + R.raw.siren, false));
        soundPOJOArrayList.add(new SoundPOJO("Dumb & Dumber", "" + R.raw.dumber, false));
        soundPOJOArrayList.add(new SoundPOJO("Buzzer", "" + R.raw.buzzer, false));
        soundPOJOArrayList.add(new SoundPOJO("Alarm Clock", "" + R.raw.alarmclock, false));
        soundPOJOArrayList.add(new SoundPOJO("Most Annoying Sound Ever", "" + R.raw.annoying, false));
        soundPOJOArrayList.add(new SoundPOJO("Silence", "" + R.raw.silence, false));

        if (favourtie != null) {
            for (int i = 0; i < soundPOJOArrayList.size(); i++) {
                if (soundPOJOArrayList.get(i).getTitle().equals(favourtie)) {
                    soundPOJOArrayList.get(i).setSelected(true);
                }
            }
        }
        return soundPOJOArrayList;
    }

    @Override
    public ArrayList<SoundPOJO> getPickupsGoalsReminderSounds() {
        String favourtie = getPickupsGoalSound();
        ArrayList<SoundPOJO> soundPOJOArrayList = new ArrayList<>();
        soundPOJOArrayList.add(new SoundPOJO("Pop", "" + R.raw.pop, false));
        soundPOJOArrayList.add(new SoundPOJO("Peeper", "" + R.raw.peeper, false));
        soundPOJOArrayList.add(new SoundPOJO("Chuckle", "" + R.raw.chuckle, false));
        soundPOJOArrayList.add(new SoundPOJO("Bowl", "" + R.raw.bowl, false));
        soundPOJOArrayList.add(new SoundPOJO("Chirp", "" + R.raw.chirp, false));
        soundPOJOArrayList.add(new SoundPOJO("Thunder", "" + R.raw.thunder, false));
        soundPOJOArrayList.add(new SoundPOJO("Siren", "" + R.raw.siren, false));
        soundPOJOArrayList.add(new SoundPOJO("Dumb & Dumber", "" + R.raw.dumber, false));
        soundPOJOArrayList.add(new SoundPOJO("Buzzer", "" + R.raw.buzzer, false));
        soundPOJOArrayList.add(new SoundPOJO("Alarm Clock", "" + R.raw.alarmclock, false));
        soundPOJOArrayList.add(new SoundPOJO("Most Annoying Sound Ever", "" + R.raw.annoying, false));
        soundPOJOArrayList.add(new SoundPOJO("Silence", "" + R.raw.silence, false));

        if (favourtie != null) {
            for (int i = 0; i < soundPOJOArrayList.size(); i++) {
                if (soundPOJOArrayList.get(i).getTitle().equals(favourtie)) {
                    soundPOJOArrayList.get(i).setSelected(true);
                }
            }
        }
        return soundPOJOArrayList;
    }

    @Override
    public int getDailyLimitSelectedSoundURI() {
        return mPrefs.getInt(PREF_DAILYLIMIT_SOUND_URI, R.raw.alarmclock);
    }

    @Override
    public void setDailyLimitSelectedSoundURI(int uri) {
        mPrefs.edit().putInt(PREF_DAILYLIMIT_SOUND_URI, uri).apply();
    }

    @Override
    public int getTinyReminderSelectedSoundURI() {
        return mPrefs.getInt(PREF_TINYREMINDER_SOUND_URI, R.raw.bowl);
    }

    @Override
    public void setTinyReminderSelectedSoundURI(int uri) {
        mPrefs.edit().putInt(PREF_TINYREMINDER_SOUND_URI, uri).apply();
    }

    @Override
    public ArrayList<WhatsNew> getWhatsNewList() {

        ArrayList<WhatsNew> whatsNewArrayList = new ArrayList<>();
        ArrayList<Detail> details = new ArrayList<>();
        details.add(new Detail("setting_getting_screen_free_time", "App Tracking - The #1 requested feature is here! Moment now keeps track of which apps you use almost automatically."));
        details.add(new Detail("setting_getting_screen_free_time", "Coach - Build better habits around your screen time. The first course is a 14-day phone bootcamp to make you rethink your relationship with your phone."));
        details.add(new Detail("setting_getting_screen_free_time", "Settings - A much needed overhaul of the settings. Now it looks pretty!"));

        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.0", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.0.1", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.0.2", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.0.3", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.1", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.1.1", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.2", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.2.1", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.3", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.4.1", details));
        whatsNewArrayList.add(new WhatsNew("setting_getting_screen_free_time", "3.4.2", details));
        return whatsNewArrayList;
    }

    @Override
    public ArrayList<Lesson> getBrilliantCourse() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson("Observe Yourself", "Today", false));
        lessons.add(new Lesson("Keep Your Devices out of Reach", "Day 2", false));
        lessons.add(new Lesson("Photo-Free Day", "Day 3", false));
        lessons.add(new Lesson("Delete That App", "Day 4", false));
        lessons.add(new Lesson("Take a Fakecation", "Day 5", false));
        lessons.add(new Lesson("Observe Something Else", "Day 6", false));
        lessons.add(new Lesson("Get Bored & Brilliant", "Day 7", false));
        return lessons;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }


    @Override
    public boolean isScreenFreeTimeOffActivated() {
        return mPrefs.getBoolean(PREF_SCREEN_FREEN_TIME_OFF, true);
    }

    @Override
    public void setScreenFreeTimeOffActivated(boolean screenFreeTimeOff) {
        putBoolean(PREF_SCREEN_FREEN_TIME_OFF, screenFreeTimeOff);
    }

    @Override
    public String getScreenFreeTimeFromTime() {
        return getStringElseNull(PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_FROM);
    }

    @Override
    public void setScreenFreeTimeFromTime(String dateString) {
        mPrefs.edit().putString(PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_FROM, dateString).apply();
    }

    @Override
    public String getScreenFreeTimeToTime() {
        return getStringElseNull(PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_TO);
    }

    @Override
    public void setScreenFreeTimeToTime(String dateString) {
        mPrefs.edit().putString(PREF_SCREEN_FREEN_TIME_SCHEDULE_MANUAL_MINUTES_TO, dateString).apply();
    }

    @Override
    public boolean getScreenFreeTimeScheduleSwitch() {
        return getBoolsElseFalse(PREF_SCREEN_FREEN_TIME_SCHEDULE);
    }

    @Override
    public void setScreenFreeTimeScheduleSwitch(boolean screenFreeTimeSchedule) {
        mPrefs.edit().putBoolean(PREF_SCREEN_FREEN_TIME_SCHEDULE, screenFreeTimeSchedule).apply();
    }

    @Override
    public String getScreenFreeTimeScheduleFrom() {

        //If it is not off then it means that use ass added 5 or 30 mintues in screenFree Time.
        return mPrefs.getString(PREF_SCREEN_FREEN_TIME_SCHEDULE_FROM, getScheduleDefaultFromTime());

    }

    @Override
    public void setScreenFreeTimeScheduleFrom(String screenFreeTimeScheduleFrom) {
        mPrefs.edit().putString(PREF_SCREEN_FREEN_TIME_SCHEDULE_FROM, screenFreeTimeScheduleFrom).apply();
    }

    @Override
    public String getScreenFreeTimeScheduleTo() {

        return mPrefs.getString(PREF_SCREEN_FREEN_TIME_SCHEDULE_TO, getScheduleDefaultToTime());

    }

    @Override
    public void setScreenFreeTimeScheduleTo(String screenFreeTimeScheduleTo) {
        mPrefs.edit().putString(PREF_SCREEN_FREEN_TIME_SCHEDULE_TO, screenFreeTimeScheduleTo).apply();
    }


    @Override
    public boolean isScreenTimeDetectionEnabled() {
        return mPrefs.getBoolean(PREF_SCREEN_TIME_DETECTION_STATUS, true);
    }

    @Override
    public void setScreenTimeDetectionEnabled(boolean enabled) {
        putBoolean(PREF_SCREEN_TIME_DETECTION_STATUS, enabled);
    }


    @Override
    public boolean isScreenTimeDetectionSchedule() {
        return getBoolsElseFalse(PREF_SCREEN_TIME_DETECTION_SCHEDULE);
    }

    @Override
    public void setScreenTimeDetectionSchedule(boolean schedule) {
        putBoolean(PREF_SCREEN_TIME_DETECTION_SCHEDULE, schedule);
    }

    @Override
    public String getScreenTimeDetectionScheduleFrom() {


        String fromDate = getStringElseNull(PREF_SCREEN_TIME_DETECTION_SCHEDULE_FROM);

        if (fromDate == null) {
            Date dateAndTimeFrom = formatTime(DateUtility.getDateByToday(0), AppConstants.DEFAULT_SCHEDULE_TIME_FROM, formatterDateTime_12h);
            return formatterDateTime_12h.format(dateAndTimeFrom);
        }

        return fromDate;
    }

    @Override
    public void setScreenTimeDetectionScheduleFrom(String screenTimeDetectionScheduleFrom) {
        mPrefs.edit().putString(PREF_SCREEN_TIME_DETECTION_SCHEDULE_FROM, screenTimeDetectionScheduleFrom).apply();
    }

    @Override
    public String getScreenTimeDetectionScheduleTo() {


        String toDate = getStringElseNull(PREF_SCREEN_TIME_DETECTION_SCHEDULE_TO);

        if (toDate == null) {
            Date dateAndTimeTo = null;
            try {

                dateAndTimeTo = formatTime(DateUtility.getDateByToday(0), AppConstants.DEFAULT_SCHEDULE_TIME_TO, formatterDateTime_12h);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return formatterDateTime_12h.format(dateAndTimeTo);
        }
        return toDate;

    }

    @Override
    public void setScreenTimeDetectionScheduleTo(String screenFreeTimeScheduleTo) {
        mPrefs.edit().putString(PREF_SCREEN_TIME_DETECTION_SCHEDULE_TO, screenFreeTimeScheduleTo).apply();
    }

    @Override
    public Date getScreenTimeDetectionDisableTime() {
        return new Date(Long.valueOf(mPrefs.getString(PREF_SCREEN_TIME_DETECTION_DISABLE_TIME, null)));
    }

    @Override
    public void setScreenTimeDetectionDisableTime(String screenTimeDetectionDisableTime) {
        mPrefs.edit().putString(PREF_SCREEN_TIME_DETECTION_DISABLE_TIME, screenTimeDetectionDisableTime).apply();

    }

    @Override
    public boolean getSimpleModeEnabled() {
        return mPrefs.getBoolean(PREF_SIMPLE_MODE_ENABLED, false) &&
                (AppLauncherManager.isSimpleModeEnabled(this) || AppLauncherManager.isSimpleModeProEnabled(this));
    }

    @Override
    public void setSimpleModeEnabled(boolean enabled) {
        mPrefs.edit().putBoolean(PREF_SIMPLE_MODE_ENABLED, enabled).apply();
    }

    @Override
    public List<Boolean> getSimpleModeSchedule() {
        String json = mPrefs.getString(PREF_SIMPLE_MODE_SCHEDULE, null);
        if (json != null) {
            try {
                Gson gson = new Gson();
                List<Boolean> schedule = gson.fromJson(json, new TypeToken<ArrayList<Boolean>>() {}.getType());
                if (!schedule.isEmpty()) {
                    return schedule;
                }
            } catch (JsonParseException ignored) {
            }
        }
        List<Boolean> schedule = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 6) schedule.add(false);
            else schedule.add(true);
        }
        return schedule;
    }

    @Override
    public void setSimpleModeSchedule(List<Boolean> schedule) {
        if (schedule == null) {
            schedule = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                schedule.add(false);
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(schedule);
        mPrefs.edit().putString(PREF_SIMPLE_MODE_SCHEDULE, json).apply();
    }

    /**
     * This value is cached because it is accessed a ton.
     */
    @Nullable
    private Date mSimpleModeManualEnd;

    @Override
    public Date getSimpleModeManualEnd() {
        if (mSimpleModeManualEnd == null) {
            // Cloned because SimpleDateFormat is not thread safe and can return incorrect results when shared.
            final SimpleDateFormat dateFmt = (SimpleDateFormat) DateUtility.formatterDateTime_12h.clone();
            final String dateStr = mPrefs.getString(PREF_SIMPLE_MODE_MANUAL_END, null);
            try {
                if (dateStr != null) {
                    mSimpleModeManualEnd = dateFmt.parse(dateStr);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return mSimpleModeManualEnd;
    }

    @Override
    public void setSimpleModeManualEnd(Date end) {
        String value;
        if (end == null) {
            value = null;
        }else{
            // Cloned because SimpleDateFormat is not thread safe and can return incorrect results when shared.
            final SimpleDateFormat dateFmt = (SimpleDateFormat) DateUtility.formatterDateTime_12h.clone();
            value = dateFmt.format(end);
        }
        mSimpleModeManualEnd = end;
        mPrefs.edit().putString(PREF_SIMPLE_MODE_MANUAL_END, value).apply();
    }

    @Override
    public String getSimpleModeScheduleTo() {
        String toDate = mPrefs.getString(PREF_SIMPLE_MODE_SCHEDULE_TO, null);
        if (toDate == null) {
            Date dateAndTimeTo = formatTime(DateUtility.getDateByToday(0), AppConstants.DEFAULT_SIMPLE_MODE_TO, formatterDateTime_12h);
            return formatterDateTime_12h.format(dateAndTimeTo);
        }
        return toDate;
    }

    @Override
    public void setSimpleModeScheduleTo(String to) {
        mPrefs.edit().putString(PREF_SIMPLE_MODE_SCHEDULE_TO, to).apply();
    }

    @Override
    public String getSimpleModeScheduleFrom() {
        String fromDate = mPrefs.getString(PREF_SIMPLE_MODE_SCHEDULE_FROM, null);
        if (fromDate == null) {
            Date dateAndTimeFrom = formatTime(DateUtility.getDateByToday(0), AppConstants.DEFAULT_SIMPLE_MODE_FROM, formatterDateTime_12h);
            return formatterDateTime_12h.format(dateAndTimeFrom);
        }
        return fromDate;
    }

    @Override
    public void setSimpleModeScheduleFrom(String from) {
        mPrefs.edit().putString(PREF_SIMPLE_MODE_SCHEDULE_FROM, from).apply();
    }

    @Override
    public String getSimpleModeDefaultLauncher() {
        return mPrefs.getString(PREF_SIMPLE_MODE_SCHEDULE_DEFAULT_LAUNCHER, null);
    }

    @Override
    public void setSimpleModeDefaultLauncher(String launcher) {
        mPrefs.edit().putString(PREF_SIMPLE_MODE_SCHEDULE_DEFAULT_LAUNCHER, launcher).apply();
    }

    @Override
    public String getInsightNotificationSchedule() {
        return getStringElseNull(PREF_INSIGHT_NOTIFICATION_SCHEDULE);
    }

    @Override
    public void setInsightNotificationSchedule(String schedule) {
        mPrefs.edit().putString(PREF_INSIGHT_NOTIFICATION_SCHEDULE, schedule).apply();
    }

    @Override
    public List<SoundPOJO> getInsihgtsNotificationOptions() {
        String selectedOption = getInsightNotificationSchedule();
        List<SoundPOJO> options = new ArrayList<>();
        options.add(new SoundPOJO("Every Day", "", false));
        options.add(new SoundPOJO("Every Week", "", false));
        options.add(new SoundPOJO("Every Month", "", false));
        options.add(new SoundPOJO("Never", "", false));

        if (selectedOption != null) {
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i).getTitle().equals(selectedOption)) {
                    options.get(i).setSelected(true);
                }
            }
        }
        return options;
    }

    @Override
    public String getInsightNotificationFor() {
        String schedule = getInsightNotificationSchedule();
        if (schedule.equals("Every Day")) {
            return "daily";
        } else if (schedule.equals("Every Week")) {
            return "weekly";
        } else if (schedule.equals("Every Month")) {
            return "monthly";
        }
        return "";
    }

    @Override
    public String getInsightNotificationTimeFrame() {
        String schedule = getInsightNotificationSchedule();
        if (schedule.equals("Every Day")) {
            return "Day";
        } else if (schedule.equals("Every Week")) {
            return "Week";
        } else if (schedule.equals("Every Month")) {
            return "Quarter";
        }
        return "";
    }

    @Override
    public boolean haveAPickupGoal() {
        return getBoolsElseFalse(PREF_HAVE_A_PICKUP_GOAL);
    }

    @Override
    public void setAPickupGoal(boolean value) {
        putBoolean(PREF_HAVE_A_PICKUP_GOAL, value);
    }

    @Override
    public boolean haveAScreenTimeGoal() {
        return getBoolsElseFalse(PREF_HAVE_A_SCREENTIME_GOAL);
    }

    @Override
    public void setAScreenTimeGoal(boolean value) {
        putBoolean(PREF_HAVE_A_SCREENTIME_GOAL, value);
    }

    @Override
    public ArrayList<IWant> getMyFocusingGoals() {
        String json = getStringElseNull(PREF_FOCUSING_GOALS);
        Gson gson = new Gson();
        if (json == null) {
            return (ArrayList<IWant>) getDefaultFocusingGoals();
        }
        Type type = new TypeToken<List<IWant>>() {
        }.getType();
        List<IWant> values = gson.fromJson(json, type);
        return (ArrayList<IWant>) values;
    }

    @Override
    public void setMyFocusingGoals(List<IWant> values) {
        Gson gson = new Gson();
        String json = gson.toJson(values);
        mPrefs.edit().putString(PREF_FOCUSING_GOALS, json).apply();
    }

    private List<IWant> getDefaultFocusingGoals() {
        List<IWant> list = new ArrayList<>();
        list.add(new IWant("Track screen time", "trackScreenTime", "draw_focus_track_screen_time_icon"));
        list.add(new IWant("Sharpen focus", "sharpenFocus", "draw_focus_sharpen_focus_icon"));
        list.add(new IWant("Have more family time", "moreFamilyTime", "draw_focus_have_more_family_icon"));
        list.add(new IWant("Sleep better", "sleepBetter", "draw_focus_sleep_better_icon"));
        list.add(new IWant("Feel happier", "feelHappier", "draw_focus_feel_happier_icon"));
        list.add(new IWant("Stop wasting time", "stopWastingTime", "draw_focus_stop_wasting_time_icon"));
        list.add(new IWant("Reduce anxiety", "reduceAnxiety", "draw_focus_reduce_anxiety_icon"));
        list.add(new IWant("Improve relationships", "improveRelationships", "draw_focus_improve_relationship_icon"));
        return list;
    }

    @Override
    public boolean haveNudgeMeForPickup() {
        return getBoolsElseFalse(PREF_NUDGE_ME_FOR_PICKUPS);
    }

    @Override
    public void setNudgeMeForPickups(boolean value) {
        putBoolean(PREF_NUDGE_ME_FOR_PICKUPS, value);
    }

    @Override
    public boolean haveNudgeMeForScreenTime() {
        return getBoolsElseFalse(PREF_NUDGE_ME_FOR_SCREENTIME);
    }

    @Override
    public void setNudgeMeForScreenTime(boolean value) {
        putBoolean(PREF_NUDGE_ME_FOR_SCREENTIME, value);
    }

    @Override
    public int getPickupsGoalValue() {
        return mPrefs.getInt(PREF_PICKUPS_GOAL_VALUE, Integer.valueOf(AppConstants.DEFAULT_PICKUPS_LIMIT));
    }

    @Override
    public void setPickupsGoalValue(int value) {
        mPrefs.edit().putInt(PREF_PICKUPS_GOAL_VALUE, value).apply();
    }

    @Override
    public String getPickupsGoalSound() {
        return mPrefs.getString(PREF_PICKUPS_SOUND, AppConstants.DEFAULT_PICKUP_SOUND);
    }

    @Override
    public void setPickupsGoalSound(String pickupsGoalSound) {
        mPrefs.edit().putString(PREF_PICKUPS_SOUND, pickupsGoalSound).apply();
    }

    @Override
    public int getPickupsGoalSoundURI() {
        return mPrefs.getInt(PREF_PICKUPS_SOUND_URI, R.raw.bowl);
    }

    @Override
    public void setPickupsGoalSoundURI(int pickupsGoalSoundURI) {
        mPrefs.edit().putInt(PREF_PICKUPS_SOUND_URI, pickupsGoalSoundURI).apply();
    }

    @Override
    public int getPickupsGoalTime() {
        return mPrefs.getInt(PREF_PICKUPS_GOAL_TIME, AppConstants.DEFAULT_PICKUPS_GOAL_TIME);
    }

    @Override
    public void setPickupsGoalTime(int pickupsGoalTime) {
        mPrefs.edit().putInt(PREF_PICKUPS_GOAL_TIME, pickupsGoalTime).apply();
    }

    @Override
    public boolean isOnBoardingCompleted() {
        return getBoolsElseFalse(PREF_ON_BOARDING);
    }

    @Override
    public void setOnBoardingCompleted(boolean value) {
        putBoolean(PREF_ON_BOARDING, value);
    }

    @Override
    public boolean getpitchedPremiumWithComparisonToAverageScreenTimeAfter7Days() {
        return getBoolsElseFalse(PREF__PITCHEDPREMIUMWITHCOMPARISION);
    }

    @Override
    public void setpitchedPremiumWithComparisonToAverageScreenTimeAfter7Days(boolean value) {
        mPrefs.edit().putBoolean(PREF__PITCHEDPREMIUMWITHCOMPARISION, value).apply();
    }

    @Override
    public Date getDelayMarketingPromptsUntil() {
        return new Date(Long.valueOf(mPrefs.getString(PREF__DELAYMARKETINGPROMPTSUNTIL, "-1")));
    }

    @Override
    public void setDelayMarketingPromptsUntil(Date time) {
        mPrefs.edit().putString(PREF__DELAYMARKETINGPROMPTSUNTIL, time.getTime() + "").apply();

    }

    @Override
    public void setPurchasedDate(Date purchasedDate) {
        mPrefs.edit().putString(PREF_PURCHASEDPREMIUM_DATE, purchasedDate.getTime() + "").apply();
    }

    @Override
    public Date getPurchasedDate() {
        return new Date(Long.valueOf(mPrefs.getString(PREF_PURCHASEDPREMIUM_DATE, "-1")));
    }

    @Override
    public boolean shownThankYouForBuyingPro() {
        return getBoolsElseFalse(PREF_SHOWNTHANKYOUFOR_BUYING_PRO);
    }

    @Override
    public void setShownThankYouForBuyingPro(boolean value) {
        putBoolean(PREF_SHOWNTHANKYOUFOR_BUYING_PRO, value);
    }

    @Override
    public boolean shownThankYouForBuyingPremium() {
        return getBoolsElseFalse(PREF_SHOWNTHANKYOU_FOR_BUYING_PREMIUM);
    }

    @Override
    public void setShownThankYouForBuyingPremium(boolean value) {
        putBoolean(PREF_SHOWNTHANKYOU_FOR_BUYING_PREMIUM, value);
    }

    //MOST USEFUL
    public void putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
    }

    //MOST USEFUL
    public String getStringElseNull(String key) {
        return mPrefs.getString(key, null);
    }

    //Else empty String
    public String getStringElseEmptyString(String key) {
        return mPrefs.getString(key, "");
    }

    //MOST USEFUL
    public void putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
    }

    //Else false
    public boolean getBoolsElseFalse(String key) {
        return mPrefs.getBoolean(key, false);
    }

    //Else true
    public boolean getBoolsElseTrue(String key) {
        return mPrefs.getBoolean(key, true);
    }

    //MOST USEFUL
    public void putLong(String key, long value) {
        mPrefs.edit().putLong(key, value).apply();
    }


    //MOST USEFUL
    public long getLongElseMinusOne(String key) {
        return mPrefs.getLong(key, -1);
    }

    @Override
    public boolean getPitchedPremiumWithPercentileRank() {
        return getBoolsElseFalse(PREF_PITCHED_PREMIUM_WITH_PERCETILE_RANK);
    }

    @Override
    public void setPitchedPremiumWithPercentileRank(boolean value) {
        putBoolean(PREF_PITCHED_PREMIUM_WITH_PERCETILE_RANK, value);
    }

    @Override
    public boolean checkFirstLaunch() {
        return getBoolsElseFalse(PREF_FIRST_LAUNCH);
    }

    @Override
    public void setFirstLaunch(boolean value) {
        putBoolean(PREF_FIRST_LAUNCH, value);
        String uniqueID = UUID.randomUUID().toString();
        setVendorId(uniqueID);
        setAppInstalDate();
    }

    @Override
    public void setVendorId(String vendorId) {
        putString(PREF_DEVICE_VENDOR_ID, vendorId);
    }

    @Override
    public String getVendorId() {
        return getStringElseNull(PREF_DEVICE_VENDOR_ID);
    }

    @Override
    public long getStepCountDownTimerUntil() {
        return getLongElseMinusOne(PREF__SHOWCOUNTERUNTIL);
    }

    @Override
    public void setStepCountDownTimerUntil(long countdownUntil) {
        putLong(PREF__SHOWCOUNTERUNTIL, countdownUntil);
    }

    @Override
    public Date goalCongratulationsShownUntil() {
        long l = mPrefs.getLong(PREF__GOALCONGRATULATIONS_SHOWUNTIL, -1);
        if (l == -1) return null;
        return new Date(l);
    }

    @Override
    public void setGoalCongratulationsShowUntil(Date date) {
        mPrefs.edit().putLong(PREF__GOALCONGRATULATIONS_SHOWUNTIL, date.getTime()).apply();
    }

    @Override
    public boolean askedToSubscribeToNewsLetter() {
        return getBoolsElseFalse(PREF__ASKFORSUBSCRIBE);
    }

    @Override
    public void setAkedToSubscribeToNewsLetter(boolean value) {
        putBoolean(PREF__ASKFORSUBSCRIBE, value);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterThousdandMinutes(boolean b) {
        putBoolean(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_THOUSAND_MINUTES, b);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterTenThousdandMinutes(boolean b) {
        putBoolean(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_TEN_THOUSAND_MINUTES, b);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterFiftyThousdandMinutes(boolean b) {
        putBoolean(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_FIFTY_THOUSAND_MINUTES, b);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterHundredThousdandMinutes(boolean b) {
        putBoolean(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_HUNDRED_THOUSAND_MINUTES, b);
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterFiftyThousdandMinutes() {
        return getBoolsElseFalse(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_FIFTY_THOUSAND_MINUTES);
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterHundredThousdandMinutes() {
        return getBoolsElseFalse(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_HUNDRED_THOUSAND_MINUTES);
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterThousandMinutes() {
        return getBoolsElseFalse(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_THOUSAND_MINUTES);
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterTenThousandMinutes() {
        return getBoolsElseFalse(PREF_PITCHED_COACH_SUBSCIRPTION_AFTER_TEN_THOUSAND_MINUTES);
    }

    @Override
    public int shouldAskForReviewAfterDays() {
        return mPrefs.getInt(PREF_SHOULD_ASK_FOR_REVIEEW_AFTER_DAYS, 0);
    }

    @Override
    public boolean shouldAskForReview() {
        return getBoolsElseFalse(PREF_SHOULD_ASK_FOR_REVIEW);
    }

    @Override
    public void setShouldAskForReviewAfterDays(int askForReviewAfter) {
        mPrefs.edit().putInt(PREF_SHOULD_ASK_FOR_REVIEEW_AFTER_DAYS, askForReviewAfter).apply();
    }

    @Override
    public void setShouldAskForReview(boolean askForReview) {
        mPrefs.edit().putBoolean(PREF_SHOULD_ASK_FOR_REVIEW, askForReview).apply();
    }

    @Override
    public void setAskedToSubscribeToNewsletter(boolean b) {
        putBoolean(PREF__ASKFORSUBSCRIBE, b);
    }

    @Override
    public void setOnboardEmail(String s) {
        mPrefs.edit().putString(PREF_ONBOARD_EMAIL, s).apply();
    }

    @Override
    public String getOnBoardEmail() {
        return getStringElseEmptyString(PREF_ONBOARD_EMAIL);
    }

    @Override
    public boolean isAppLimitModeOn() {
        return mPrefs.getBoolean(APP_LIMIT_MODE_ON, true);
    }

    @Override
    public void setAppLimitMode(boolean appLimitMode) {
        putBoolean(APP_LIMIT_MODE_ON, appLimitMode);
    }

    @Override
    public boolean isAnyAppLimitCategorySelected() {
        return getBoolsElseFalse(ANY_APP_LIMIT_CATEGORY_SELECTED);
    }

    @Override
    public void setIsAnyAppLimitCategorySelected(boolean isAnyCategorySelected) {
        putBoolean(ANY_APP_LIMIT_CATEGORY_SELECTED, isAnyCategorySelected);
    }

    @Override
    public void setCurrentForegroundPackage(String packageName) {
        mPrefs.edit().putString(CURRENT_FOREGROUND_PACKAGE, packageName).apply();
    }

    @Override
    public String getCurrentForegroundPackage() {
        return getStringElseEmptyString(CURRENT_FOREGROUND_PACKAGE);
    }

    @Override
    public void saveLastAnonymousSync(Date date) {
        putLong(PREF_LAST_ANONYMOUS_SYNC_TIME, date.getTime());
    }

    @Override
    public Date getLastAnonymousSync() {
        long longElseMinusOne = getLongElseMinusOne(PREF_LAST_ANONYMOUS_SYNC_TIME);
        if (longElseMinusOne == -1) {
            //set the date 6 hours before app install
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(getAppInstalDate());
            calendar.add(Calendar.HOUR, -7);
            longElseMinusOne = calendar.getTime().getTime();
        }
        return new Date(longElseMinusOne);
    }

    @Override
    public String getExperimentGroup() {
        return getStringElseNull(PREF_EXPERIMENTAL_GROUP);
    }

    @Override
    public void setExperimentalGroup(String yourExperimentGroup) {
        putString(PREF_EXPERIMENTAL_GROUP, yourExperimentGroup);
    }

    @Override
    public void setIsNotificationDefaultMode(boolean isNotificationDefaultMode) {
        if (ENABLE_MIXPANEL) {
            if (isNotificationDefaultMode) {
                MomentApp.mixpanelAPI.track("Turned on Non-Essential Notifications");
            } else {
                MomentApp.mixpanelAPI.track("Turned off Non-Essential Notifications");
            }
        }
        putBoolean(NOTIFICATION_DEFAULT_MODE, isNotificationDefaultMode);
    }

    @Override
    public boolean isNotificationDefaultModeOn() {
        return getBoolsElseFalse(NOTIFICATION_DEFAULT_MODE);
    }

    @Override
    public void setShouldShowNotificationDefaultOffScreen(boolean shouldShowNotificationDefaultOffScreen) {
        putBoolean(SHOULD_SHOW_NOTIFICATION_DEFAULT_OFF_SCREEN, shouldShowNotificationDefaultOffScreen);
    }

    @Override
    public boolean shouldShowNotificationDefaultOffScreen() {
        return mPrefs.getBoolean(SHOULD_SHOW_NOTIFICATION_DEFAULT_OFF_SCREEN, true);
    }

    @Override
    public void setShouldShowAppLimitSettingsScreen(boolean shouldShowAppLimitSettingsScreen) {
        putBoolean(SHOULD_SHOW_APPLIMIT_SETTING_SCREEN, shouldShowAppLimitSettingsScreen);
    }

    @Override
    public boolean shouldShowAppLimitSettingsScreen() {
        return getBoolsElseTrue(SHOULD_SHOW_APPLIMIT_SETTING_SCREEN);
    }
}




