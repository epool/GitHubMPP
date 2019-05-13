package dev.epool

import android.os.Build

actual fun platformName(): String = "Android ${Build.VERSION.RELEASE}"