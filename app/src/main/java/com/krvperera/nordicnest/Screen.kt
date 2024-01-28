package com.krvperera.nordicnest

sealed class Screen(val route: String) {
    object MainScreen : Screen("mainScreen")
    object DetailedScreen : Screen("detailedScreen")

    object SettingsScreen : Screen("settingsScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                arg ->
                append("/$arg")
            }
        }
    }
}