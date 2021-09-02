package com.example.testpizzaapplication.presentation.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.testpizzaapplication.R
import retrofit2.HttpException
import java.net.ConnectException
import javax.inject.Inject

class ErrorHandler @Inject constructor(
    private val context: Context
) {

    fun createErrorToast(
        throwable: Throwable,
    ) {
        when (throwable) {
            is HttpException -> {
                showToast(R.string.server_error)
            }
            else -> {
                showToast(R.string.connection_error)
            }
        }
    }

    private fun showToast(@StringRes textId: Int) {
        Toast.makeText(context, textId, Toast.LENGTH_SHORT).show()
    }
}