package co.ghostnotes.sample.list.dnd.extension

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

fun <T : ViewDataBinding> Fragment.bindView(): T = DataBindingUtil.bind(view!!)!!
