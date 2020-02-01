package com.idealista.android.challenge.core.api.model

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.R

sealed class CommonError {
    object NoNetwork : CommonError()
    object ServerError : CommonError()
    object ClientError : CommonError()
    object Forbidden : CommonError()
    object UnknownError : CommonError()
    object NotFound : CommonError()
    object Canceled : CommonError()


    fun loadErrorMessage(): Int {
        return when (this) {
            NoNetwork -> R.string.error_no_network
            ServerError -> R.string.error_server
            ClientError -> R.string.error_client
            Forbidden -> R.string.error_forbidden
            UnknownError -> R.string.erro_unknown
            NotFound -> R.string.error_not_found
            Canceled -> R.string.error_canceled

        }
    }
}


fun CommonError.string() =
    if (this !is CommonError.UnknownError) CoreAssembler.stringsProvider.string(loadErrorMessage()) else ""