package com.ticonsys.datetimepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.*

class TimePickerFragment : DialogFragment(),  TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(requireContext(), this, hour, minute, false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val amPm = if(hourOfDay >= 12) "PM" else "AM"
        var hour = hourOfDay % 12
        if(hour == 0)
            hour = 12
        val selectedTime = String.format("%02d:%02d %s", hour, minute, amPm)
        timePickerCallback?.let { it(selectedTime) }
    }
    private var timePickerCallback: ((String) -> Unit)? = null
    fun show(manager: FragmentManager, tag: String?, timePickerCallback: ((String) -> Unit)){
        this.timePickerCallback = timePickerCallback
        show(manager, tag)
    }

}