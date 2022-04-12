package app.test.guidomia.data

import androidx.annotation.DrawableRes
import app.test.guidomia.R
import java.text.DecimalFormat

@Suppress("ArrayInDataClass")
data class Car(
    val make: String,
    val model: String,
    val marketPrice: Float,
    val customerPrice: Float,
    val prosList: Array<String>,
    val consList: Array<String>,
    val rating: Int,
) {
    @get: DrawableRes
    val image: Int?
        get() = getCarImageRes(model)

    val price: String
        get() = getFormattedPrice()

    @DrawableRes
    private fun getCarImageRes(model: String): Int? {
        return when (model) {
            "Range Rover" -> {
                R.drawable.range_rover
            }
            "Roadster" -> {
                R.drawable.alpine_roadster
            }
            "3300i" -> {
                R.drawable.bmw_330i
            }
            "GLE coupe" -> {
                R.drawable.mercedez_benz_glc
            }
            else -> {
                null
            }
        }
    }

    private fun getFormattedPrice(): String {
        return if ( marketPrice < 1000 ) {
            marketPrice.toInt().toString()
        } else {
            val df = DecimalFormat()
            val thousands = marketPrice / 1000

            df.maximumFractionDigits = 2
            df.minimumFractionDigits = 0
            df.format(thousands) + "k"
        }
    }
}
