package com.example.hello;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TutorialTest extends ActivityInstrumentationTestCase2<Tutorial> {
    private Activity mActivity;
    private TextView mTextView = null;
    private Button mButton = null;

    public TutorialTest() {
        super(Tutorial.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        mTextView = (TextView) mActivity
                        .findViewById(R.id.idTutorialText);
        mButton = (Button) mActivity
                .findViewById(R.id.idTutorialButton);
    }


    public void test1(){

        assertNotNull(mActivity);
        assertNotNull(mTextView);

        final String expected = "My 1st Android Tutorial";


        String actual = mTextView.getText().toString();
        assertEquals(expected, actual);

        TouchUtils.clickView(this, mButton);

        final String expectedAfterClick = "Great Job on Completing the Tutorial!";

        actual = mTextView.getText().toString();
        assertEquals(expectedAfterClick, actual);







    }

}