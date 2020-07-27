package eggfly.myfamily

import android.annotation.SuppressLint
import android.os.Bundle

class WeatherActivity : BaseActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
    }
}