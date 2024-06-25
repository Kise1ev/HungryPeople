package ru.kiselev.app.hungrypeople.clients

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import ru.kiselev.app.hungrypeople.models.Booking

object SupabaseClient {
    private const val SUPABASE_URL = "https://aushniidrgdnhohvezpw.supabase.co"
    private const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF1c2huaWlkcmdkbmhvaHZlenB3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTg0NjM2MTEsImV4cCI6MjAzNDAzOTYxMX0.oIwD2MaX5SKp3G5QRCwkXEnelYlKAG2scvE34oENSEI"

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