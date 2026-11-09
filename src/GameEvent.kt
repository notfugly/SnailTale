/**
 * Класс события в игре
 */
class GameEvent(
    val title: String,
    val description: String,
    private val startNode: DialogueNode
    ) {

    /**
     * Единичный выбор
     *
     * @property text Текст выбора
     * @property condition Условие для выбора
     * @property effect Эффект для игрока
     * @property next Следующий узел в диалоге
     */
    class DialogueChoice(
        val text: String = "ExampleTitle",
        val condition: (PlayerState) -> Boolean = { true },
        val effect: (PlayerState) -> Unit = {},
        val next: DialogueNode? = null
    )

    /**
     * Узел дерева выборов
     *
     * @property text Текст выбора
     * @property choices Варианты выбора
     */
    class DialogueNode(
        val text: String,
        val choices: List<DialogueChoice>
    )

    /**
     * Старт ивента
     */
    fun startEvent(player: PlayerState) {
        println(title)
        println(description)

        var currentNode: DialogueNode? = startNode

        while (currentNode != null) {
            val node = currentNode
            println("\n${node.text}")

            val availableChoices = node.choices.filter { it.condition(player) }

            // Узел без доступных ответов завершает диалог
            if (availableChoices.isEmpty()) break

            availableChoices.forEachIndexed { index, choice ->
                println("${index + 1}. ${choice.text}")
            }

            var choice: DialogueChoice

            while (true) {
                print("Ваш выбор: ")
                val input = readlnOrNull() ?: return
                val index = input.toIntOrNull()?.minus(1)

                if (index != null && index in availableChoices.indices) {
                    choice = availableChoices[index]
                    break
                }

                println("Введите номер доступного ответа.")
            }

            choice.effect(player)
            currentNode = choice.next
        }
    }
}
