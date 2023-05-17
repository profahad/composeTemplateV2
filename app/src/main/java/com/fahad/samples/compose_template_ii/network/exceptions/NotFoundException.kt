package com.fahad.samples.compose_template_ii.network.exceptions

import com.fahad.samples.compose_template_ii.utils.config.CONSTANTS
import java.io.IOException

class NotFoundException : IOException() {
    override val message: String
        get() = CONSTANTS.NETWORK.NOT_FOUND
}