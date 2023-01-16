package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName

data class ErrorEntity(

    @SerializedName("type") var type: String,
    @SerializedName("message") var message: String

)
