package com.lekksha.morkborgcharactercreator
import android.content.Context
import kotlin.random.Random

abstract class ClassGenerator {
    fun run(context: Context) : GeneratedCharacter {
        val gen = GeneratedCharacter()
        gen.characterClass = chooseClass(context)
        gen.abilities = getAbilities()
        gen.stats = generateStats()
        gen.equipment = generateEquipment(context, gen.stats[2])
        gen.description = generateDescription()
        gen.armor = generateArmor()
        gen.weapons = generateWeapon()
        gen.silver = generateSilver()
        gen.hp = generateHP(gen.stats[3])
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

    protected fun generateEquipment(context : Context, statPresence: Int) : MutableList<String> {
        val equipment = mutableListOf<String>()
        equipment.addAll(generateFood(context))  // TODO: create an option to generate food and drinks separately
        equipment.addAll(generateContainer(context))
        equipment.add(generateSecondItem(context, statPresence))
        equipment.add(generateThirdItem(context))
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


    private fun generateSecondItem(context: Context, statPresence : Int): String {
        val secondItemIndex = Random.nextInt(0, context.resources.getStringArray(R.array.second_items).size)     // TODO: create an option to select "above" variants of containers
        when (secondItemIndex) {
            1 -> {
                return (statPresence + 4).toString() + " " + context.resources.getStringArray(R.array.second_items)[secondItemIndex]
            }
            2 -> {
                return context.resources.getStringArray(R.array.second_items)[secondItemIndex] + " " + (statPresence + 6).toString()
            }
            4 -> {
                return context.resources.getString(R.string.unclean_scroll) + ": " +
                        context.resources.getStringArray(R.array.unclean_scrolls)[Random.nextInt(
                            0,
                            context.resources.getStringArray(R.array.unclean_scrolls).size
                        )]
            }
            6 -> {
                return context.resources.getStringArray(R.array.second_items)[secondItemIndex] + " " + (statPresence + 4).toString()
            }
            10 -> {
                return context.resources.getStringArray(R.array.second_items)[secondItemIndex] + " " + Random.nextInt(1, 4+1).toString()
            }
            else -> {
                return context.resources.getStringArray(R.array.second_items)[secondItemIndex]
            }
        }
    }


    private fun generateThirdItem(context: Context): String {
        val thirdItemIndex = Random.nextInt(0, context.resources.getStringArray(R.array.third_items).size)     // TODO: create an option to select "above" variants of containers
        when (thirdItemIndex) {
            0 -> return context.resources.getStringArray(R.array.third_items)[thirdItemIndex] + " " + Random.nextInt(1, 4+1).toString()
            1 -> {
                return context.resources.getString(R.string.sacred_scroll) + ": " +
                        context.resources.getStringArray(R.array.sacred_scrolls)[Random.nextInt(
                            0,
                            context.resources.getStringArray(R.array.sacred_scrolls).size
                        )]
            }
            2 -> return context.resources.getString(R.string.vicious_dog_p1) + (Random.nextInt(1, 6 + 1) + 2).toString() + context.resources.getString(R.string.vicious_dog_p2)
            3 -> return Random.nextInt(1, 4 + 1).toString() + R.string.monkeys_p1 + (Random.nextInt(1, 6 + 1) + 2).toString() + R.string.monkeys_p2
            else -> return context.resources.getStringArray(R.array.third_items)[thirdItemIndex]
        }
    }


    protected abstract fun generateDescription() : MutableList<String>
   /* TODO: Generation of stats requires users selection of two out of three ability scores */


    protected fun generateStats() : MutableList<Int> {
       var summator = 0
       val strength = regularStatGenerator()
       val agility = regularStatGenerator()
       val presence = regularStatGenerator()
       val toughness = regularStatGenerator()
       return mutableListOf<Int>(strength, agility, presence, toughness)
    }

    private fun regularStatGenerator() : Int {
        var sum = 0
        repeat(3) {
            sum += (1..6).random()
        }
        var res = 0
        when (sum) {
            in 1..4 -> res = -3
            in 5..6 -> res = -2
            in 7..8 -> res = -1
            in 9..12 -> res = 0
            in 13 .. 14 -> res = 1
            in 15..16 -> res = 2
            in 17..20 -> res = 3
            else -> throw Exception("Trouble generating stats: Sum is not in the range")
        }
        return res
    }


    protected fun generateArmor(context: Context) : String {    // TODO fix generation with scrolls
        return context.resources.getStringArray(R.array.armor).random()
    }


    protected abstract fun generateWeapon() : MutableList<String>


    protected abstract fun generateSilver() : Int


    protected fun generateHP(statToughness: Int) : Int {
        val hp = Random.nextInt(1, 8 + 1) + statToughness
        return if (hp < 1) 1 else hp
    }


    protected fun generateOmens() : Int {
        return Random.nextInt(1, 2+1)
    }


    protected fun getPowers() : MutableList<String> {
        return TODO("Provide the return value")
    }  // TODO:
}