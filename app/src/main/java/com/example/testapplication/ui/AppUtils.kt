package com.example.testapplication.ui

import android.R.attr
import java.util.regex.Matcher
import java.util.regex.Pattern


class AppUtils {
    companion object{
        fun isPasswordValid(password: String?): Boolean
        {



           val p: Pattern = Pattern.compile(Constants.PASSWORD_REGEX)

            // If the password is empty
            // return false

            // If the password is empty
            // return false
            if (password== null) {
                return false
            }

            // Pattern class contains matcher() method
            // to find matching between given password
            // and regular expression.

            // Pattern class contains matcher() method
            // to find matching between given password
            // and regular expression.
            val m: Matcher = p.matcher(password)

            // Return if the password
            // matched the ReGex

            // Return if the password
            // matched the ReGex
            return m.matches()
        }

        // email validation
        /**
         *
         */
        fun isEmailValid(email:String?):Boolean
        {
            val p: Pattern = Pattern.compile(Constants.EMAIL_REGEX)

            // If the email is empty
            // return false

            // If the email is empty
            // return false
            if (email== null) {
                return false
            }

            else if(email.length>20 || email.length<7)
            {
                return false
            }

            // Pattern class contains matcher() method
            // to find matching between given email
            // and regular expression.
            val m: Matcher = p.matcher(email)


            // Return if the email
            // matched the ReGex
            return m.matches()

            return false
        }
    }
}