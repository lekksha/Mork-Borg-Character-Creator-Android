package com.lekksha.morkborgcharactercreator

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.lekksha.morkborgcharactercreator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        changeTextViewFontToRakkas(binding.textViewName)
        binding.textViewName.text = generateFromResource(R.array.random_names)

        putUpGeneratedCharacter(ClassGenerator().run(this))
        addAddDescriptionButton()

        binding.textViewName.setOnClickListener {
            binding.textViewName.text = generateFromResource(R.array.random_names)
            putUpGeneratedCharacter(ClassGenerator().run(this))
        }
    }

    private fun addAddDescriptionButton() {
        val button = createAddDescriptionButton()
        binding.linearLayoutDiscription.addView(button)
        button.setOnClickListener {
            val textInputLayout = createDescriptionField()

            binding.linearLayoutDiscription.removeView(button)
            binding.linearLayoutDiscription.addView(textInputLayout)
            binding.linearLayoutDiscription.addView(button)
        }
    }


    private fun generateFromResource(resource: Int): String {
        val names = resources.getStringArray(resource)
        return names.random();
    }


    private fun putUpGeneratedCharacter(character: GeneratedCharacter) {
        binding.TextInputEditTextClass.setText(character.characterClass)
        binding.TextInputEditTextArmor.setText(character.armor)
        binding.TextInputEditTextSilver.setText(character.silver.toString())
        binding.TextInputEditTextOmens.setText(character.omens.toString())
        binding.TextInputEditTextWeapon1.setText(character.weapons[0])
    }


    private fun createAddDescriptionButton(): MaterialButton {
        val button = MaterialButton(this, null, com.google.android.material.R.attr.materialIconButtonStyle)
        button.text = "Add description fact"
        button.setIconResource(R.drawable.ic_add_24)
        return button
    }

    private fun createDescriptionField(): TextInputLayout {
        val textInputLayout = TextInputLayout(this)
        textInputLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        //textInputLayout.hint = "Description fact"
        val textInputEditText = TextInputEditText(textInputLayout.context)
        textInputEditText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textInputLayout.addView(textInputEditText)
        return textInputLayout
    }

    private fun changeTextViewFontToRakkas(textView: TextView) {
        textView.typeface = ResourcesCompat.getFont(this, R.font.rakkas)
    }
}