package com.example.firebaselogin;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.firebaselogin.activities.LoginActivity;
import com.example.firebaselogin.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void profileClick(){
        onView(withId(R.id.btnprof)).perform(click());
        onView(withId(R.id.profile_act)).check(matches(isDisplayed()));
    }

    @Test
    public void mapsClick(){
        onView(withId(R.id.map)).perform(click());
        onView(withId(R.id.maps_act)).check(matches(isDisplayed()));
    }

    @Test
    public void logoutClick() {
        onView(withId(R.id.btnlogout)).perform(click());
        onView(withId(R.id.login_act)).check(matches(isDisplayed()));
    }
}
