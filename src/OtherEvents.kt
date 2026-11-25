import GameEvent.DialogueNode

const val budgetChangeFromTransferFromParents = 2

val TransferFromParents = FixedGameEvent(
    title = "ДЕНЬГИ!",
    description = "Сегодня вам пришло новое сообщение от родителей...\n" +
            "+$budgetChangeFromTransferFromParents бюджета",
    startNode = DialogueNode(
        text = "TODO()",
        choices = emptyList(),
        onEnter = {
            playerState -> playerState.changeResources(
                budgetChange = budgetChangeFromTransferFromParents
            )
        }
    ),
    chance = 50,
    onDay = listOf(2, 5)
)