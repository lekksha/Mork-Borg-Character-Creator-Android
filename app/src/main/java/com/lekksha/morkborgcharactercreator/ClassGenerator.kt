package com.lekksha.morkborgcharactercreator
import com.lekksha.morkborgcharactercreator.GeneratedCharacter

abstract class ClassGenerator {
    public fun run() : GeneratedCharacter {
        val gen = GeneratedCharacter()
        chooseClass()
        getAbilities()
        generateEquipment()
        generateDescription()
        generateStats()
        generateArmor()
        generateWeapon()
        generateSilver()
        generateHP()
        generateOmens()
        getPowers()
        return gen
    }
    protected abstract fun chooseClass()
    protected abstract fun getAbilities()
    protected abstract fun generateEquipment()
    protected abstract fun generateDescription()
    protected abstract fun generateStats()
    protected abstract fun generateArmor()
    protected abstract fun generateWeapon()
    protected abstract fun generateSilver()
    protected abstract fun generateHP()
    protected abstract fun generateOmens()
    private fun getPowers() {}  // TODO:

}