package app.test.guidomia.repository

import android.content.Context
import android.content.res.AssetManager
import app.test.guidomia.data.Car
import com.google.gson.Gson

class CarsRepo(private val context: Context) {
    fun getCars(): Array<Car> {
        return Gson().fromJson(getJson(), Array<Car>::class.java)
    }

    private fun getJson(): String {
        return context.assets.readAssetsFile(FILE_NAME)
    }

    companion object {
        private const val FILE_NAME = "car_list.json"
    }
}

fun AssetManager.readAssetsFile(fileName : String): String =
    open(fileName).bufferedReader().use{it.readText()}
