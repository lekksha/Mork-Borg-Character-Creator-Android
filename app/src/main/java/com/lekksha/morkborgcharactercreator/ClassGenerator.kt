package com.lekksha.morkborgcharactercreator
import android.content.Context

abstract class ClassGenerator {
    public fun run(context: Context) : GeneratedCharacter {
        val gen = GeneratedCharacter()
        gen.characterClass = chooseClass(context)
        gen.abilities = getAbilities()
        gen.equipment = generateEquipment()
        gen.description = generateDescription()
        gen.stats = generateStats()
        gen.armor = generateArmor()
        gen.weapons = generateWeapon()
        gen.silver = generateSilver()
        gen.hp = generateHP()
        gen.omens = generateOmens()
        gen.powers = getPowers()
        return gen
    }

    protected fun chooseClass(context: Context) : String {
        return context.resources.getStringArray(R.array.classes)[0]
    }

    protected abstract fun getAbilities() : MutableList<String>

    protected abstract fun generateEquipment() : MutableList<String>
    protected abstract fun generateDescription() : MutableList<String>
    protected abstract fun generateStats() : MutableList<Int>
    protected abstract fun generateArmor() : String
    protected fun generateArmor(context: Context) : String {    // TODO fix generation with scrolls
        return context.resources.getStringArray(R.array.armor).random()
    }
    protected abstract fun generateWeapon() : MutableList<String>
    protected abstract fun generateSilver() : Int
    protected abstract fun generateHP() : Int
    protected abstract fun generateOmens() : Int
    protected fun getPowers() : MutableList<String> {
        return TODO("Provide the return value")
    }  // TODO:

}