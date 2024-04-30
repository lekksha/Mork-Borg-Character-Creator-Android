package com.lekksha.morkborgcharactercreator
import com.lekksha.morkborgcharactercreator.GeneratedCharacter

abstract class ClassGenerator {
    public fun run() : GeneratedCharacter {
        val gen = GeneratedCharacter()
        gen.characterClass = chooseClass()
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
    protected abstract fun chooseClass() : String
    protected abstract fun getAbilities() : MutableList<String>
    protected abstract fun generateEquipment() : MutableList<String>
    protected abstract fun generateDescription() : MutableList<String>
    protected abstract fun generateStats() : MutableList<Int>
    protected abstract fun generateArmor() : String
    protected abstract fun generateWeapon() : MutableList<String>
    protected abstract fun generateSilver() : Int
    protected abstract fun generateHP() : Int
    protected abstract fun generateOmens() : Int
    protected fun getPowers() : MutableList<String> {
        return TODO("Provide the return value")
    }  // TODO:

}