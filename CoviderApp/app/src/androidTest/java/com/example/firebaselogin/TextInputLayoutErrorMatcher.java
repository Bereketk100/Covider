package com.example.firebaselogin;


import android.view.View;

import androidx.test.espresso.Root;

import com.google.android.material.textfield.TextInputLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class TextInputLayoutErrorMatcher extends TypeSafeMatcher<View> {

    private String expectedErrorText;

    TextInputLayoutErrorMatcher(String expectedErrorText) {
        this.expectedErrorText = expectedErrorText;
    }

    @Override
    protected boolean matchesSafely(View item) {

        if (!(item instanceof TextInputLayout)) {
            return false;
        }

        CharSequence error = ((TextInputLayout) item).getError();

        if (error == null) {
            return false;
        }

        String hint = error.toString();

        return expectedErrorText.equals(hint);
    }

    @Override
    public void describeTo(Description description) {
    }
}