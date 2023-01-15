package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class MobileAppDashboardEntity (

  @SerializedName("companyName"         ) var companyName         : String? = null,
  @SerializedName("logo"                ) var logo                : String? = null,
  @SerializedName("backgroundColor"     ) var backgroundColor     : String? = null,
  @SerializedName("mainColor"           ) var mainColor           : String? = null,
  @SerializedName("cardBackgroundColor" ) var cardBackgroundColor : String? = null,
  @SerializedName("textColor"           ) var textColor           : String? = null,
  @SerializedName("highlightTextColor"  ) var highlightTextColor  : String? = null,
  @SerializedName("accentColor"         ) var accentColor         : String? = null

)