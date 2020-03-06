fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    //Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal, karma)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    //Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    println("Карма = $karma")
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean,
                      healthPoints: Int,
                      isImmortal: Boolean,
                      karma: Int): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            in 16..20 -> "green"
            else -> "NONE"
        }
    } else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition"
    }