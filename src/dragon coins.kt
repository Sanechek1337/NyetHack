//Задание драконьи монеты(глава 8)
var dragCoin = 5.0

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun performPurchase(price: Double): Boolean {
    var priceInDc = price / 1.43
    displayBalance()
    println("Purchasing item for $price g/ ${"%.4f".format(priceInDc)} DC")

    if (dragCoin >= priceInDc) {
        val remainingBalance = dragCoin - priceInDc
        println("Remaining balance: ${"%.4f".format(remainingBalance)}")

        dragCoin = remainingBalance
        displayBalance()
        return true
    } else {
        return false
    }
}// условие для задания(обработка отрицательного баланса)

private fun displayBalance() {
    println("Player's purse balance: ${"%.4f".format(dragCoin)}")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aioeuAEOIU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

    val (type, name, price) = menuData.split(',')

//    performPurchase(price.toDouble())
    val x = if (performPurchase(price.toDouble())) {
        1
    } else 0 // х для задания(обработка отрицательного баланса)

    val message = if (x == 1) { // условие для задания(обработка отрицательного баланса)
        "Madrigal buys a $name ($type) for $price" // было по дефолту
    } else "Madrigal doesn't have enough money" // для задания

    println(message)

    if (x == 1) { // условие для задания
        val phrase = if (name == "Dragon's Breath" || name == "DRAGON'S BREATH") {
            "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        } else {
            "Madrigal says: Thanks for the $name"
        }
        println(phrase)
    }
}
//глава 8. задание обработка отрицательного баланса
//перепроверить задание