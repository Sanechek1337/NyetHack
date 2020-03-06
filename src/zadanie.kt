fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    //Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    val odurmanLevel = castFireball(25)
    println(odurmanLevel)
    val odurmanSost = when (odurmanLevel) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        in 41..50 -> "...t0aSt3d"
        else -> "Уровень одурманивания должен быть в пределах от 1 до 50"
    }
    println(odurmanSost)
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

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

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

private fun castFireball(numFireballs: Int = 2): Int {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    var odurmanLevel = numFireballs
    if (numFireballs > 50) odurmanLevel = 50
    if (numFireballs < 1) odurmanLevel = 1
    return odurmanLevel
}