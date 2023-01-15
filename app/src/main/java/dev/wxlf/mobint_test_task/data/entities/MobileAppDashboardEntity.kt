package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class MobileAppDashboardEntity (

  @SerializedName("companyName"         ) var companyName         : String,
  @SerializedName("logo"                ) var logo                : String,
  @SerializedName("backgroundColor"     ) var backgroundColor     : String,
  @SerializedName("mainColor"           ) var mainColor           : String,
  @SerializedName("cardBackgroundColor" ) var cardBackgroundColor : String,
  @SerializedName("textColor"           ) var textColor           : String,
  @SerializedName("highlightTextColor"  ) var highlightTextColor  : String,
  @SerializedName("accentColor"         ) var accentColor         : String

)