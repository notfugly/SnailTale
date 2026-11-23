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

/**
 * Запись изменения метрик за день
 * @param curDay Текущий день
 * @param startOfDayPlayerState Снапшот игрока в начале дня
 * @param endOfDayPlayerState Снапшот игрока в конце дня
 */
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

    /**
     * Вывод текущей статистики
     */
    fun printPlayersInDayResources() {
        fun formatChange(change: Int): String = if (change > 0) "+$change" else change.toString()

        println("\n--- Итоги дня ${curDay.numberOfDay} ---")
        println("Бюджет: ${startOfDayPlayerState.budget} → ${endOfDayPlayerState.budget} (${formatChange(budgetChange)})")
        println("Энергия: ${startOfDayPlayerState.energy} → ${endOfDayPlayerState.energy} (${formatChange(energyChange)})")
        println("\n")
    }
}
