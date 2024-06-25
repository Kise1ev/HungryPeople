package ru.kiselev.app.hungrypeople.serializers

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.SimpleDateFormat
import java.util.*

object TimeSerializer : KSerializer<Date> {
    override val descriptor = PrimitiveSerialDescriptor("Time", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Date) {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        encoder.encodeString(format.format(value))
    }

    override fun deserialize(decoder: Decoder): Date {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        return format.parse(decoder.decodeString()) ?: throw IllegalArgumentException("Invalid time format")
    }
}