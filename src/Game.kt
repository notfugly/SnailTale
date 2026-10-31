import Events.firstMeeting

class Game {
    val player = PlayerState()
    val history = mutableListOf<DayRecord>()

    fun Run() {
        // Вывод пролога
        for (i in 1..7) {
            if (!PlayDay(i)) break
        }
        // Вывод эпилога, результатов и статов
    }

    fun PlayDay(i: Int): Boolean {
        val events = if (i == 1) dayOneEvents else emptyList()
        val curDay = Day(i, events)
        val startState = PlayerStateSnapshot.from(player)
        if (i == 1) {
            firstMeeting.apply(player)
        }
        val completed = curDay.play(player)
        val endState = PlayerStateSnapshot.from(player)
        val record = DayRecord(curDay, startState, endState)
        history.add(record)
        record.logResults()
        return completed
    }

}
