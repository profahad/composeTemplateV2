package com.fahad.samples.compose_template_ii.network.exceptions

import com.fahad.samples.compose_template_ii.utils.config.CONSTANTS
import java.lang.Exception

class UnKnownException : Exception() {
    override val message: String
        get() = CONSTANTS.NETWORK.UNKNOWN_ERROR
}