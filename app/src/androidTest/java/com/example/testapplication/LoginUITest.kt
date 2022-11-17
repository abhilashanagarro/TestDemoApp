package com.example.testapplication

import android.app.Instrumentation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.example.testapplication.ui.home.HomeActivity
import com.example.testapplication.ui.login.LoginActivity
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginUITest {
    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    //add a monitor for second activity
    var monitor: Instrumentation.ActivityMonitor = getInstrumentation()
        .addMonitor(HomeActivity::class.java.name, null, false)


    @Test
    fun launchHomeActivity() {
        onView(withId(R.id.edt_username))
            .perform(typeText("abhi@gmail.com"))

        onView(withId(R.id.edt_password))
            .perform(typeText("Abhi@1234"))

        onView(withId(R.id.btn_login))
            .perform(click())
        //wait for 10 seconds

        val secondActivity = getInstrumentation()
            .waitForMonitorWithTimeout(monitor, 10000)
        assertNotNull(secondActivity)
    }

}