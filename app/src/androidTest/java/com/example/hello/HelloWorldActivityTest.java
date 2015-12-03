package com.example.hello;

import android.app.Activity;
import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class HelloWorldActivityTest extends ActivityInstrumentationTestCase2<HelloWorldActivity> {
    private Activity mActivity;
    private TextView mTextView = null;
    private TextView mTextViewRed = null;

    public HelloWorldActivityTest() {
        super(HelloWorldActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        mTextView = (TextView) mActivity
                        .findViewById(R.id.helloText);
        mTextViewRed = (TextView) mActivity
                .findViewById(R.id.helloTextRed);
    }


    public void test1(){

        assertNotNull(mActivity);
        assertNotNull(mTextView);

        final String expected = "This is my Hello World App";

        String actual = mTextView.getText().toString();
        assertEquals(expected, actual);

        actual = mTextViewRed.getText().toString();
        assertEquals(expected, actual);

        Log.v("HelloWorldActivityTest", Integer.toString(mTextViewRed.getCurrentTextColor()));

        assertEquals(Color.RED, mTextViewRed.getCurrentTextColor());

    }

}