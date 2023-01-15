package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class LoyaltyLevelEntity (

  @SerializedName("number"      ) var number      : Int,
  @SerializedName("name"        ) var name        : String,
  @SerializedName("requiredSum" ) var requiredSum : Int,
  @SerializedName("markToCash"  ) var markToCash  : Int,
  @SerializedName("cashToMark"  ) var cashToMark  : Int

)