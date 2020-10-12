package com.ticonsys.datetimepickerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ticonsys.datetimepicker.DatePickerFragment
import com.ticonsys.datetimepicker.TimePickerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDate.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(supportFragmentManager, "Fragment1"){
                Log.d(TAG, "onCreate: Date: $it")
                tvDate.text = it
            }
        }

        tvTime.setOnClickListener {
            val timePickerFragment = TimePickerFragment()
            timePickerFragment.show(supportFragmentManager, "Fragment1"){
                Log.d(TAG, "onCreate: Time: $it")
                tvTime.text = it
            }
        }
    }
}