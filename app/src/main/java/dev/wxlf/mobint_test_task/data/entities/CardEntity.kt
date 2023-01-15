package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class CardEntity (

  @SerializedName("company"                ) var company                : CompanyEntity,
  @SerializedName("customerMarkParameters" ) var customerMarkParameters : CustomerMarkParametersEntity,
  @SerializedName("mobileAppDashboard"     ) var mobileAppDashboard     : MobileAppDashboardEntity

)