package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class LoyaltyLevelEntity (

  @SerializedName("number"      ) var number      : Int?    = null,
  @SerializedName("name"        ) var name        : String? = null,
  @SerializedName("requiredSum" ) var requiredSum : Int?    = null,
  @SerializedName("markToCash"  ) var markToCash  : Int?    = null,
  @SerializedName("cashToMark"  ) var cashToMark  : Int?    = null

)