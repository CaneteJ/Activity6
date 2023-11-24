package com.canete.canete_activity6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAlertDialog: Button = findViewById(R.id.btnAlertDialog)
        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        val btnTimePicker: Button = findViewById(R.id.btnTimePicker)

        btnAlertDialog.setOnClickListener {
            showAlertDialog()
        }

        btnDatePicker.setOnClickListener {
            showDatePickerDialog()
        }

        btnTimePicker.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("AlertDialog")

        // Set up the layout for the AlertDialog with an EditText for user input
        val input = EditText(this)
        builder.setView(input)

        builder.setMessage("This is an AlertDialog message.")
        builder.setPositiveButton("OK") { _, _ ->
            val userInput = input.text.toString()
            showToast("OK clicked with input: $userInput")
        }
        builder.setNegativeButton("Cancel") { _, _ ->
            showToast("Cancel clicked")
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                showToast("Selected date: $selectedYear-${selectedMonth + 1}-$selectedDay")
            },
            year, month, day
        )

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
                showToast("Selected time: $selectedHour:$selectedMinute")
            },
            hour, minute, true
        )

        timePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}