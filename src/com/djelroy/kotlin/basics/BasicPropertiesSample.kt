package com.djelroy.kotlin.basics

class Person {

    // Default properties
    var firstName = "defaultFirstName"
    var lastName = "defaultLastName"
    var country: String? = null

    // Customer setter
    var isFrench = false
        // Someone can be French only if their country is set to France
        set(value) = if (value) field = (country == "France") else field = false

    // Backing property for 'visitedCountries'
    private var _countries: ArrayList<String>? = null
    val visitedCountries: ArrayList<String>
        get() {
            if(_countries == null){
                _countries = ArrayList()
            }

            return _countries ?: throw AssertionError("Set to null by another thread")
        }

    override fun toString(): String {
        return "$firstName $lastName ${country ?: ""} ${if (isFrench) "French" else "Foreigner"}"
    }
}

fun main(args: Array<String>) {
    val bobMarley = Person()

    bobMarley.firstName = "Bob"
    bobMarley.lastName = "Marley"
    bobMarley.country = "Jamaica"
    bobMarley.isFrench = true;

    println(bobMarley)
    println("Visited countries ${bobMarley.visitedCountries}")

    bobMarley.country = "France"
    bobMarley.isFrench = true;
    bobMarley.visitedCountries.add("France")
    bobMarley.visitedCountries.add("Canada")

    println("Visited countries added and country set to France now")
    println(bobMarley)
    println("Visited countries ${bobMarley.visitedCountries}")
}