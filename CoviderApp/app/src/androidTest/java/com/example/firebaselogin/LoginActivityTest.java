package com.example.firebaselogin;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.firebaselogin.activities.LoginActivity;
import com.google.android.material.textfield.TextInputLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> rule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void checkLoginSuccess(){
        onView(withId(R.id.login_email)).perform(typeText("hocking@usc.edu"), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText("USCTrojans5"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Login Successful")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginMissingUsername(){
        onView(withId(R.id.login_email)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText("usc"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.login_email)).check(matches(new TextInputLayoutErrorMatcher("Email can not be empty")));
    }

    @Test
    public void checkLoginMissingPassword(){
        onView(withId(R.id.login_email)).perform(typeText("hocking@usc.edu"), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.login_password)).check(matches(new TextInputLayoutErrorMatcher("Password can not be empty")));
    }

    @Test
    public void checkLoginFailure(){
        onView(withId(R.id.login_email)).perform(typeText("hocking@usc.edu"), closeSoftKeyboard());
        onView(withId(R.id.login_password)).perform(typeText("usc"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withText("Login Failed")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

}
