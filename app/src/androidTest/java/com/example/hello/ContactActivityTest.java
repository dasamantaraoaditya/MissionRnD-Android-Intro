package com.example.hello;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ContactActivityTest extends ActivityInstrumentationTestCase2<ContactActivity> {
    private Activity mActivity;

    private Spinner salutionSpinner;
    private EditText contactName;
    private EditText contactPhone;
    private TextView contactResults;
    private Button submitButton;

    public ContactActivityTest() {
        super(ContactActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();

        salutionSpinner = (Spinner) mActivity.findViewById(R.id.salutation);
        contactName = (EditText) mActivity.findViewById(R.id.contactName);
        contactPhone = (EditText) mActivity.findViewById(R.id.contactPhone);
        contactResults = (TextView) mActivity.findViewById(R.id.contactResults);
        submitButton = (Button) mActivity.findViewById(R.id.submitButton);

    }


    public void test1(){

        assertNotNull(mActivity);

        final String salutation = "Mr";
        final String name = "Bill Gates";
        final String phone = "42523002300";

        final String expected = salutation + " " + name + " " + phone;

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                salutionSpinner.requestFocus();
                salutionSpinner.setSelection(1);
            }
        });

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                contactName.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync(name);
        getInstrumentation().waitForIdleSync();

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                contactPhone.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("42523002300");
        getInstrumentation().waitForIdleSync();

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                submitButton.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        TouchUtils.clickView(this,submitButton);
        getInstrumentation().waitForIdleSync();

        final String actual = contactResults.getText().toString();
        assertEquals(expected, actual);

    }

}