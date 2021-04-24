package co.ghostnotes.sample.list.dnd.extension

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.VibrationEffect
import android.os.Vibrator

fun Context.vibrate(millis: Long = 500L) {
    val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
    vibrator.vibrate(VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE))
}
