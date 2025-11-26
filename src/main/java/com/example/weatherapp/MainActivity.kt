package com.example.weatherapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.ActivityMainBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import org.json.JSONObject
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var currentCity: String ="Urmia,Sadi"

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //دکمه های شهر ها : تبریز،اردبیل،زنجان

        binding.buttonTabriz.setOnClickListener {
            currentCity = "Tabriz,IR"
            startLoadingState()
            getData(currentCity)
        }

        binding.buttonArdabil.setOnClickListener {
            getData("Ardabil,IR")
            startLoadingState()
            getData(currentCity)
        }

        binding.buttonZanjan.setOnClickListener {
            getData("Zanjan,IR")
            startLoadingState()
            getData(currentCity)
        }

        startLoadingState()
        getData(currentCity)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showContent(
        cityName: String,
        weatherDescription: String,
        imageUrl: String,
        sunrise: Int,
        sunset: Int,
        temp: Double,
        feelsLike: Double,
        tempMin: Double,
        tempMax: Double,
        pressure: Int,
        humidity: Int,
        sea_level: Int,
        ground_level: Int
    ) {
        binding.imageViewTower.visibility = View.VISIBLE
        binding.progressBar.visibility = View.INVISIBLE
        binding.textViewCityName.text = cityName
        binding.textViewWeatherDescription.text = weatherDescription
        binding.textViewSunrise.text = getTimeFromUnixTime(sunrise)
        binding.textViewSunset.text = getTimeFromUnixTime(sunset)
        binding.textViewTemp.text = " دما : ${if (temp.isNaN()) "—" else temp}"
        binding.textViewFeelsLike.text = " دمای احساس شده : ${if (feelsLike.isNaN()) "—" else feelsLike}"
        binding.textViewTempMin.text = " حداقل دما : ${if (tempMin.isNaN()) "—" else tempMin}"
        binding.textViewTempMax.text = " حداکثر دما : ${if (tempMax.isNaN()) "—" else tempMax}"
        binding.textViewPressure.text = " فشار هوا : $pressure"
        binding.textViewHumidity.text = " رطوبت هوا : $humidity"
        binding.textViewSeaLevel.text = " سطح دریا : $sea_level"
        binding.textViewGroundlevel.text = " سطح زمین : $ground_level"

        Glide.with(this@MainActivity).load(imageUrl).into(binding.imageViewWeather)
    }

    private fun getTimeFromUnixTime(unixTime: Int): String {
        if (unixTime <= 0) return "—"
        val time = unixTime.toLong() * 1000L
        val date = Date(time)
        val formatter = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return formatter.format(date)
    }

    private fun getData(city: String? = null){
        val client = OkHttpClient()

        val apiKey = "89b58d0145a98ba71b882bf706fb3df5"
        val cityToUse = city ?: currentCity
        val url = "https://api.openweathermap.org/data/2.5/weather?q=${cityToUse}&appid=${apiKey}&lang=fa&units=metric"

        val request = Request.Builder()
            .url(url)
            .build()

        try {
            currentCall?.cancel()
        } catch (e: Exception) {
        }

        currentCall = client.newCall(request)
        currentCall!!.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.d("tagx", "onFailure: failed -> ${e.message}")
                runOnUiThread {
                    setButtonsEnabled(true)
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.imageViewTower.visibility = View.VISIBLE
                    binding.textViewWeatherDescription.text = "خطا در دریافت اطلاعات"
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    onFailure(call, IOException("Unsuccessful: ${response.code}"))
                    return
                }
                val rawContent = response.body!!.string()//string in json format
                getDataAndShowThem(rawContent)
            }
        })
    }

    private fun getDataAndShowThem(rawData: String){
        try {
            val jsonObject = JSONObject(rawData)

        val weatherArray = jsonObject.getJSONArray("weather")
        val weatherObject = weatherArray.getJSONObject(0)
        val description = weatherObject.getString("description")
        val iconId = weatherObject.getString("icon")
        val imageUrl = "https://openweathermap.org/img/wn/${iconId}@2x.png"

        val sysObj = jsonObject.optJSONObject("sys")
        val sunrise = sysObj?.optInt("sunrise") ?: 0
        val sunset = sysObj?.optInt("sunset") ?: 0

        val mainObj = jsonObject.getJSONObject("main")
        val temp = mainObj.optDouble("temp", Double.NaN)
        val feelsLike = mainObj.optDouble("feels_like", Double.NaN)
        val tempMin = mainObj.optDouble("temp_min", Double.NaN)
        val tempMax = mainObj.optDouble("temp_max", Double.NaN)
        val pressure = mainObj.optInt("pressure", 0)
        val humidity = mainObj.optInt("humidity", 0)
        val sea_level = mainObj.optInt("sea_level", 0)
        val ground_level = mainObj.optInt("grnd_level", 0)

            runOnUiThread {
                showContent(
                    jsonObject.optString("name", "—"),
                    description,
                    imageUrl,
                    sunrise,
                    sunset,
                    temp,
                    feelsLike,
                    tempMin,
                    tempMax,
                    pressure,
                    humidity,
                    sea_level,
                    ground_level
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            runOnUiThread {
                setButtonsEnabled(true)
                binding.progressBar.visibility = View.INVISIBLE
                binding.imageViewTower.visibility = View.VISIBLE
                binding.textViewWeatherDescription.text = "خطا در پردازش داده‌ها"
            }
        }
    }

    fun reloadDate(view: View){
        startLoadingState()
        getData(currentCity)

    }

    private fun startLoadingState(){
        binding.imageViewTower.visibility = View.INVISIBLE
        binding.progressBar.visibility = View.VISIBLE

        //binding.textViewCityName.text = "--"
        binding.textViewWeatherDescription.text = "--"
        binding.textViewSunrise.text = "--"
        binding.textViewSunset.text = "--"
        binding.textViewTemp.text = "--"
        binding.textViewFeelsLike.text = "--"
        binding.textViewTempMin.text = "--"
        binding.textViewTempMax.text = "--"
        binding.textViewPressure.text = "--"
        binding.textViewHumidity.text = "--"
        binding.textViewSeaLevel.text = "--"
        binding.textViewGroundlevel.text = "--"

        Glide.with(this@MainActivity).load(R.drawable.ic_refresh).into(binding.imageViewWeather)

        setButtonsEnabled(false)
    }

    private fun setButtonsEnabled(enabled: Boolean) {
        binding.buttonTabriz.isEnabled = enabled
        binding.buttonArdabil.isEnabled = enabled
        binding.buttonZanjan.isEnabled = enabled
    }

    
    private fun updateTopImageForCity(city: String) {
        when (city) {
            "Tabriz,IR" -> Glide.with(this).load(R.drawable.tabriz_image).into(binding.imageViewTower)
            "Ardabil,IR" -> Glide.with(this).load(R.drawable.ardabil_image).into(binding.imageViewTower)
            "Zanjan,IR"  -> Glide.with(this).load(R.drawable.zanjan_image).into(binding.imageViewTower)
            else -> Glide.with(this).load(R.drawable.urmia_image).into(binding.imageViewTower)
        }
    }
}
