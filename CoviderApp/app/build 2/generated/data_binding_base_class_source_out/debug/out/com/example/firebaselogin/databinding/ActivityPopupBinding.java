// Generated by view binder compiler. Do not edit!
package com.example.firebaselogin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.firebaselogin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPopupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button back;

  @NonNull
  public final Button checkIn;

  @NonNull
  public final TextView size;

  @NonNull
  public final Button viewRisk;

  @NonNull
  public final Button viewStats;

  private ActivityPopupBinding(@NonNull ConstraintLayout rootView, @NonNull Button back,
      @NonNull Button checkIn, @NonNull TextView size, @NonNull Button viewRisk,
      @NonNull Button viewStats) {
    this.rootView = rootView;
    this.back = back;
    this.checkIn = checkIn;
    this.size = size;
    this.viewRisk = viewRisk;
    this.viewStats = viewStats;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_popup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPopupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      Button back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.checkIn;
      Button checkIn = ViewBindings.findChildViewById(rootView, id);
      if (checkIn == null) {
        break missingId;
      }

      id = R.id.size;
      TextView size = ViewBindings.findChildViewById(rootView, id);
      if (size == null) {
        break missingId;
      }

      id = R.id.viewRisk;
      Button viewRisk = ViewBindings.findChildViewById(rootView, id);
      if (viewRisk == null) {
        break missingId;
      }

      id = R.id.viewStats;
      Button viewStats = ViewBindings.findChildViewById(rootView, id);
      if (viewStats == null) {
        break missingId;
      }

      return new ActivityPopupBinding((ConstraintLayout) rootView, back, checkIn, size, viewRisk,
          viewStats);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
