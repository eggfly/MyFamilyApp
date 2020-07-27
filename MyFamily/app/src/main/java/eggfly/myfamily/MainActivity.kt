package eggfly.myfamily

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.View
import eggfly.myfamily.util.DateTimeUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    private lateinit var mContentView: View
    private lateinit var mAnalogClock: MyAnalogClock
    private val mRunnable = object : Runnable {
        override fun run() {
            updateAllElements()
            mContentView.postDelayed(this, UPDATE_INTERVAL)
        }
    }

    private fun updateAllElements() {
        Log.d(TAG, "updateAllElements")
        days.text = DateTimeUtils.getAgeString(BIRTHDAY)
    }

    @Suppress("SpellCheckingInspection")
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weather1.settings.javaScriptEnabled = true
        weather1.loadUrl("file:///android_asset/weather_haidian.html")

        weather2.settings.javaScriptEnabled = true
        weather2.loadUrl("file:///android_asset/weather_changping.html")


        mContentView = findViewById(android.R.id.content)
        mContentView.setOnClickListener {
            startActivity(Intent(this, WeatherActivity::class.java))
        }
        // mAnalogClock = findViewById(R.id.analog)
        mContentView.postDelayed(mRunnable, UPDATE_INTERVAL)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        updateAllElements()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {
        private const val TAG = "MainActivity"
        private const val UPDATE_INTERVAL = DateUtils.MINUTE_IN_MILLIS
        private val BIRTHDAY: Date

        // Used to load the 'native-lib' library on application startup.
        init {
            val calendar = Calendar.getInstance()
            // month is 0 based!
            calendar.set(2019, 10, 5)
            BIRTHDAY = calendar.time
            System.loadLibrary("native-lib")
        }
    }
}
