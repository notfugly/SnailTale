//// Метод класса GameEvent
//protected open fun resolveChange(state: PlayerStateSnapshot): PlayerStateChange? = null
//
//// Внутри startEvent, перед циклом диалога
//resolveChange(PlayerStateSnapshot.from(player))?.let { change ->
//    player.changeResources(
//        attitudeToPlayerChange = change.attitudeChange,
//        budgetChange = change.budgetChange,
//        energyChange = change.energyChange,
//        readinessChange = change.readinessChange
//    )
//}

//class FixedGameEvent(
//    title: String,
//    description: String,
//    private val change: PlayerStateChange
//) : GameEvent(title, description) {
//    override fun resolveChange(state: PlayerStateSnapshot): PlayerStateChange = change
//}
//
//class ConditionalGameEvent(
//    title: String,
//    description: String,
//    private val condition: (PlayerStateSnapshot) -> Boolean,
//    private val ifTrue: PlayerStateChange,
//    private val ifFalse: PlayerStateChange? = null
//) : GameEvent(title, description) {
//    override fun resolveChange(state: PlayerStateSnapshot): PlayerStateChange? {
//        return if (condition(state)) ifTrue else ifFalse
//    }
//}