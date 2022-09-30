package com.example.risingtest.util

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import com.example.risingtest.databinding.DialogLoadingBinding

class LoadingDialog(context: Context): Dialog(context) {
    private lateinit var binding: DialogLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        window!!.setBackgroundDrawable(ColorDrawable())
        window!!.setDimAmount(0.0f)
        //window!!.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)


    }

    override fun show() {
        if(!this.isShowing) super.show()
    }

}