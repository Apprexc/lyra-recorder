package com.example.camacttry.network

import com.example.camacttry.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Minimal API client stub.
 * - Uses OkHttp.
 * - Reads API key from BuildConfig (wired via local.properties / GitHub Secrets).
 * - Provides a simple health check call (mock-ready).
 */
object ApiClient {

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Example GET request to a placeholder endpoint.
     * Replace baseUrl with a real one when ready.
     */
    fun healthCheck(baseUrl: String = "https://example.com/health"): String {
        val request = Request.Builder()
            .url(baseUrl)
            .addHeader("Authorization", "Bearer ${BuildConfig.OPENAI_API_KEY}")
            .build()

        httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Unexpected code $response")
            }
            return response.body?.string() ?: ""
        }
    }
}
