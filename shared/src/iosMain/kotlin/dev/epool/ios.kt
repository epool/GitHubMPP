package dev.epool

import platform.UIKit.UIDevice

actual fun platformName(): String = with(UIDevice.currentDevice) {
    "${systemName()} ${systemVersion()}"
}