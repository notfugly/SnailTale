/**
 * Метрики игрока
 *
 * Менять можно через [changeResources]
 * @property attitudeToPlayer Отношение к игроку
 * @property budget Бюджет игрока
 * @property energy Энергия игрока
 * @property readiness Готовность игрока
 */
class PlayerState {
    /** Диапазон: 0..100 */
    var attitudeToPlayer: Int = 0
        private set
    /** Диапазон: 100..0 */
    var budget: Int = 100
        private set
    /** Диапазон: 10..0 */
    var energy: Int = 10
        private set
    /** Диапазон: 0..100 */
    var readiness: Int = 0
        private set

    /**
     * Сеттер величин
     *
     * Положительное значение параметра увеличивает соответствующий показатель,
     * отрицательное — уменьшает. Например, [budgetChange] меняет
     * [PlayerState.budget].
     * @param attitudeToPlayerChange Изменение [attitudeToPlayer]
     * @param budgetChange Изменение [budget]
     * @param energyChange Изменение [energy]
     * @param readinessChange Изменение [readiness]
     */
    fun changeResources(
        attitudeToPlayerChange: Int = 0,
        budgetChange: Int = 0,
        energyChange: Int = 0,
        readinessChange: Int = 0
    ) {
        attitudeToPlayer += attitudeToPlayerChange
        budget += budgetChange
        energy += energyChange
        readiness += readinessChange
    }

    /**
     * Вывод итоговой статистики
     * @param playerState Состояние игрока
     */
    fun printFinalStatistics(playerState: PlayerState) {
        println("\n-- Итоговые ресурсы --")
        println("Энергия: $energy")
        println("Бюджет: $budget")
        println("Готовность: $readiness")
        println("Отношения к игроку: $attitudeToPlayer\n")
    }
}