import kotlin.random.Random

class Day(
    val numberOfDay: Int,
    val event: GameEvent,
    private val random: Random = Random.Default
) {
    /**
     * Запуск дня
     * @param player Состояние игрока
     */
    fun play(player: PlayerState): Boolean {
        event.startEvent(player)
        return true
    }

}