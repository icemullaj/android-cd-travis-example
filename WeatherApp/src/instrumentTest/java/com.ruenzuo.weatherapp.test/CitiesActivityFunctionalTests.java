package com.ruenzuo.weatherapp.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;

import com.ruenzuo.weatherapp.BuildConfig;
import com.ruenzuo.weatherapp.activities.CitiesActivity;
import com.ruenzuo.weatherapp.activities.CityActivity;

public class CitiesActivityFunctionalTests extends ActivityInstrumentationTestCase2 <CitiesActivity> {

    private CitiesActivity activity;

    public CitiesActivityFunctionalTests() {
        super(CitiesActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        activity = getActivity();
    }

    public void testActivity() throws Throwable {
        Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CityActivity.class.getName(), null, false);
        if (BuildConfig.IS_FREE) {
            Thread.sleep(5000);
            ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), activity.getAdView());
            assertEquals(false, activity.getSearchItem().isVisible());
        }
        else {
            ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), activity.getSearchItem().getActionView());
            assertNull(activity.getAdView());
        }
    }

}
