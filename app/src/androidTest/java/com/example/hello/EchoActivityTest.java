package com.example.hello;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class EchoActivityTest extends ActivityInstrumentationTestCase2<EchoActivity> {
    private Activity mActivity;
    private TextView mTextView = null;
    private EditText meditText = null;

    public EchoActivityTest() {
        super(EchoActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        meditText = (EditText) mActivity
                        .findViewById(R.id.echoEditText);

        mTextView = (TextView) mActivity
                .findViewById(R.id.echoResults);
    }


    public void test1(){

        assertNotNull(mActivity);
        assertNotNull(meditText);

        final String input = "Echo.";
        final String expected = "You Entered: " + input;
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                meditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync(input);
        getInstrumentation().waitForIdleSync();


        final String actual = mTextView.getText().toString();
        assertEquals(expected, actual);


    }

}