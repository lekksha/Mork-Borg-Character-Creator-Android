package com.lekksha.morkborgcharactercreator

import android.os.Bundle
import android.widget.TextView
import androidx.annotation.ArrayRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.lekksha.morkborgcharactercreator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private fun generateFromResource(resource: Int): String {
        val names = resources.getStringArray(resource)
        return names.random();
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        changeTextViewFontToRakkas(binding.textViewName)
        
        // Randomizing stuff below

        // Randomizes name of the character
        // TODO: Refactor to one method

        binding.textViewName.text = generateFromResource(R.array.random_names)
    }

    private fun changeTextViewFontToRakkas(textView: TextView) {
        textView.typeface = ResourcesCompat.getFont(this, R.font.rakkas)
    }
}