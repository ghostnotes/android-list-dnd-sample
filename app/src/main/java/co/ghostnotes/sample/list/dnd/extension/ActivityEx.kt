package co.ghostnotes.sample.list.dnd.extension

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> ComponentActivity.bindView(): T =
    DataBindingUtil.bind(getContentView())!!

private fun Activity.getContentView(): View =
    findViewById<ViewGroup>(android.R.id.content)[0]