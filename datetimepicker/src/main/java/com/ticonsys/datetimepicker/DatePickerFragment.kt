package com.ticonsys.datetimepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.*

class DatePickerFragment : DialogFragment(),  DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val mMonth = month + 1
        val selectedDate = String.format(
            "%04d-%02d-%02d",
            year,
            mMonth,
            dayOfMonth
        )
        datePickerCallback?.let { it(selectedDate) }
    }


    private var datePickerCallback: ((String) -> Unit)? = null
    fun show(manager: FragmentManager, tag: String?, datePickerCallback: ((String) -> Unit)){
        this.datePickerCallback = datePickerCallback
        show(manager, tag)
    }


}