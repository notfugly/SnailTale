import kotlin.random.Random

class Day(
    val numberOfDay: Int,
    val events: List<GameEvent>,
    private val random: Random = Random.Default
) {
    private enum class Action(
        val number: Int,
        val description: String
    ) {
        SPEND_TIME(1, "Провести время с героиней: -2 энергии, +5 отношений, +15 готовности"),
        BUY_GIFT(2, "Купить подарок: -10 бюджета, +10 отношений, +15 готовности"),
        REST(3, "Отдохнуть: +3 энергии")
    }

    /**
     * Проводит день.
     * Возвращает false, если ввод был завершён до выбора действия.
     */
    fun play(player: PlayerState): Boolean {
        println("\nДень $numberOfDay")
        receiveMoney(player)

        val choices = mutableListOf<Action>()

        repeat(3) { index ->
            println("\nМини-выбор ${index + 1} из 3")

            // На третьем шаге доступны только варианты,
            // выбранные на первом или втором шаге.
            val candidates = if (index == 2) {
                choices.distinct()
            } else {
                Action.entries.toList()
            }

            val available = candidates.filter { isAvailable(it, player) }

            // Обработка случая, когда в первых двух выборах не было
            // отдыха, а выбранные действия оказались недоступны.
            if (available.isEmpty()) {
                println("Нет доступных действий.")
                return false
            }

            val choice = readChoice(available) ?: return false
            choices.add(choice)
        }

        // Третий выбор повторяет один из первых двух, поэтому
        // у одного действия обязательно будет большинство.
        val finalAction = choices.groupingBy { it }
            .eachCount()
            .maxBy { it.value }
            .key

        println("\nОсновное действие: ${finalAction.description}")
        applyAction(finalAction, player)

        val event = events.randomOrNull(random)
        if (event != null) {
            println("\nСобытие дня:")
            event.apply(player)
        }

        return true
    }

    private fun isAvailable(action: Action, player: PlayerState): Boolean {
        return when (action) {
            Action.SPEND_TIME -> player.energy >= 2
            Action.BUY_GIFT -> player.budget >= 10
            Action.REST -> true
        }
    }

    private fun readChoice(available: List<Action>): Action? {
        available.forEach { action ->
            println("${action.number}. ${action.description}")
        }

        while (true) {
            print("Ваш выбор: ")
            val input = readlnOrNull() ?: return null
            val number = input.toIntOrNull()

            val selected = available.find { it.number == number }
            if (selected != null) {
                return selected
            }

            println("Введите номер доступного действия.")
        }
    }

    private fun applyAction(action: Action, player: PlayerState) {
        when (action) {
            Action.SPEND_TIME -> player.changeResources(
                attitudeToPlayerChange = 5,
                budgetChange = 0,
                energyChange = -2,
                readinessChange = 15
            )

            Action.BUY_GIFT -> player.changeResources(
                attitudeToPlayerChange = 10,
                budgetChange = -10,
                energyChange = 0,
                readinessChange = 15
            )

            Action.REST -> {
                // Не повышаем энергию выше начального максимума.
                val recoveredEnergy = (10 - player.energy).coerceIn(0, 3)

                player.changeResources(
                    attitudeToPlayerChange = 0,
                    budgetChange = 0,
                    energyChange = recoveredEnergy,
                    readinessChange = 0
                )
            }
        }
    }

    private fun receiveMoney(player: PlayerState) {
        val transferChance = 0.2
        val transferAmount = 20

        if (random.nextDouble() < transferChance) {
            println("Пришёл денежный перевод: +$transferAmount к бюджету.")
            player.changeResources(
                attitudeToPlayerChange = 0,
                budgetChange = transferAmount,
                energyChange = 0,
                readinessChange = 0
            )
        }
    }
}