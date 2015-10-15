package com.example.hello;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class DateTimeActivityTest extends ActivityInstrumentationTestCase2<DateTimeActivity> {
    private Activity mActivity;

    private DatePicker datePicker;
    private TimePicker timePicker;
    private TextView dateTimeResults;
    private Button submitButton;

    public DateTimeActivityTest() {
        super(DateTimeActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();

        datePicker = (DatePicker) mActivity.findViewById(R.id.datePicker);
        timePicker = (TimePicker) mActivity.findViewById(R.id.timePicker);
        dateTimeResults = (TextView) mActivity.findViewById(R.id.dateTimeResults);
        submitButton = (Button) mActivity.findViewById(R.id.dateTimeSubmitButton);

    }


    public void testAM(){

        assertNotNull(mActivity);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                datePicker.requestFocus();
                datePicker.updateDate(2015, 9, 29);
                timePicker.setCurrentHour(11);
                timePicker.setCurrentMinute(30);

            }
        });
        getInstrumentation().waitForIdleSync();

        String expected = "Your appointment is confirmed for: 29-October-2015 11:30 AM";

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                submitButton.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        TouchUtils.clickView(this,submitButton);
        getInstrumentation().waitForIdleSync();

        final String actual = dateTimeResults.getText().toString();
        assertEquals(expected, actual);

    }

    public void testPM(){

        assertNotNull(mActivity);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                datePicker.requestFocus();
                datePicker.updateDate(2016, 0, 31);
                timePicker.setCurrentHour(18);
                timePicker.setCurrentMinute(30);

            }
        });
        getInstrumentation().waitForIdleSync();

        String expected = "Your appointment is confirmed for: 31-January-2016 06:30 PM";

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                submitButton.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        TouchUtils.clickView(this,submitButton);
        getInstrumentation().waitForIdleSync();

        final String actual = dateTimeResults.getText().toString();
        assertEquals(expected, actual);

    }
}