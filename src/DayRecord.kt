data class PlayerStateSnapshot(
    val attitudeToPlayer: Int,
    val budget: Int,
    val energy: Int,
    val readiness: Int
) {
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

class DayRecord(
    val curDay: Day,
    val startOfDayPlayerState: PlayerStateSnapshot,
    val endOfDayPlayerState: PlayerStateSnapshot
) {
    val attitudeChange: Int
        get() = endOfDayPlayerState.attitudeToPlayer -
                startOfDayPlayerState.attitudeToPlayer

    val budgetChange: Int
        get() = endOfDayPlayerState.budget -
                startOfDayPlayerState.budget

    val energyChange: Int
        get() = endOfDayPlayerState.energy -
                startOfDayPlayerState.energy

    val readinessChange: Int
        get() = endOfDayPlayerState.readiness -
                startOfDayPlayerState.readiness

    fun logResults() {
        fun formatChange(change: Int): String = if (change > 0) "+$change" else change.toString()

        println("\n--- Итоги дня ${curDay.numberOfDay} ---")
        println("Отношения: ${startOfDayPlayerState.attitudeToPlayer} → ${endOfDayPlayerState.attitudeToPlayer} (${formatChange(attitudeChange)})")
        println("Бюджет: ${startOfDayPlayerState.budget} → ${endOfDayPlayerState.budget} (${formatChange(budgetChange)})")
        println("Энергия: ${startOfDayPlayerState.energy} → ${endOfDayPlayerState.energy} (${formatChange(energyChange)})")
        println("Готовность: ${startOfDayPlayerState.readiness} → ${endOfDayPlayerState.readiness} (${formatChange(readinessChange)})")
    }
}
