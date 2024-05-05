package com.lekksha.morkborgcharactercreator
import android.content.Context
import kotlin.random.Random

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

    protected fun getAbilities() : MutableList<String> {
        return mutableListOf("None")
    }

    protected fun generateEquipment(context : Context) : MutableList<String> {
        val equipment = mutableListOf<String>()
        equipment.addAll(generateFood(context))  // TODO: create an option to generate food and drinks separately
        equipment.addAll(generateContainer(context))
        equipment.add(generateSecondItem())
        equipment.add(generateThirdItem())
        return equipment
    }

    private fun generateFood(context: Context): MutableList<String> {
        val res = mutableListOf<String>()
        val food = context.resources.getString(R.string.daily_rations) + ": " + Random.nextInt(1,5)
        res.add(food)
        val waterskin = context.resources.getString(R.string.waterskin)
        res.add(waterskin)
        return res
    }

    private fun generateContainer(context : Context): MutableList<String> {
        val containerIndex = Random.nextInt(0, context.resources.getStringArray(R.array.containers).size)     // TODO: create an option to select "above" variants of containers
        if (containerIndex !in 0..1)
            return mutableListOf<String>() // Also can returns only in case
        else return mutableListOf(context.resources.getStringArray(R.array.containers)[containerIndex])
    }

    protected abstract fun generateDescription() : MutableList<String>
   /* TODO: Generation of stats requires users selection of two out of three ability scores */
    protected fun generateStats() : MutableList<Int> {
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