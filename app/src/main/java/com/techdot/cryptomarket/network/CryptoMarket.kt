package com.techdot.cryptomarket.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class CryptoMarket(
    @Json(name = "markets") val markets : List<CryptoModel>
) {
}