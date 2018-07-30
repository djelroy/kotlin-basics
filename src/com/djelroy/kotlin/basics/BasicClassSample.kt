package com.djelroy.kotlin.basics

/* ********************************
*   It's better to use a file per class.
*   This file defines multiple classes only to show how class works in Kotlin
*/

// Class to be extended, thus needs open annotation, default is final
// Class with a primary constructor and defining the type property
open class Animal (val type: String) {
    val message = "I'm always happy"
    open val description = "None"
    open fun invertMyType() = type.reversed()
}

// Derived class from Animal
open class Cat : Animal("cat"){

    // overriding property
    override val description: String
        get() = "I like to miaow"

    open fun miaow() = println("Miaow miaow miaow!")

    // use of final to prevent any subclass of Cat to override this method
    final override fun invertMyType() = super.invertMyType().capitalize()
}

// Class just extending another class
abstract class FrenchCat: Cat(){
    abstract override fun miaow()
}

fun main(args: Array<String>) {
    val animal = Animal("dog")
    val cat = Cat();

    println("I'm a ${animal.type}")
    println("Description: ${animal.description}")
    println("But just call me a ${animal.invertMyType()}!\n")

    println("I'm a ${cat.type}")
    println("I'm from the ${cat.invertMyType()} clan!")
    println("Description: ${cat.description}")

}