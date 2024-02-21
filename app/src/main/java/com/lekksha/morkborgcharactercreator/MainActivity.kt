package com.lekksha.morkborgcharactercreator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.lekksha.morkborgcharactercreator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        changeTextViewFontToRakkas(binding.textViewName)

        // Randomizing stuff below

        // Randomizes name of the character
        // TODO: Refactor to one method
        val names = resources.getStringArray(R.array.random_names)
        val randomString = names.random()
        binding.textViewName.text = randomString

    }

    private fun changeTextViewFontToRakkas(textView: TextView) {
        textView.typeface = ResourcesCompat.getFont(this, R.font.rakkas)
    }
}