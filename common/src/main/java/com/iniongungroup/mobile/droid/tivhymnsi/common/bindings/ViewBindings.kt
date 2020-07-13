package com.iniongungroup.mobile.droid.tivhymnsi.common.bindings

import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

@BindingAdapter("app:fontTypeface")
fun setFontStyle(textView: AppCompatTextView, fontName: String) {
    textView.typeface = Typeface.createFromAsset(textView.context.assets, "font/$fontName")
}

@BindingAdapter("app:fontTypeface")
fun setFontStyle(button: MaterialButton, fontName: String) {
    button.typeface = Typeface.createFromAsset(button.context.assets, "font/$fontName")
}

@BindingAdapter("app:fontTypeface")
fun setFontStyle(textInputLayout: TextInputLayout, fontName: String) {
    textInputLayout.typeface = Typeface.createFromAsset(textInputLayout.context.assets, "font/$fontName")
}

@BindingAdapter("app:fontTypeface")
fun setFontStyle(textInputEditText: TextInputEditText, fontName: String) {
    textInputEditText.typeface = Typeface.createFromAsset(textInputEditText.context.assets, "font/$fontName")
}