package com.fox.commonview.stateslayout

enum class PageState constructor(internal var VALUE: String) {
    INITIALIZING("Initializing"),
    FAIL("Fail"),
    ERROR("Error"),
    NORMAL("Normal"),
    REFRESH("Refresh")
}