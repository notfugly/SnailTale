import kotlin.random.Random

class Day(
    val numberOfDay: Int,
    val events: List<GameEvent>,
    private val random: Random = Random.Default
) {
    /**
     * Запуск дня
     * @param playerState Состояние игрока
     */
    fun play(playerState: PlayerState): Boolean {
        val mainEvent = events[0]
        val otherEvents = events.subList(1, events.size)

        val beforeSnapshot = PlayerStateSnapshot.from(playerState)
        mainEvent.startEvent(playerState)
        val afterSnapshot = PlayerStateSnapshot.from(playerState)

        val record = afterSnapshot - beforeSnapshot

        /** Проверка на один из трёх выборов */
        if (!((record.energyChange < 0 && record.budgetChange == 0 && record.readinessChange > 0) ||
            (record.energyChange == 0 && record.budgetChange < 0 && record.readinessChange > 0) ||
            (record.energyChange > 0 && record.budgetChange == 0 && record.readinessChange == 0))
        ) {
            throw Exception("Не был сделан один из трёх основных выборов")
        }

        for (event in otherEvents) {
            event.startEvent(playerState)
        }

        return true
    }

}