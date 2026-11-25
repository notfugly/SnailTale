/**
 * Объект записывающий метрики игрока
 * @param attitudeToPlayer Отношение к игроку
 * @param budget Бюджет игрока
 * @param energy Энергия игрока
 * @param readiness Готовность игрока
 */
data class PlayerStateSnapshot(
    val attitudeToPlayer: Int,
    val budget: Int,
    val energy: Int,
    val readiness: Int
) {
    data class PlayerStateChange(
        val attitudeChange: Int,
        val budgetChange: Int,
        val energyChange: Int,
        val readinessChange: Int
    )

    operator fun minus(other: PlayerStateSnapshot): PlayerStateChange {
        return PlayerStateChange(
            attitudeChange = attitudeToPlayer - other.attitudeToPlayer,
            budgetChange = budget - other.budget,
            energyChange = energy - other.energy,
            readinessChange = readiness - other.readiness
        )
    }

    companion object {
        fun from(player: PlayerState): PlayerStateSnapshot {
            return PlayerStateSnapshot(
                attitudeToPlayer = player.attitudeToPlayer,
                budget = player.budget,
                energy = player.energy,
                readiness = player.readiness
            )
        }
    }
}