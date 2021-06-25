package com.techdot.cryptomarket.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.round

data class CryptoModel(
    @Json(name = "symbol")
    var coin: String,
    @Json(name = "price")
    var price: Double,
    @Json(name = "change_24h")
    var change: Double
) {
//    private var cryptoPriceDouble = (BigDecimal(price).setScale(2, RoundingMode.HALF_EVEN))
//    private var hundred = 100
//    private var percentChange = (cryptoPriceDouble.minus(cryptoPriceDouble.add(change.toBigDecimal())))
//        .divide(hundred.toBigDecimal())
//
//    var cryptoPrice = "$$cryptoPriceDouble"
//    var percentDifference = "$percentChange%"
}