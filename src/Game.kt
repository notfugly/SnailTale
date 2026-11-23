/**
 * Главный класс игры
 */
class Game {
    val player = PlayerState()
    val history = mutableListOf<DayRecord>()

    /**
     * Запуск игры, пролог и эпилог
     */
    fun Run() {
        println("Вы просыпаетесь рано утром и вспоминаете, что поступили в вуз своей мечты - МИРЭА. Ваш сосед по\n" +
                "комнате опять играет в странные игры и издает не менее странные звуки, от чего вы испытываете\n" +
                "отвращение. Вы словно получаете невидимую пощечину, которая говорит вам о том, что пора вставать\n" +
                "на пары. С этими мыслями вы начинаете свой день...")

        for (i in 1..7) {
            PlayDay(i)
        }

        val ending = Ending(player)
        ending.printEnding(player)
        ending.printStatistics(player)
    }

    /**
     * Функция запуска дня
     * @param i Текущий день
     */
    fun PlayDay(i: Int): Boolean {
        val event: GameEvent = when (i) {
            1 -> Event1
            2 -> Event2
            3 -> Event3
//            4 -> Event4
//            5 -> Event5
//            6 -> Event6
//            7 -> Event7
            else -> GameEvent(
                title = "TODO()",
                description = "TODO()",
                startNode = GameEvent.DialogueNode(
                    text = "TODO()",
                    choices = emptyList()
                )
            )
        }
        val curDay = Day(i, event)

        val startState = PlayerStateSnapshot.from(player)
        val completed = curDay.play(player)
        val endState = PlayerStateSnapshot.from(player)

        val record = DayRecord(curDay, startState, endState)
        history.add(record)
        record.logResults()
        return completed
    }
}
