package com.location.wanandroid.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass
import com.location.wanandroid.R
import com.location.wanandroid.screen.home.HomeRoute

enum class TopDestination(
    @StringRes val titleId: Int,
    val selectIcon: ImageVector,
    val unselectIcon: ImageVector,
    val route: KClass<*>,
    @StringRes val iconTextId: Int = titleId,
    ) {
    Home(
        titleId = R.string.home,
        selectIcon = Icons.Rounded.Home,
        unselectIcon = Icons.Outlined.Home,
        route = HomeRoute::class,
    ),
    Setting(
        titleId = R.string.setting,
        selectIcon = Icons.Rounded.Settings,
        unselectIcon = Icons.Outlined.Settings,
        route = SettingRoute::class,
    )
}

@Serializable data object SettingRoute