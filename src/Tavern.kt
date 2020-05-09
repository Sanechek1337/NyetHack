const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
//    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("shandy,DRAGON'S BREATH,5.91") //задание
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aioeuAEOIU]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    val phrase = if (name == "Dragon's Breath" || name == "DRAGON'S BREATH") {
//        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        "Madrigal exclaims: ${toDragonSpeak("IT'S GOT WHAT ADVENTURERS CRAVE!")}" // задание
    } else {
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}
//строки. доделать задание