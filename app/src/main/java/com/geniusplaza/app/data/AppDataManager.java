package com.geniusplaza.app.data;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

import com.geniusplaza.app.BuildConfig;
import com.geniusplaza.app.data.db.DbHelper;
import com.geniusplaza.app.data.prefs.PreferencesHelper;
import com.geniusplaza.app.data.remote.ApiHelper;
import com.geniusplaza.app.di.ApplicationContext;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          DbHelper dbHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Observable<Boolean> insertPickup(Pickup pickup) {
        return mDbHelper.insertPickup(pickup);
    }

    @Override
    public Observable<Boolean> updatePickup(Pickup pickup) {
        return mDbHelper.updatePickup(pickup);
    }

    @Override
    public Observable<Boolean> insertAppTime(AppTime appTime) {
        return mDbHelper.insertAppTime(appTime);
    }


    @Override
    public Observable<Boolean> updatePickUpSeconds(List<AppTime> list) {
        return mDbHelper.updatePickUpSeconds(list);
    }


    @Override
    public Observable<ScreenTime.ScreenTimeTempBuilder> getScreenTimeByDate(String date) {
        return mDbHelper.getScreenTimeByDate(date);
    }

    @Override
    public ScreenTime.ScreenTimeTempBuilder getScreenTimeByDateSync(String date) {
        return mDbHelper.getScreenTimeByDateSync(date);
    }

    @Override
    public Observable<List<String>> getAppUsageDistinctDate() {
        return mDbHelper.getAppUsageDistinctDate();
    }

    @Override
    public Observable<ArrayList<AppTime>> getAllAppsOfDay(String date) {
        return mDbHelper.getAllAppsOfDay(date);
    }

    @Override
    public Observable<Integer> getPickupsCount(String date) {
        return mDbHelper.getPickupsCount(date);
    }

    @Override
    public Observable<Integer> getScreenTime(String date) {
        return mDbHelper.getScreenTime(date);
    }

    @Override
    public Observable<Integer> getScreenTimeInt(String date) {
        return Observable.fromCallable(() -> {

            int screenTimeInt = mDbHelper.getScreenTimeInt(date).blockingFirst();
            if (screenTimeInt == 0) {
                return 0;
            }
            return mDbHelper.getScreenTimeInt(date).blockingFirst();
        });
    }

    @Override
    public Observable<ArrayList<AppTime>> getDistinctAppNames(String date) {
        return mDbHelper.getDistinctAppNames(date);
    }

    @Override
    public Observable<Integer> getAppTime(String appName, String date) {
        return mDbHelper.getAppTime(appName, date);
    }

    @Override
    public String getTinyReminderSelectedSound() {
        return mPreferencesHelper.getTinyReminderSelectedSound();
    }

    @Override
    public void setTinyReminderSelectedSound(String tinyReminderSelectedSound) {
        mPreferencesHelper.setTinyReminderSelectedSound(tinyReminderSelectedSound);
    }

    @Override
    public String getDailyLimitSelectedSound() {
        return mPreferencesHelper.getDailyLimitSelectedSound();
    }

    @Override
    public void setDailyLimitSelectedSound(String dailyLimitSelectedSound) {
        mPreferencesHelper.setDailyLimitSelectedSound(dailyLimitSelectedSound);
    }

    @Override
    public String getTinyReminderTime() {
        return mPreferencesHelper.getTinyReminderTime();
    }

    @Override
    public void setTinyReminderTime(String tinyReminderTime) {
        mPreferencesHelper.setTinyReminderTime(tinyReminderTime);
    }

    @Override
    public String getDailyLimit() {
        return mPreferencesHelper.getDailyLimit();
    }

    @Override
    public void setDailyLimit(String dailyLimit) {
        mPreferencesHelper.setDailyLimit(dailyLimit);
    }

    @Override
    public boolean getForceMeOffValue() {
        return mPreferencesHelper.getForceMeOffValue();
    }

    @Override
    public void setForceMeOffValue(boolean forceMeOffValue) {
        mPreferencesHelper.setForceMeOffValue(forceMeOffValue);
    }

    @Override
    public boolean isPurchased() {
        return mPreferencesHelper.isPurchased();
    }

    @Override
    public void setPurchased(boolean purchased) {
        mPreferencesHelper.setPurchased(purchased);
    }

    @Override
    public boolean isInAppSubsPurchased() {
        return mPreferencesHelper.isInAppSubsPurchased();
    }

    @Override
    public void setInAppSubsPurchased(boolean purchased) {
        mPreferencesHelper.setInAppSubsPurchased(purchased);
    }

    @Override
    public ArrayList<SoundPOJO> getDailyLimitSounds() {
        return mPreferencesHelper.getDailyLimitSounds();
    }

    @Override
    public ArrayList<SoundPOJO> getTinyReminderSounds() {
        return mPreferencesHelper.getTinyReminderSounds();
    }

    @Override
    public void setTinyReminderSelectedSoundURI(int uri) {
        mPreferencesHelper.setTinyReminderSelectedSoundURI(uri);
    }

    @Override
    public void setDailyLimitSelectedSoundURI(int uri) {
        mPreferencesHelper.setDailyLimitSelectedSoundURI(uri);
    }

    @Override
    public int getTinyReminderSelectedSoundURI() {
        return mPreferencesHelper.getTinyReminderSelectedSoundURI();
    }

    @Override
    public ArrayList<WhatsNew> getWhatsNewList() {
        return mPreferencesHelper.getWhatsNewList();
    }

    @Override
    public ArrayList<Lesson> getBrilliantCourse() {
        return mPreferencesHelper.getBrilliantCourse();
    }

    @Override
    public int getDailyLimitSelectedSoundURI() {
        return mPreferencesHelper.getDailyLimitSelectedSoundURI();
    }

    @Override
    public void setAccessToken(String accessToken) {

    }

    @Override
    public boolean isScreenFreeTimeOffActivated() {
        return mPreferencesHelper.isScreenFreeTimeOffActivated();
    }

    @Override
    public void setScreenFreeTimeOffActivated(boolean screenFreeTimeOff) {
        mPreferencesHelper.setScreenFreeTimeOffActivated(screenFreeTimeOff);
    }


    @Override
    public void setScreenFreeTimeFromTime(String dateString) {
        mPreferencesHelper.setScreenFreeTimeFromTime(dateString);
    }

    @Override
    public void setScreenFreeTimeToTime(String dateString) {
        mPreferencesHelper.setScreenFreeTimeToTime(dateString);
    }

    @Override
    public String getScreenFreeTimeFromTime() {
        return mPreferencesHelper.getScreenFreeTimeFromTime();
    }

    @Override
    public String getScreenFreeTimeToTime() {
        return mPreferencesHelper.getScreenFreeTimeToTime();
    }

    @Override
    public boolean getScreenFreeTimeScheduleSwitch() {
        return mPreferencesHelper.getScreenFreeTimeScheduleSwitch();
    }

    @Override
    public void setScreenFreeTimeScheduleSwitch(boolean screenFreeTimeSchedule) {
        mPreferencesHelper.setScreenFreeTimeScheduleSwitch(screenFreeTimeSchedule);
    }

    @Override
    public String getScreenFreeTimeScheduleFrom() {
        return mPreferencesHelper.getScreenFreeTimeScheduleFrom();
    }

    @Override
    public void setScreenFreeTimeScheduleFrom(String screenFreeTimeScheduleFrom) {
        mPreferencesHelper.setScreenFreeTimeScheduleFrom(screenFreeTimeScheduleFrom);
    }

    @Override
    public String getScreenFreeTimeScheduleTo() {
        return mPreferencesHelper.getScreenFreeTimeScheduleTo();
    }

    @Override
    public void setScreenFreeTimeScheduleTo(String screenFreeTimeScheduleTo) {
        mPreferencesHelper.setScreenFreeTimeScheduleTo(screenFreeTimeScheduleTo);
    }

    @Override
    public boolean isScreenTimeDetectionEnabled() {
        return mPreferencesHelper.isScreenTimeDetectionEnabled();
    }

    @Override
    public void setScreenTimeDetectionEnabled(boolean enabled) {
        mPreferencesHelper.setScreenTimeDetectionEnabled(enabled);
    }

    @Override
    public boolean isScreenTimeDetectionSchedule() {
        return mPreferencesHelper.isScreenTimeDetectionSchedule();
    }

    @Override
    public void setScreenTimeDetectionSchedule(boolean schedule) {
        mPreferencesHelper.setScreenTimeDetectionSchedule(schedule);
    }

    @Override
    public String getScreenTimeDetectionScheduleFrom() {
        return mPreferencesHelper.getScreenTimeDetectionScheduleFrom();
    }

    @Override
    public void setScreenTimeDetectionScheduleFrom(String screenTimeDetectionScheduleFrom) {
        mPreferencesHelper.setScreenTimeDetectionScheduleFrom(screenTimeDetectionScheduleFrom);
    }

    @Override
    public String getScreenTimeDetectionScheduleTo() {
        return mPreferencesHelper.getScreenTimeDetectionScheduleTo();
    }

    @Override
    public void setScreenTimeDetectionScheduleTo(String screenFreeTimeScheduleTo) {
        mPreferencesHelper.setScreenTimeDetectionScheduleTo(screenFreeTimeScheduleTo);
    }

    @Override
    public void setScreenTimeDetectionDisableTime(String screenTimeDetectionDisableTime) {
        mPreferencesHelper.setScreenTimeDetectionDisableTime(screenTimeDetectionDisableTime);
    }

    @Override
    public Date getScreenTimeDetectionDisableTime() {
        return mPreferencesHelper.getScreenTimeDetectionDisableTime();
    }

    @Override
    public boolean getSimpleModeEnabled() {
        return mPreferencesHelper.getSimpleModeEnabled();
    }

    @Override
    public void setSimpleModeEnabled(boolean enabled) {
        mPreferencesHelper.setSimpleModeEnabled(enabled);
    }

    @Override
    public List<Boolean> getSimpleModeSchedule() {
        return mPreferencesHelper.getSimpleModeSchedule();
    }

    @Override
    public void setSimpleModeSchedule(List<Boolean> schedule) {
        mPreferencesHelper.setSimpleModeSchedule(schedule);
    }

    @Override
    public String getSimpleModeScheduleFrom() {
        return mPreferencesHelper.getSimpleModeScheduleFrom();
    }

    @Override
    public void setSimpleModeScheduleFrom(String from) {
        mPreferencesHelper.setSimpleModeScheduleFrom(from);
    }

    @Override
    public String getSimpleModeScheduleTo() {
        return mPreferencesHelper.getSimpleModeScheduleTo();
    }

    @Override
    public void setSimpleModeScheduleTo(String to) {
        mPreferencesHelper.setSimpleModeScheduleTo(to);
    }

    @Override
    public Date getSimpleModeManualEnd() {
        return mPreferencesHelper.getSimpleModeManualEnd();
    }

    @Override
    public void setSimpleModeManualEnd(Date end) {
        mPreferencesHelper.setSimpleModeManualEnd(end);
    }

    @Override
    public String getSimpleModeDefaultLauncher() {
        return mPreferencesHelper.getSimpleModeDefaultLauncher();
    }

    @Override
    public void setSimpleModeDefaultLauncher(String launcher) {
        mPreferencesHelper.setSimpleModeDefaultLauncher(launcher);
    }

    @Override
    public Date getAppInstalDate() {
        return mPreferencesHelper.getAppInstalDate();
    }

    @Override
    public Observable<ArrayList<Pickup>> getAllPickups(String date) {
        return mDbHelper.getAllPickups(date);
    }

    @Override
    public Observable<Pickup> getPickupBetween(String fourAMTomorrow, String endTime, String date) {
        return mDbHelper.getPickupBetween(fourAMTomorrow, endTime, date);
    }

    @Override
    public void setAppInstalDate() {
        mPreferencesHelper.setAppInstalDate();
    }

    @Override
    public Observable<Pickup> getTodaysLastPickup() {
        return mDbHelper.getTodaysLastPickup();
    }

    @Override
    public Observable<Pickup> getFirstPickup(String format) {
        return mDbHelper.getFirstPickup(format);
    }

    @Override
    public Observable<Pickup> getLastPickup(String format) {
        return mDbHelper.getLastPickup(format);
    }

    @Override
    public Observable<Pickup> getSecondLastPickup() {
        return mDbHelper.getSecondLastPickup();
    }

    @Override
    public Observable<Boolean> insertDay(Day day) {
        return Observable.fromCallable(() -> {
            mDbHelper.insertDay(day);
            return true;
        });
    }

    @Override
    public Observable<ArrayList<Day>> getAllDays() {
        return mDbHelper.getAllDays();
    }

    @Override
    public Day getDay(String date) {
        return mDbHelper.getDay(date);
    }

    @Override
    public Integer getActiveMinutesOfIndexDay(int dayIndex, String startDate, String endDate) {
        return mDbHelper.getActiveMinutesOfIndexDay(dayIndex, startDate, endDate);
    }

    @Override
    public int getLongestPickup(String startDate, String endDate) {
        return mDbHelper.getLongestPickup(startDate, endDate);
    }

    @Override
    public ArrayList<AppTime> getAppUsageBetween(String date) {
        return mDbHelper.getAppUsageBetween(date);
    }

    @Override
    public int getPickupsCountInt(String format) {
        return mDbHelper.getPickupsCountInt(format);
    }

    @Override
    public ArrayList<Pickup> getAllPickupsArrayList(String format) {
        return mDbHelper.getAllPickupsArrayList(format);
    }

    @Override
    public Observable<Boolean> insertPickupForWeek() {
        return mDbHelper.insertPickupForWeek();
    }

    @Override
    public int getCountForIndexDay(int dayIndex, String startDate, String endDate) {
        return mDbHelper.getCountForIndexDay(dayIndex, startDate, endDate);
    }

    @Override
    public ArrayList<Pickup> getAllPickupBetween(String startDate, String endDate) {
        return mDbHelper.getAllPickupBetween(startDate, endDate);
    }

    @Override
    public int getTotalSleepTimeBetween(String startDate, String endCalendar) {
        return mDbHelper.getTotalSleepTimeBetween(startDate, endCalendar);
    }

    @Override
    public Observable<Day> calculateAwakeTimeWakingLifeSleepTime(Day day, String startDate, int activeMinutes) {
        return mDbHelper.calculateAwakeTimeWakingLifeSleepTime(day, startDate, activeMinutes);
    }

    @Override
    public int getTotalPickupCountBetween(String startDate, String endDate) {
        return mDbHelper.getTotalPickupCountBetween(startDate, endDate);
    }

    @Override
    public int getTotalDaysCountOfMonth(String startDate, String endDate) {
        return mDbHelper.getTotalDaysCountOfMonth(startDate, endDate);
    }

    @Override
    public int getActiveMinutesOfDays(String startDate, String endDate) {
        return mDbHelper.getActiveMinutesOfDays(startDate, endDate);
    }

    @Override
    public float getTotalPercentageOfWakingLifeForMonth(String startDate, String endDate) {
        return mDbHelper.getTotalPercentageOfWakingLifeForMonth(startDate, endDate);
    }

    @Override
    public int getTotalAwakeTimeBetween(String startDate, String endDate) {
        return mDbHelper.getTotalAwakeTimeBetween(startDate, endDate);
    }

    @Override
    public Observable<Boolean> insertStatMonth(StatMonth statMonth) {
        return Observable.fromCallable(() -> {
            mDbHelper.insertStatMonth(statMonth);
            return true;
        });
    }

    @Override
    public Observable<Boolean> insertStaticDummyData() {
        return mDbHelper.insertStaticDummyData();
    }

    @Override
    public AppTime getMostRecentAppUsageWithName(String appName) {
        return mDbHelper.getMostRecentAppUsageWithName(appName);
    }

    @Override
    public List<SoundPOJO> getInsihgtsNotificationOptions() {
        return mPreferencesHelper.getInsihgtsNotificationOptions();
    }

    @Override
    public void setInsightNotificationSchedule(String schedule) {
        mPreferencesHelper.setInsightNotificationSchedule(schedule);
    }

    @Override
    public String getInsightNotificationSchedule() {
        return mPreferencesHelper.getInsightNotificationSchedule();
    }

    @Override
    public String getInsightNotificationFor() {
        return mPreferencesHelper.getInsightNotificationFor();
    }

    @Override
    public String getInsightNotificationTimeFrame() {
        return mPreferencesHelper.getInsightNotificationTimeFrame();
    }

    @Override
    public Observable<List<CourseAttempt>> getAllCoursesExcept(long uuid) {
        return mDbHelper.getAllCoursesExcept(uuid);
    }

    @Override
    public Observable<CourseAttempt> getCurrentCourse() {
        Observable<CourseAttempt> currentCourseAttempt = mDbHelper.getCurrentCourse();
        return currentCourseAttempt;
    }

    @Override
    public void insertCourse(Course course) {
        mDbHelper.insertCourse(course);

    }

    @Override
    public Observable<List<Course>> getAllCourses() {
        return mDbHelper.getAllCourses();
    }

    @Override
    public Observable<Boolean> stopCurrentCourse() {
        return mDbHelper.stopCurrentCourse();
    }

    @Override
    public void insertCourseAttempt(CourseAttempt courseAttempt) {
        mDbHelper.insertCourseAttempt(courseAttempt);
    }

    @Override
    public Observable<Boolean> completedCurrentCourse() {
        return mDbHelper.completedCurrentCourse();
    }

    @Override
    public Observable<Course> getCourseByName(String currentCourseName) {
        return mDbHelper.getCourseByName(currentCourseName);
    }

    @Override
    public Observable<Boolean> saveAnswer(String answer, String key) {
        return mDbHelper.saveAnswer(answer, key);
    }

    @Override
    public int getScreenTimeBetween(long dateStart, long dateEnd) {
        return mDbHelper.getScreenTimeBetween(dateStart, dateEnd);
    }

    @Override
    public void insertStepCompletion(StepCompletion stepCompletion) {
        mDbHelper.insertStepCompletion(stepCompletion);
    }

    @Override
    public Observable<CourseAttempt> getCourseAttemptByUUid(Long courseAttemptId) {
        return mDbHelper.getCourseAttemptByUUid(courseAttemptId);
    }


    @Override
    public ArrayList<StepCompletion> getPastStepCompletions(Date date, long courseAttemptId) {
        return mDbHelper.getPastStepCompletions(date, courseAttemptId);
    }

    @Override
    public Observable<Boolean> updateStepCompletion(StepCompletion stepCompletion) {
        return Observable.fromCallable(() -> {
            mDbHelper.updateStepCompletion(stepCompletion);
            return true;
        });
    }

    @Override
    public Observable<Boolean> updatePostSurvey(CourseAttempt currentCourseAttempt) {
        return mDbHelper.updatePostSurvey(currentCourseAttempt);
    }

    @Override
    public boolean haveAPickupGoal() {
        return mPreferencesHelper.haveAPickupGoal();
    }

    @Override
    public void setAPickupGoal(boolean value) {
        mPreferencesHelper.setAPickupGoal(value);
    }

    @Override
    public boolean haveAScreenTimeGoal() {
        return mPreferencesHelper.haveAScreenTimeGoal();
    }

    @Override
    public void setAScreenTimeGoal(boolean value) {
        mPreferencesHelper.setAScreenTimeGoal(value);
    }

    @Override
    public ArrayList<IWant> getMyFocusingGoals() {
        return mPreferencesHelper.getMyFocusingGoals();
    }

    @Override
    public void setMyFocusingGoals(List<IWant> values) {
        mPreferencesHelper.setMyFocusingGoals(values);
    }

    @Override
    public boolean haveNudgeMeForPickup() {
        return mPreferencesHelper.haveNudgeMeForPickup();
    }

    @Override
    public boolean haveNudgeMeForScreenTime() {
        return mPreferencesHelper.haveNudgeMeForScreenTime();
    }

    @Override
    public void setNudgeMeForPickups(boolean value) {
        mPreferencesHelper.setNudgeMeForPickups(value);
    }

    @Override
    public void setNudgeMeForScreenTime(boolean value) {
        mPreferencesHelper.setNudgeMeForScreenTime(value);
    }

    @Override
    public int getPickupsGoalValue() {
        return mPreferencesHelper.getPickupsGoalValue();
    }

    @Override
    public void setPickupsGoalValue(int value) {
        mPreferencesHelper.setPickupsGoalValue(value);
    }

    @Override
    public String getPickupsGoalSound() {
        return mPreferencesHelper.getPickupsGoalSound();
    }

    @Override
    public void setPickupsGoalSound(String pickupsGoalSound) {
        mPreferencesHelper.setPickupsGoalSound(pickupsGoalSound);
    }

    @Override
    public int getPickupsGoalSoundURI() {
        return mPreferencesHelper.getPickupsGoalSoundURI();
    }

    @Override
    public void setPickupsGoalSoundURI(int pickupsGoalSoundURI) {
        mPreferencesHelper.setPickupsGoalSoundURI(pickupsGoalSoundURI);
    }

    @Override
    public int getPickupsGoalTime() {
        return mPreferencesHelper.getPickupsGoalTime();
    }

    @Override
    public void setPickupsGoalTime(int pickupsGoalTime) {
        mPreferencesHelper.setPickupsGoalTime(pickupsGoalTime);
    }

    @Override
    public ArrayList<SoundPOJO> getPickupsGoalsReminderSounds() {
        return mPreferencesHelper.getPickupsGoalsReminderSounds();
    }

    @Override
    public boolean isOnBoardingCompleted() {
        return mPreferencesHelper.isOnBoardingCompleted();
    }

    @Override
    public void setOnBoardingCompleted(boolean value) {
        mPreferencesHelper.setOnBoardingCompleted(value);
        mPreferencesHelper.setInsightNotificationSchedule("Every Day");
        //insert all courses
        List<Course> courses = new Gson().fromJson(CommonUtils.loadJSONFromAsset(mContext), new TypeToken<List<Course>>() {
        }.getType());
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).setUuid(i);
            mDbHelper.insertCourse(courses.get(i));
        }
    }

    @Override
    public Observable<List<SurveyAnswers>> getSurveyAnswerOfKey(String questionKey) {
        return mDbHelper.getSurveyAnswerOfKey(questionKey);
    }

    @Override
    public Observable<List<SurveyAnswers>> getAnswersBetween(String questionKey, Date starter, Date ender) {
        return mDbHelper.getAnswersBetween(questionKey, starter, ender);
    }

    @Override
    public boolean hasAttemptedCourseWithCourseKey(String betterSleep) {
        return mDbHelper.hasAttemptedCourseWithCourseKey(betterSleep);
    }

    @Override
    public Observable<Course> getCourseByKey(String key) {
        return mDbHelper.getCourseByKey(key);
    }

    @Override
    public boolean getpitchedPremiumWithComparisonToAverageScreenTimeAfter7Days() {
        return mPreferencesHelper.getpitchedPremiumWithComparisonToAverageScreenTimeAfter7Days();
    }

    @Override
    public void setpitchedPremiumWithComparisonToAverageScreenTimeAfter7Days(boolean value) {
        mPreferencesHelper.setpitchedPremiumWithComparisonToAverageScreenTimeAfter7Days(value);
    }

    @Override
    public void setPitchedPremiumWithPercentileRank(boolean value) {
        mPreferencesHelper.setPitchedPremiumWithPercentileRank(value);
    }

    @Override
    public boolean getPitchedPremiumWithPercentileRank() {
        return mPreferencesHelper.getPitchedPremiumWithPercentileRank();
    }

    @Override
    public void setShownThankYouForBuyingPro(boolean value) {
        mPreferencesHelper.setShownThankYouForBuyingPro(value);
    }

    @Override
    public void setShownThankYouForBuyingPremium(boolean value) {
        mPreferencesHelper.setShownThankYouForBuyingPremium(value);
    }

    @Override
    public boolean shownThankYouForBuyingPremium() {
        return mPreferencesHelper.shownThankYouForBuyingPremium();
    }

    @Override
    public boolean shownThankYouForBuyingPro() {
        return mPreferencesHelper.shownThankYouForBuyingPro();
    }

    @Override
    public void setPurchasedDate(Date purchasedDate) {
        mPreferencesHelper.setPurchasedDate(purchasedDate);
    }

    @Override
    public Date getPurchasedDate() {
        return mPreferencesHelper.getPurchasedDate();
    }

    @Override
    public Date getDelayMarketingPromptsUntil() {
        return mPreferencesHelper.getDelayMarketingPromptsUntil();
    }

    @Override
    public void setDelayMarketingPromptsUntil(Date time) {
        mPreferencesHelper.setDelayMarketingPromptsUntil(time);
    }

    @Override
    public ArrayList<Day> getdaysForAverageOnScreenPastQuarter(Date ninetyDaysAgo, Date date) {
        return mDbHelper.getdaysForAverageOnScreenPastQuarter(ninetyDaysAgo, date);
    }

    @Override
    public boolean checkFirstLaunch() {
        return mPreferencesHelper.checkFirstLaunch();
    }

    @Override
    public void setFirstLaunch(boolean value) {
        mPreferencesHelper.setFirstLaunch(value);
    }

    @Override
    public SurveyAnswers latestAnswerForQuestionKey(String sleepGoal) {
        return mDbHelper.latestAnswerForQuestionKey(sleepGoal);
    }

    @Override
    public void updateStep(StepCompletion stepCompletion) {
        mDbHelper.updateStep(stepCompletion);
    }

    @Override
    public void removeAppLimitApp(AppLimitApp appLimitApp) {
        mDbHelper.removeAppLimitApp(appLimitApp);
    }

    @Override
    public void removeAppCategory(AppLimitCategory appLimitCategory) {
        mDbHelper.removeAppCategory(appLimitCategory);
    }

    @Override
    public void removeAppLimitApps(ArrayList<AppLimitApp> appLimitApps) {
        mDbHelper.removeAppLimitApps(appLimitApps);
    }

    @Override
    public void removeAllApps() {
        mDbHelper.removeAllApps();
    }

    @Override
    public void removeAllCategories() {
        mDbHelper.removeAllCategories();
    }

    @Override
    public void insertAppLimitApp(AppLimitApp appLimitApp) {
        mDbHelper.insertAppLimitApp(appLimitApp);
    }

    @Override
    public void insertAppLimitApps(ArrayList<AppLimitApp> appLimitApps) {
        mDbHelper.insertAppLimitApps(appLimitApps);
    }

    @Override
    public Observable<List<AppLimitApp>> getAppLimitApps() {
        return mDbHelper.getAppLimitApps();
    }

    @Override
    public Observable<List<AppLimitApp>> getAppLimitApps(Boolean isPreCommitted) {
        return mDbHelper.getAppLimitApps(isPreCommitted);
    }

    @Override
    public Observable<List<AppLimitApp>> getAppLimitApps(String categoryName) {
        return mDbHelper.getAppLimitApps();
    }

    @Override
    public AppLimitApp getAppLimitApp(String packageName) {
        return mDbHelper.getAppLimitApp(packageName);
    }

    @Override
    public void insertAppLimitCategory(AppLimitCategory appLimitCategory) {
        mDbHelper.insertAppLimitCategory(appLimitCategory);
    }

    @Override
    public void insertAppLimitCategories(ArrayList<AppLimitCategory> appLimitCategories) {
        mDbHelper.insertAppLimitCategories(appLimitCategories);
    }

    @Override
    public Observable<List<AppLimitCategory>> getAppLimitCategories() {
        return mDbHelper.getAppLimitCategories();
    }

    @Override
    public List<AppLimitCategory> getAppLimitCategoriesDirect() {
        return mDbHelper.getAppLimitCategoriesDirect();
    }

    @Override
    public AppLimitCategory getAppLimitCategory(String categoryName) {
        return mDbHelper.getAppLimitCategory(categoryName);
    }

    @Override
    public long getAppLimitCategoriesCount() {
        return mDbHelper.getAppLimitCategoriesCount();
    }

    @Override
    public Observable<List<AppLimitApp>> getInstalledApps(Context context) {
        return mDbHelper.getInstalledApps(mContext);
    }

    @Override
    public void addCategories(Context context) {
        mDbHelper.addCategories(context);
    }

    @Override
    public boolean isAppLimitModeOn() {
        return mPreferencesHelper.isAppLimitModeOn();
    }

    @Override
    public void setAppLimitMode(boolean appLimitMode) {
        mPreferencesHelper.setAppLimitMode(appLimitMode);
    }

    @Override
    public boolean isAnyAppLimitCategorySelected() {
        return mPreferencesHelper.isAnyAppLimitCategorySelected();
    }

    @Override
    public void setIsAnyAppLimitCategorySelected(boolean isAnyCategorySelected) {
        mPreferencesHelper.setIsAnyAppLimitCategorySelected(isAnyCategorySelected);
    }

    @Override
    public void setCurrentForegroundPackage(String packageName) {
        mPreferencesHelper.setCurrentForegroundPackage(packageName);
    }

    @Override
    public String getCurrentForegroundPackage() {
        return mPreferencesHelper.getCurrentForegroundPackage();
    }


    @Override
    public long getStepCountDownTimerUntil() {
        return mPreferencesHelper.getStepCountDownTimerUntil();
    }

    @Override
    public void setStepCountDownTimerUntil(long countdownUntil) {
        mPreferencesHelper.setStepCountDownTimerUntil(countdownUntil);
    }

    @Override
    public Date goalCongratulationsShownUntil() {
        return mPreferencesHelper.goalCongratulationsShownUntil();
    }

    @Override
    public void setGoalCongratulationsShowUntil(Date date) {
        mPreferencesHelper.setGoalCongratulationsShowUntil(date);
    }

    @Override
    public boolean askedToSubscribeToNewsLetter() {
        return mPreferencesHelper.askedToSubscribeToNewsLetter();
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterThousandMinutes() {
        return mPreferencesHelper.getPitchedCoachSubscriptionAfterThousandMinutes();
    }

    @Override
    public void setPitchedCoachSubscriptionAfterThousdandMinutes(boolean b) {
        mPreferencesHelper.setPitchedCoachSubscriptionAfterThousdandMinutes(b);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterTenThousdandMinutes(boolean b) {
        mPreferencesHelper.setPitchedCoachSubscriptionAfterTenThousdandMinutes(b);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterFiftyThousdandMinutes(boolean b) {
        mPreferencesHelper.setPitchedCoachSubscriptionAfterFiftyThousdandMinutes(b);
    }

    @Override
    public void setPitchedCoachSubscriptionAfterHundredThousdandMinutes(boolean b) {
        mPreferencesHelper.setPitchedCoachSubscriptionAfterHundredThousdandMinutes(b);
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterHundredThousdandMinutes() {
        return mPreferencesHelper.getPitchedCoachSubscriptionAfterHundredThousdandMinutes();
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterFiftyThousdandMinutes() {
        return mPreferencesHelper.getPitchedCoachSubscriptionAfterFiftyThousdandMinutes();
    }

    @Override
    public boolean getPitchedCoachSubscriptionAfterTenThousandMinutes() {
        return mPreferencesHelper.getPitchedCoachSubscriptionAfterTenThousandMinutes();
    }

    @Override
    public Observable<Long> getAllTimeActiveMinuteCount() {
        return mDbHelper.getAllTimeActiveMinuteCount();
    }

    @Override
    public void setAkedToSubscribeToNewsLetter(boolean value) {
        mPreferencesHelper.setAkedToSubscribeToNewsLetter(value);
    }

    @Override
    public int shouldAskForReviewAfterDays() {
        return mPreferencesHelper.shouldAskForReviewAfterDays();
    }

    @Override
    public boolean shouldAskForReview() {
        return mPreferencesHelper.shouldAskForReview();
    }

    @Override
    public void setShouldAskForReviewAfterDays(int askForReviewAfter) {
        mPreferencesHelper.setShouldAskForReviewAfterDays(askForReviewAfter);
    }

    @Override
    public void setShouldAskForReview(boolean askForReview) {
        mPreferencesHelper.setShouldAskForReview(askForReview);
    }

    @Override
    public void setAskedToSubscribeToNewsletter(boolean b) {
        mPreferencesHelper.setAskedToSubscribeToNewsletter(b);
    }

    @Override
    public void setOnboardEmail(String s) {
        mPreferencesHelper.setOnboardEmail(s);
    }

    @Override
    public String getOnBoardEmail() {
        return mPreferencesHelper.getOnBoardEmail();
    }

    @Override
    public Observable<SyncAnonymouslyResponse> anonymousSync(String authToken, String email, String vendorId, Map<String, Object> deviceParams) {
        //grab all required things and make dictonary
        Map<String, Object> params = new HashMap<>();
        params.put("device", deviceParams);
        params.put("course_attempts", unsyncedCourseAttemptsInContext());
        params.put("step_completions", unsyncedStepCompletionsInContext());
        params.put("answers", unsyncedAnswersInContext());
        return mApiHelper.anonymousSync(authToken, email, vendorId, params);
    }

    @Override
    public Observable<SyncDaysResponse> syncDays(String authToken, String email, String vendorId, Map<String, Object> deviceParmas) {
        Map<String, Object> params = new HashMap<>();
        params.put("device", deviceParmas);
        params.put("days", unsyncedDays());
        return mApiHelper.syncDays(authToken, email, vendorId, params);
    }

    @Override
    public List<Day> getAllUnSyncedDays() {
        return mDbHelper.getAllUnSyncedDays();
    }

    @Override
    public Observable<ExperimentalGroupResponse> experimentEnrollment(String authToken, String email, String vendorId, Map<String, Object> params) {
        return mApiHelper.experimentEnrollment(authToken, email, vendorId, params);
    }

    private List<Map<String, Object>> unsyncedDays() {

        List<Map<String, Object>> daysToReport = new ArrayList<>();
        List<Day> unsyncedDays = getAllUnSyncedDays();
        if (unsyncedDays == null || unsyncedDays.size() == 0) {
            return null;
        }

        for (Day day : unsyncedDays) {
            Map<String, Object> dayDictionary = new HashMap<>();

            dayDictionary.put("uuid", day.getUuid());
            Long ended_at = null;
            Date endedAt = null;
            try {
                endedAt = formatterPickup.parse(day.getEndedAt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (endedAt != null) {
                ended_at = endedAt.getTime();
            }
            dayDictionary.put("ended_at", ended_at != null ? ended_at / 1000 : "null");
            dayDictionary.put("amc", day.getActiveMinuteCount());
            dayDictionary.put("pc", day.getPickupCount());
            Long first_used_at = null;
            Date firstUsedAt = null;
            try {
                firstUsedAt = formatterPickupTime.parse(day.getFirstUsedAt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (firstUsedAt != null) {
                first_used_at = firstUsedAt.getTime();
            }

            dayDictionary.put("first_used_at", first_used_at != null ? first_used_at / 1000 : "null");


            Long last_used_at = null;
            Date lastUsedAt = null;
            try {
                lastUsedAt = formatterPickupTime.parse(day.getLastUsedAt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (lastUsedAt != null) {
                last_used_at = lastUsedAt.getTime();
            }
            dayDictionary.put("last_used_at", last_used_at != null ? last_used_at / 1000 : "null");
            dayDictionary.put("running_minute_count", day.getRunningMinuteCount() / 60);
            dayDictionary.put("daily_limit", day.getDailyLimit() / 60);

            daysToReport.add(dayDictionary);
        }

        return daysToReport;
    }

    List<HashMap<String, Object>> unsyncedCourseAttemptsInContext() {
        List<CourseAttempt> unsyncedCourseAttempts = getAllUnSyncedCourseAttempts();
        if (unsyncedCourseAttempts == null || unsyncedCourseAttempts.size() == 0) {
            return new ArrayList<>();
        }
        //load funstatsManager
        FunStatsManager baselineStatsManager = new FunStatsManager("All", this, null, null, false, false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);

        baselineStatsManager.setOverrideTimeframeEnds(DateUtility.atEndOfDay(calendar.getTime()));
        calendar.setTime(DateUtility.atStartOfDay(baselineStatsManager.getOverrideTimeframeEnds()));
        calendar.add(Calendar.MONTH, -1);
        baselineStatsManager.setOverrideTimeframeStarts(calendar.getTime());

        baselineStatsManager.init().blockingFirst();

        baselineStatsManager.setLoaded(true);
        List<HashMap<String, Object>> courseAttemptsToReport = new ArrayList<>();
        for (CourseAttempt attempt : unsyncedCourseAttempts) {
            attempt.setBaselineStatsManager(baselineStatsManager);
            Map<String, Object> attemptDictionary = new HashMap<>();
            attemptDictionary.put("uuid", attempt.getUuid());
            attemptDictionary.put("course_key", getCourseKeyByName(attempt.getCourseId()));
            Long started_at = null;
            if (attempt.getFirstDayOfCourseAttempt() != null) {
                started_at = attempt.getFirstDayOfCourseAttempt().getTime();
            }
            attemptDictionary.put("started_at", started_at != null ? started_at / 1000 : "null");
            Long stopped_at = null;
            if (attempt.getStoppedAt() != null) {
                stopped_at = attempt.getStoppedAt().getTime();
            }
            attemptDictionary.put("stopped_at", stopped_at != null ? stopped_at / 1000 : "null");
            Long completed_at = null;
            if (attempt.getLastDayOfCourseAttempt() != null) {
                completed_at = attempt.getLastDayOfCourseAttempt().getTime();
            }
            attemptDictionary.put("completed_at", completed_at != null ? completed_at / 1000 : "null");
            attemptDictionary.put("pre_average_per_day", attempt.getPreAveragePerDay());
            attemptDictionary.put("pre_average_pickups_per_day", attempt.getPreAveragePickupsPerDay());
            attemptDictionary.put("pre_pickup_interval", attempt.getPrePickupInterval());
            attemptDictionary.put("pre_average_sleep_per_night", attempt.getPreAverageSleepPerNight() / 60);
            Long pre_average_first_pickup = null;
            if (attempt.getPreAverageFirstPickupDate() != null) {
                //make sure the am/pm issue is resolved
                Date firstDate = attempt.getPreAverageFirstPickupDate();
                pre_average_first_pickup = firstDate.getTime();
                if (attempt.getPreAverageFirstPickup().contains("PM")) {
                    pre_average_first_pickup += 43200000;
                }
            }
            attemptDictionary.put("pre_average_first_pickup", pre_average_first_pickup != null ? pre_average_first_pickup / 1000 : "null");
            Long pre_average_last_pickup = null;
            if (attempt.getPreAverageLastPickupDate() != null) {
                //make sure the am/pm issue is resolved
                Date lastPickupDate = attempt.getPreAverageLastPickupDate();
                pre_average_last_pickup = lastPickupDate.getTime();
                if (attempt.getPreAverageLastPickup().contains("PM")) {
                    pre_average_last_pickup += 43200000;
                }
            }
            attemptDictionary.put("pre_average_last_pickup", pre_average_last_pickup != null ? pre_average_last_pickup / 1000 : "null");
            courseAttemptsToReport.add((HashMap<String, Object>) attemptDictionary);
        }
        return courseAttemptsToReport;
    }


    @Override
    public String getCourseKeyByName(long courseId) {
        return mDbHelper.getCourseKeyByName(courseId);
    }

    public List<CourseAttempt> getAllUnSyncedCourseAttempts() {
        return mDbHelper.getAllUnSyncedCourseAttempts();
    }

    @Override
    public void saveLastAnonymousSync(Date date) {
        mPreferencesHelper.saveLastAnonymousSync(date);
    }

    @Override
    public Date getLastAnonymousSync() {
        return mPreferencesHelper.getLastAnonymousSync();
    }

    List unsyncedStepCompletionsInContext() {
        List<StepCompletion> unsyncedStepCompletions = getAllUnSyncedStepCompletions();
        if (unsyncedStepCompletions == null || unsyncedStepCompletions.size() == 0) {
            return new ArrayList<>();
        }

        List<Object> stepCompletionsToReport = new ArrayList<>();
        for (StepCompletion step : unsyncedStepCompletions) {
            Map<String, Object> stepDictionary = new HashMap<>();

            stepDictionary.put("uuid", step.getUuid());
            stepDictionary.put("course_uuid", getCourseUUIDFromCourseAttemptId(step.getCourseAttemptId()));
            stepDictionary.put("step_key", getStepKeyFromId(step.getStepId()));
            Long scheduled_at = null;
            if (step.getScheduledAt() != null) {
                scheduled_at = step.getScheduledAt().getTime();
            }
            stepDictionary.put("scheduled_at", scheduled_at != null ? scheduled_at / 1000 : "null");

            Long completed_at = null;
            if (step.getCompletedAt() != null) {
                completed_at = step.getCompletedAt().getTime();
            }
            stepDictionary.put("completed_at", completed_at != null ? completed_at / 1000 : "null");

            Long first_notification_scheduled_at = null;
            if (step.getFirstNotificationScheduledAt() != null) {
                first_notification_scheduled_at = step.getFirstNotificationScheduledAt().getTime();
            }
            stepDictionary.put("first_notification_scheduled_at", first_notification_scheduled_at != null ? first_notification_scheduled_at / 1000 : "null");

            Long second_notification_scheduled_at = null;
            if (step.getSecondNotificationScheduledAt() != null) {
                second_notification_scheduled_at = step.getSecondNotificationScheduledAt().getTime();
            }
            stepDictionary.put("second_notification_scheduled_at", second_notification_scheduled_at != null ? second_notification_scheduled_at / 1000 : "null");

            Long third_notification_scheduled_at = null;
            if (step.getThirdNotificationScheduledAt() != null) {
                third_notification_scheduled_at = step.getThirdNotificationScheduledAt().getTime();
            }
            stepDictionary.put("third_notification_scheduled_at", third_notification_scheduled_at != null ? third_notification_scheduled_at / 1000 : "null");
            stepCompletionsToReport.add(stepDictionary);
        }
        return stepCompletionsToReport;
    }

    public String getCourseUUIDFromCourseAttemptId(long courseAttemptId) {
        return mDbHelper.getCourseUUIDFromCourseAttemptId(courseAttemptId);
    }

    @Override
    public String getStepKeyFromId(long stepId) {
        return mDbHelper.getStepKeyFromId(stepId);
    }

    public List<StepCompletion> getAllUnSyncedStepCompletions() {
        return mDbHelper.getAllUnSyncedStepCompletions();
    }

    public List unsyncedAnswersInContext() {
        List<SurveyAnswers> unsyncedAnswers = getAllUnSyncedAnswers();

        List<Object> answersToReport = new ArrayList<>();
        for (SurveyAnswers answer : unsyncedAnswers) {
            Map<String, Object> answerDictionary = new HashMap<>();
            answerDictionary.put("uuid", answer.getUuid());
            answerDictionary.put("question_key", answer.getKey());
            Long answered_at = null;
            if (answer.getAnsweredAt() != null) {
                answered_at = answer.getAnsweredAt().getTime();
            }
            answerDictionary.put("answered_at", answered_at != null ? answered_at / 1000 : "null");

            if (answer != null) {
                if (!CommonUtils.isInteger(answer.getAnswer()))
                    answerDictionary.put("answer_string", answer.getAnswer());
                else
                    answerDictionary.put("answer_integer", Integer.valueOf(answer.getAnswer()));
            }
            answersToReport.add(answerDictionary);
        }
        return answersToReport;
    }

    public List<SurveyAnswers> getAllUnSyncedAnswers() {
        return mDbHelper.getAllUnSyncedAnswers();
    }


    @Override
    public Observable<Boolean> markAnswersSynced(List<String> answers) {
        return mDbHelper.markAnswersSynced(answers);
    }

    @Override
    public Observable<Boolean> markCourseAttemptsSynced(List<String> courseAttempts) {
        return mDbHelper.markCourseAttemptsSynced(courseAttempts);
    }

    @Override
    public Observable<Boolean> markStepCompletionsSynced(List<String> stepCompletions) {
        return mDbHelper.markStepCompletionsSynced(stepCompletions);
    }

    @Override
    public Observable<Boolean> markDaysSynced(List<String> days) {
        return mDbHelper.markDaysSynced(days);
    }

    @Override
    public void syncAnonymously(Map<String, Object> map) {
        /**
         * Time to do the SyncAnonymouslyResponse
         * */
        //get all unsycned data and sync it
        SyncAnonymouslyResponse anonymousSyncResponse = anonymousSync("auth_token", getOnBoardEmail(), getVendorId(), map).blockingFirst();
        //unsync course_attempts
        markCourseAttemptsSynced(anonymousSyncResponse.getCourseAttempts()).blockingFirst();
        //unsync step_completions
        markStepCompletionsSynced(anonymousSyncResponse.getStepCompletions()).blockingFirst();
        //unsync answers
        markAnswersSynced(anonymousSyncResponse.getAnswers()).blockingFirst();
        //saveLast SyncAnonymouslyResponse Time
        saveLastAnonymousSync(new Date());
        SyncDaysResponse syncDaysResponse = syncDays("auth_token", getOnBoardEmail(), getVendorId(), map).blockingFirst();
        //mark these days sync
        markDaysSynced(syncDaysResponse.getDays()).blockingFirst();
    }

    @Override
    public Map<String, Object> getDeviceDetails() {
        long diff = (new Date().getTime() - getAppInstalDate().getTime());
        float days = (diff / (1000 * 60 * 60 * 24));

        long numOfSeconds = getScreenTimeBetween(getAppInstalDate().getTime(), new Date().getTime());
        long numOfMinutes = TimeUnit.SECONDS.toMinutes(numOfSeconds);

        String startDate = DateUtility.formatterPickup.format(getAppInstalDate());
        String endDate = DateUtility.formatterPickup.format(new Date());

        int totalPickups = getTotalPickupCountBetween(startDate, endDate);

        Map<String, Object> map = new HashMap<>();
        map.put("vendor_id", getVendorId());
        map.put("moment_version", BuildConfig.VERSION_NAME);
        map.put("blank_slate_email", getOnBoardEmail());
        //map.put("tracking_version", "");
        map.put("system_language", Locale.getDefault().getLanguage());
        try {
            map.put("country_code", CommonUtils.getDeviceCountryCode(mContext));
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("local_time_zone", TimeZone.getDefault().getID());
        map.put("system_time_zone", TimeZone.getDefault().getID());
        map.put("android_version", Build.VERSION.RELEASE);
        //map.put("passcoded", "");
        //map.put("apn_token", "");
        //map.put("can_receive_remote_notifications", "");
        map.put("canReceiveUserNotifications", NotificationManagerCompat.from(mContext).areNotificationsEnabled());
        map.put("hardware", Build.HARDWARE);
        map.put("model", Build.MODEL);
        map.put("localized_model", DeviceName.getDeviceName());
        map.put("reminder_interval", getTinyReminderTime());
        map.put("reminder_sound", getTinyReminderSelectedSound());
//        map.put("sync_interval", "");
        map.put("battery_level", CommonUtils.getBatteryLevel(mContext));
        map.put("everything_unlocked", isInAppSubsPurchased());
//        map.put("premium_purchased_at", dataManager.getPurchasedDate());
        map.put("force_off_over_limit", haveNudgeMeForScreenTime());
        map.put("track_only_certain_hours", isScreenTimeDetectionSchedule());
        map.put("tracking_starts_at", getScreenTimeDetectionScheduleFrom());
        map.put("tracking_ends_at", getScreenTimeDetectionScheduleTo());
//        map.put("watch_first_used_at", "");
//        map.put("coach_subscription_purchased_at", "");
//        map.put("coach_subscription_expires_at", "");
        map.put("total_disk_space_in_bytes", CommonUtils.getTotalDiskSpace());
        map.put("free_disk_space_in_bytes", CommonUtils.getFreeDiskSpace());
//        map.put("tracking_app_usage", "");
//        map.put("battery_screenshot_interval", "");
        map.put("insight_reminder_interval", getInsightNotificationSchedule());
        //map.put("app_launch_count", "");
        //map.put("app_foreground_count", "");
        map.put("days_installed_for", days);
        map.put("minute_count", numOfMinutes + (UsageReaderService.cba / 60));
        map.put("total_pickups_count", totalPickups);
        map.put("screen_time_goal_enabled", haveAScreenTimeGoal());
        map.put("screen_time_goal_nudge_me", haveNudgeMeForScreenTime());
        map.put("screen_time_goal", getDailyLimit());
        map.put("screen_time_goal_sound", getDailyLimitSelectedSound());
        map.put("pickup_goal_enabled", haveAPickupGoal());
        map.put("pickup_goal_nudge_me", haveNudgeMeForPickup());
        map.put("pickup_goal", getPickupsGoalValue());
        map.put("pickup_goal_sound", getPickupsGoalSound());

        // not possible to get AdsID directly, we need to add library to get AdsID, but library will increase notable app size.
        //map.put("apple_idfa", "");
        map.put("daily_max", AppConstants.kGlobalAverageMinutesPerDay);
        map.put("mixpanel_distinct_id", MomentApp.distinctID);

        if (getExperimentGroup() != null)
            map.put("experiment_group", getExperimentGroup());
        Date date = new Date();
        if (checkFirstLaunch())
            date = getAppInstalDate();
        map.put("Android First App Open Date", date);
        return map;

    }

    @Override
    public String getExperimentGroup() {
        return mPreferencesHelper.getExperimentGroup();
    }

    @Override
    public void setExperimentalGroup(String yourExperimentGroup) {
        mPreferencesHelper.setExperimentalGroup(yourExperimentGroup);
    }

    @Override
    public void setIsNotificationDefaultMode(boolean isNotificationDefaultMode) {
        mPreferencesHelper.setIsNotificationDefaultMode(isNotificationDefaultMode);
    }

    @Override
    public boolean isNotificationDefaultModeOn() {
        return mPreferencesHelper.isNotificationDefaultModeOn();
    }

    @Override
    public void setShouldShowNotificationDefaultOffScreen(boolean shouldShowNotificationDefaultOffScreen) {
        mPreferencesHelper.setShouldShowNotificationDefaultOffScreen(shouldShowNotificationDefaultOffScreen);
    }

    @Override
    public boolean shouldShowNotificationDefaultOffScreen() {
        return mPreferencesHelper.shouldShowNotificationDefaultOffScreen();
    }

    @Override
    public ArrayList<AllowApp> getAllowedPackages() {
        return mDbHelper.getAllowedPackages();
    }

    @Override
    public void setAllowedPackages(Context context) {
        mDbHelper.setAllowedPackages(context);
    }

    @Override
    public Observable<Boolean> syncMixPanel() {
        return Observable.fromCallable(() -> {
            Map<String, Object> map = getDeviceDetails();
            if (MomentApp.mixpanelAPI != null)
                MomentApp.mixpanelAPI.getPeople().setMap(map);
            syncAnonymously(map);
            return true;
        });
    }


    @Override
    public Observable<ExperimentalGroupResponse> checkToEnrollInExperimentGroup() {
        return Observable.fromCallable(() -> {
            if (getExperimentGroup() == null) {
                Map<String, Object> params = new HashMap<>();
                params.put("device", getDeviceDetails());
                ExperimentalGroupResponse experimentalGroupResponse = experimentEnrollment("auth_token", getOnBoardEmail(), getVendorId(), params).blockingFirst();
                return experimentalGroupResponse;
            }
            return new ExperimentalGroupResponse();
        });
    }

    @Override
    public Observable<SyncAppPickupsResponse> syncAppPickups(String authToken, String email, String vendorId, Map<String, Object> params) {
        return mApiHelper.syncAppPickups(authToken, email, vendorId, params);
    }

    @Override
    public Observable<List<AppPickupRequest>> unsyncedAppTimesInContext() {
        return mDbHelper.unsyncedAppTimesInContext();
    }

    @Override
    public Observable<Boolean> markAppTimeSynced(List<String> syncDaysResponse) {
        return mDbHelper.markAppTimeSynced(syncDaysResponse);
    }

    @Override
    public Observable<Boolean> startSyncingAppPickups() {
        return Observable.fromCallable(() -> {
            if (getVendorId() != null) {
                Map<String, Object> params = new HashMap<>();
                params.put("device", getDeviceDetails());
                //fetch all unsyncedAppTimes
                List<AppPickupRequest> appTimes = unsyncedAppTimesInContext().blockingFirst();
                params.put("app_pickups", appTimes);
                SyncAppPickupsResponse syncDaysResponse = syncAppPickups("auth_token", getOnBoardEmail(), getVendorId(), params).blockingFirst();
                //mark AppTimes Synced
                markAppTimeSynced(syncDaysResponse.getApp_pickups()).blockingFirst();
                Log.d(TAG, "syncMixPanel: " + syncDaysResponse.toString());
            }
            return true;
        });

    }

    @Override
    public void setVendorId(String vendorId) {
        mPreferencesHelper.setVendorId(vendorId);
    }

    @Override
    public String getVendorId() {
        return mPreferencesHelper.getVendorId();
    }


    @Override
    public void setShouldShowAppLimitSettingsScreen(boolean shouldShowAppLimitSettingsScreen) {
        mPreferencesHelper.setShouldShowAppLimitSettingsScreen(shouldShowAppLimitSettingsScreen);
    }

    @Override
    public boolean shouldShowAppLimitSettingsScreen() {
        return mPreferencesHelper.shouldShowAppLimitSettingsScreen();
    }
}
