package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class CustomerMarkParametersEntity (

  @SerializedName("loyaltyLevel" ) var loyaltyLevel : LoyaltyLevelEntity,
  @SerializedName("mark"         ) var mark         : Int

)