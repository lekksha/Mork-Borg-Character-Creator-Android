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
   /* TODO: Generation of stats requires users selection of two out of three ability scores */
    protected fun generateStats() : List<Int> {
       var summator = 0
       val strength = regularStatGenerator()
       val agility = regularStatGenerator()
       val presence = regularStatGenerator()
       val toughness = regularStatGenerator()
       return listOf<Int>(strength, agility, presence, toughness)
    }

    private fun regularStatGenerator() : Int {
        var sum = 0
        repeat(3) {
            sum += (1..6).random()
        }
        return sum
        }
    }
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