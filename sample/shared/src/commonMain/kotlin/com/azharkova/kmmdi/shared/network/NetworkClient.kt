package com.azharkova.kmmdi.shared.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class NetworkClient {

    val httpClient = HttpClient {
        install(JsonFeature) {
            val jsonDecoder = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(jsonDecoder)
        }
    }

    suspend inline fun <reified T> loadData(url: String): T? {
        return httpClient.get(url)
    }

    suspend inline fun <reified T> loadContentData(url: String): T? {
        val json = httpClient.get<String> {
            url {
                protocol = URLProtocol.HTTP
                host = com.azharkova.kmmdi.shared.network.Configuration.BASE_RAW_URL
                encodedPath = url
            }
        }
        print(json)
        val jsonDecoder = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
        val result = jsonDecoder.decodeFromString<T>(json)

        return result
    }
}
