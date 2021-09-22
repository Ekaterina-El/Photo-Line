package com.example.photoline.utils

import android.os.CountDownTimer

class AppCountTimer(
    millisInFuture: Long,
    countDownInterval: Long,
    val onTicked: (Long) -> Unit,
    val onFinished: () -> Unit
) : CountDownTimer(millisInFuture, countDownInterval) {
    override fun onTick(p0: Long) {
        onTicked(p0)
    }

    override fun onFinish() {
        onFinished()
    }
}