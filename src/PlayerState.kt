class PlayerState {
    var attitudeToPlayer: Int = 0 // 0..100
        private set
    var budget: Int = 100 // 100..0
        private set
    var energy: Int = 10 // 10..0
        private set
    var readiness: Int = 0 // 0..100
        private set

    fun changeResources(
        attitudeToPlayerChange: Int,
        budgetChange: Int,
        energyChange: Int,
        readinessChange: Int
    ) {
        attitudeToPlayer += attitudeToPlayerChange
        budget += budgetChange
        energy += energyChange
        readiness += readinessChange
    }
}