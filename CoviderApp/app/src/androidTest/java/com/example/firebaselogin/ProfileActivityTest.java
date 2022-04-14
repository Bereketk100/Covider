package com.example.firebaselogin;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.firebaselogin.activities.MainActivity;
import com.example.firebaselogin.activities.ProfileActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileActivityTest {

    @Rule
    public ActivityScenarioRule<ProfileActivity> rule = new ActivityScenarioRule<>(ProfileActivity.class);

    //penelope hocking
    @Test
    public void checkPopUp(){
        onView(withId(R.id.btnAddTest)).perform(click());
        onView(withId(R.id.pop_up_act)).check(matches(isDisplayed()));
    }

    //penelope hocking
    @Test
    public void checkHome(){
        onView(withId(R.id.homePage)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

}
