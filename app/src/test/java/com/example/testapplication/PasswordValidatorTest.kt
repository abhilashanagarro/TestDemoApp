package com.example.testapplication

import com.example.testapplication.ui.AppUtils
import junit.framework.Assert
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    @Test
    fun passwordValidator_CorrectPasswordSimple_ReturnsTrue() {
        assertTrue(AppUtils.isPasswordValid("Abhilasha@12"))
    }

    @Test
    fun passwordLengthLessThan8_ReturnFalse() {
        assertFalse(AppUtils.isPasswordValid("Abhi@1"))
    }

    @Test
    fun passwordValidator_EmptyString_ReturnsFalse() {
        assertFalse(AppUtils.isPasswordValid(""))
    }

    @Test
    fun passwordValidator_NullPassword_ReturnsFalse() {
        assertFalse(AppUtils.isPasswordValid(null))
    }
}
