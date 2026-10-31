abstract class GameEvent(
    val title: String,
    val description: String
    ) {
    abstract fun apply(player: PlayerState)
}


class DialogueNode(
    val text: String,
    val choices: List<DialogueChoice>
)

class DialogueChoice(
    val text: String,
    val condition: (PlayerState) -> Boolean = { true },
    val effect: (PlayerState) -> Unit = {},
    val next: DialogueNode? = null
)

class ConditionalEvent(
    title: String,
    description: String,
    private val startNode: DialogueNode
) : GameEvent(title, description) {

    override fun apply(player: PlayerState) {
        println(title)
        println(description)

        var currentNode: DialogueNode? = startNode

        while (currentNode != null) {
            val node = currentNode
            println("\n${node.text}")

            val availableChoices = node.choices.filter { it.condition(player) }

            // Узел без доступных ответов завершает диалог.
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


class FixedEvent(
    title: String,
    private val attitudeToPlayerChange: Int,
    private val budgetChange: Int,
    private val energyChange: Int,
    private val readinessChange: Int, description: String
) : GameEvent(title, description) {
    override fun apply(player: PlayerState) {
        println(title)
        println(description)
        player.changeResources(
            attitudeToPlayerChange,
            budgetChange,
            energyChange,
            readinessChange
        )
    }
}
