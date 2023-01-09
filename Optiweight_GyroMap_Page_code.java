<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".gyromap">
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/gyromap"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="50px"
        />

    <TextView
        android:id="@+id/tiltangle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="GyroMap"
        android:textSize="30dp"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="200px"
        android:textColor="#000"
        android:textStyle="bold"
        ></TextView>

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="350dp"
        android:layout_marginTop="150dp"
        android:src="@drawable/grid"

        />
    <ImageView
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@drawable/ball"
        android:layout_marginTop="775px"
        android:layout_centerHorizontal="true"
        android:id="@+id/ball"
        />
</RelativeLayout>