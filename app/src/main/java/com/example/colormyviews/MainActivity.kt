package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var box_one_color: Int = Color.WHITE
    var box_two_color: Int = Color.WHITE
    var box_three_color: Int = android.R.color.white
    var box_four_color: Int = android.R.color.white
    var box_five_color: Int = android.R.color.white
    var background_color: Int = android.R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text,
            box_four_text, box_five_text, constraint_layout, red_button, yellow_button,
            green_button)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> {
                view.setBackgroundColor(Color.DKGRAY)
                box_one_color = Color.DKGRAY
            }
            R.id.box_two_text -> {
                view.setBackgroundColor(Color.GRAY)
                box_two_color = Color.GRAY
            }

            // Boxes using Android color resources for background
            R.id.box_three_text -> {
                view.setBackgroundResource(android.R.color.holo_green_light)
                box_three_color = android.R.color.holo_green_light
            }
            R.id.box_four_text -> {
                view.setBackgroundResource(android.R.color.holo_green_dark)
                box_four_color = android.R.color.holo_green_dark
            }
            R.id.box_five_text -> {
                view.setBackgroundResource(android.R.color.holo_green_light)
                box_five_color = android.R.color.holo_green_light
            }

            // Boxes using custom colors for background
            R.id.red_button -> {
                box_three_text.setBackgroundResource(R.color.my_red)
                box_three_color = R.color.my_red
            }
            R.id.yellow_button -> {
                box_four_text.setBackgroundResource(R.color.my_yellow)
                box_four_color = R.color.my_yellow
            }
            R.id.green_button -> {
                box_five_text.setBackgroundResource(R.color.my_green)
                box_five_color = R.color.my_green
            }

            else -> {
                view.setBackgroundColor(Color.LTGRAY)
                background_color = Color.LTGRAY
            }
        }
    }

    // This code to save the colors probably isn't the best way of doing it, but it works.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("box_one_color", box_one_color)
        outState.putInt("box_two_color", box_two_color)
        outState.putInt("box_three_color", box_three_color)
        outState.putInt("box_four_color", box_four_color)
        outState.putInt("box_five_color", box_five_color)
        outState.putInt("background_color", background_color)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        box_one_color = savedInstanceState.getInt("box_one_color")
        box_one_text.setBackgroundColor(box_one_color)

        box_two_color = savedInstanceState.getInt("box_two_color")
        box_two_text.setBackgroundColor(box_two_color)

        box_three_color = savedInstanceState.getInt("box_three_color")
        box_three_text.setBackgroundResource(box_three_color)

        box_four_color = savedInstanceState.getInt("box_four_color")
        box_four_text.setBackgroundResource(box_four_color)

        box_five_color = savedInstanceState.getInt("box_five_color")
        box_five_text.setBackgroundResource(box_five_color)

        background_color = savedInstanceState.getInt("background_color")
        constraint_layout.setBackgroundColor(background_color)

    }

}
