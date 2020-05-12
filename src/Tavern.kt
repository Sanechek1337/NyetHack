import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    playerSilver = 10
    playerGold = 10
    placeOrder("shandy,Dragon's Breath,10.1")
    playerSilver = 10
    playerGold = 10
    placeOrder("shandy,Dragon's Breath,10.0")
    playerSilver = 10
    playerGold = 10
    placeOrder("shandy,Dragon's Breath,11.1")
} //9-17 задание(обработка отрицательного баланса)

private fun performPurchase(price: Double): Boolean {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    if (totalPurse >= price) {
        val remainingBalance = totalPurse - price
        println("Remaining balance: ${"%.2f".format(remainingBalance)}")

        val remainingGold = remainingBalance.toInt()
        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
        playerGold = remainingGold
        playerSilver = remainingSilver
        displayBalance()
        return true
    } else {
        return false
    }
}// условие для задания(обработка отрицательного баланса)

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
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