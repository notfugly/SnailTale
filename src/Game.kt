import Events.*
import kotlin.collections.emptyList

class Game {
    val player = PlayerState()
    val history = mutableListOf<DayRecord>()

    fun Run() {
        println("Вы просыпаетесь рано утром и вспоминаете, что поступили в вуз своей мечты - МИРЭА. Ваш сосед по\n" +
                "комнате опять играет в странные игры и издает не менее странные звуки, от чего вы испытываете\n" +
                "отвращение. Вы словно получаете невидимую пощечину, которая говорит вам о том, что пора вставать\n" +
                "на пары. С этими мыслями вы начинаете свой день...")
        for (i in 1..7) {
            PlayDay(i)
        }
    }

    fun PlayDay(i: Int): Boolean {
        val events: List<GameEvent> = when (i) {
            1 -> emptyList()
            // ...
            else -> emptyList()
        }
        val curDay = Day(i, events)

        val startState = PlayerStateSnapshot.from(player)
        val completed = curDay.play(player)
        val endState = PlayerStateSnapshot.from(player)

        val record = DayRecord(curDay, startState, endState)
        history.add(record)
        record.logResults()
        return completed
    }
}
