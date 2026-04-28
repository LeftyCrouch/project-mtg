package com.crouch.projectmtg.shared.core.dataStore

import androidx.datastore.core.okio.OkioSerializer
import com.crouch.projectmtg.shared.core.logger.LogIt
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import okio.BufferedSink
import okio.BufferedSource
import okio.IOException
import okio.use

internal object AppSettingsSerializer : OkioSerializer<AppSettings> {
    override val defaultValue: AppSettings = AppSettings()

    override suspend fun readFrom(source: BufferedSource): AppSettings =
        try {
            Json.decodeFromString<AppSettings>(source.readUtf8())
        } catch (e: SerializationException) {
            LogIt.error(
                throwable = e
            ) { "Failed to read datastore json" }
            AppSettings()
        } catch (e: IllegalArgumentException) {
            LogIt.error(
                throwable = e
            ) { "Datastore object does not match cache on device." }
            AppSettings()
        }

    override suspend fun writeTo(
        t: AppSettings,
        sink: BufferedSink
    ) {
        sink.use {
            try {
                it.writeUtf8(Json.encodeToString(AppSettings.serializer(), t))
            } catch (e: IOException) {
                LogIt.error(
                    throwable = e
                ) { "Failed to write datastore cache." }
            } catch (e: SerializationException) {
                LogIt.error(
                    throwable = e
                ) { "Datastore write does not match datastore object." }
            }
        }
    }
}
