package com.djelroy.kotlin.basics

// Function returning nullable value
fun getStringLenth(obj: Any) : Int? {
    if(obj !is String) return null
    return obj.length;
}

fun main(args: Array<String>){

    // Mutable variable & println
    println("******** Mutable variable & println **********")
    var str : Any = "one"
    println("getStringLenth($str) returns ${getStringLenth(str)}")
    str = 4
    println("getStringLenth($str) returns ${getStringLenth(str)}")
    println()

    println("******** For loop **********")
    // For loop by item
    val fruits = listOf("mango", "banana", "apple")
    for(item in fruits)
        println(item)

    // For loop by index
    val veggies = listOf("ulli", "murungakay", "pavakay", "takkali", "paruppu")
    for(ind in veggies.indices)
        println("Veggie at index $ind is ${veggies[ind]}")
    println()

    // While loop
    println("******** While loop **********")
    var index = 0
    while(index < fruits.size){
        println("${fruits[index]}")
        index++
    }
    println()


    // When expression and function inside com.djelroy.main() function!!!
    println("******** When + Nested function!!! **********")
    fun describe(obj: Any): String  =
            when(obj){
                1 -> "One"
                is Int -> "Int"
                "Hello" -> "Bonjour"
                is String-> "String"
                else -> "Unknown"
            }
    println(describe(1))
    println(describe(4))
    println(describe("Hello"))
    println(describe("Demain"))
    println(describe(4.50))
    println()

    // Elvis operator
    println("******** Elvis operator **********")
    var firstName : String? = null
    var lastName: String? = "Tyler"
    var name = firstName ?: "No first name"
    println(name)
    name = lastName ?: "No last name"
    println(name)
    println()

    // Range
    println("******** Range **********")
    val num = 4;
    if(num in 1..10)
        println("$num is in range")

    // Range iteration
    for(n in 1..5)
        print("$n ")
    println()

    // Range iteration over a progression
    for(n in 0..1000 step 100)
        print("$n ")
    println()

    // Range with downTo
    for(n in 5 downTo 1)
        print("$n ")
    println(); println()


    // Lambda & Function reference with filter and map
    println("******** Lambda & Function reference with filter and map **********")
    veggies
            .filter { !it.startsWith("p") }
            .sortedBy { it }
            .map(String::toUpperCase)
            .forEach{ println(it) }

}