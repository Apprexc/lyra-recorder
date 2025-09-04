package com.example.camacttry

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Basic unit test to keep CI green and validate wiring.
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun apiKey_placeholder_exists() {
        // The placeholder from BuildConfig should be present (may be empty string in CI).
        assert(BuildConfig.OPENAI_API_KEY != null)
    }
}