package com.fahad.samples.compose_template_ii.utils.config

enum class MODE {
    LOCAL, STAGING, PRODUCTION
}

object CONSTANTS {

    // Configuration Controls
    object CONFIG {
        val APP_MODE = MODE.STAGING
        fun isProductionMode(): Boolean = APP_MODE == MODE.PRODUCTION
    }

    // Host
    object SERVER {
        private const val LOCAL_BASE_URL = ""
        private const val STAGING_BASE_URL = "https://cb.media/"
        private const val PRODUCTION_BASE_URL = ""
        val BASE_URL: String
            get() {
                return when (CONFIG.APP_MODE) {
                    MODE.PRODUCTION -> PRODUCTION_BASE_URL
                    MODE.STAGING -> STAGING_BASE_URL
                    else -> LOCAL_BASE_URL
                }
            }
    }

    // Links
    object LINKS {}

    object API {
        const val V1 = "api/"
    }

    // Apis
    object APIS {
        const val LOGIN = API.V1.plus("login/")
        const val SIGN_UP = API.V1.plus("register/")
        const val FORGOT_PASSWORD = API.V1.plus("forgot-password/")

    }

    object VARIABLES {
        const val NAME = "name"
        const val SLUG = "slug"
        const val ACTION = "action"
    }

    // Network
    object NETWORK {
        const val READ_TIMEOUT: Long = 60
        const val CONNECTION_TIMEOUT: Long = 10

        const val SOMETHING_WENT_WRONG = "Something went wrong.\nReason: %s"
        const val INTERNET_CONNECTIVITY = "Internet connection issue"
        const val NOT_FOUND = "Not Found"
        const val UN_AUTHORIZED = "User Unauthorized"
        const val INTERNAL_SERVER_ERROR = "Server Internal Error"
        const val UNKNOWN_ERROR = "Unknown Error Occurred"
    }

    object MESSAGES {
        const val SOMETHING_WENT_WRONG_PUBLIC = "Something went wrong. Please try later."
        const val UPLOADING_FAILED = "Something went wrong during uploading. Please try later."
        const val AGREE_POLICIES = "Please agree with all terms and policies by marking check."
    }
}