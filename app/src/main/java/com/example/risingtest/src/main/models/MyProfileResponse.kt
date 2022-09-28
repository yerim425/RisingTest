package com.example.risingtest.src.main.models

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class MyProfileResponse(
    @SerializedName("result") val result: ResultMyProfile
): BaseResponse()