package dev.wxlf.mobint_test_task.data.entities

import com.google.gson.annotations.SerializedName


data class CardEntity (

  @SerializedName("company"                ) var company                : CompanyEntity?                = CompanyEntity(),
  @SerializedName("customerMarkParameters" ) var customerMarkParameters : CustomerMarkParametersEntity? = CustomerMarkParametersEntity(),
  @SerializedName("mobileAppDashboard"     ) var mobileAppDashboard     : MobileAppDashboardEntity?     = MobileAppDashboardEntity()

)