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
    var attitudeToPlayer: Int = 0 // 0..100
        private set
    var budget: Int = 100 // 100..0
        private set
    var energy: Int = 10 // 10..0
        private set
    var readiness: Int = 0 // 0..100
        private set

    /**
     * Сеттер ресурсов
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
}