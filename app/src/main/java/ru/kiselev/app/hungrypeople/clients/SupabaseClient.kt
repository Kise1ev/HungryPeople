package ru.kiselev.app.hungrypeople.clients

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import ru.kiselev.app.hungrypeople.data.Secrets
import ru.kiselev.app.hungrypeople.models.Booking

object SupabaseClient {
    private const val SUPABASE_URL = Secrets.SUPABASE_URL
    private const val SUPABASE_KEY = Secrets.SUPABASE_KEY

    private val supabaseClient = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Postgrest)
    }

    suspend fun addBooking(booking: Booking) {
        supabaseClient.postgrest["booking"].insert(booking)
    }
}