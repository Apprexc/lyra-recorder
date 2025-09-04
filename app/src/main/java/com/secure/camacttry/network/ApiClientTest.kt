package com.example.camacttry.network

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * CI-safe test for ApiClient using MockWebServer.
 * Verifies that the stub healthCheck() path works without hitting real APIs.
 */
class ApiClientTest {

    private lateinit var server: MockWebServer

    @Before
    fun setup() {
        server = MockWebServer()
        server.start()
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun healthCheck_returnsExpectedBody() {
        val expectedBody = "OK"
        server.enqueue(MockResponse().setBody(expectedBody).setResponseCode(200))

        val url = server.url("/health").toString()
        val result = ApiClient.healthCheck(url)

        assertEquals(expectedBody, result)
    }
}
