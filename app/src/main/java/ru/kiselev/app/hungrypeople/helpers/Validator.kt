package ru.kiselev.app.hungrypeople.helpers

object Validator {
    fun isValidEmail(email: String): Boolean {
        val emailPattern = Regex("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}\$")
        return emailPattern.matches(email)
    }

    fun isValidPhone(value: String): Boolean {
        val phoneRegex = Regex("^\\+7-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}$")
        return phoneRegex.matches(value)
    }

    fun isValidPeopleCount(count: String): Boolean {
        val number = count.toIntOrNull()
        return number != null && number in 1..7
    }
}