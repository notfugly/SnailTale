val friendlyEnding = DialogueNode(
    text = "Она улыбается: «Спасибо, что выслушал».",
    choices = emptyList()
)

val giftEnding = DialogueNode(
    text = "Она принимает подарок с удивлением и благодарностью.",
    choices = emptyList()
)

val firstMeeting = ConditionalEvent(
    title = "Встреча",
    description = "Вы замечаете её в саду.",
    startNode = DialogueNode(
        text = "Она выглядит задумчивой. Что вы сделаете?",
        choices = listOf(
            DialogueChoice(
                text = "Спросить, всё ли в порядке",
                effect = { player ->
                    player.changeResources(5, 0, -1, 0)
                },
                next = friendlyEnding
            ),
            DialogueChoice(
                text = "Подарить цветы (10 бюджета)",
                condition = { player -> player.budget >= 10 },
                effect = { player ->
                    player.changeResources(10, -10, 0, 0)
                },
                next = giftEnding
            ),
            DialogueChoice(
                text = "Пройти мимо"
                // next = null, поэтому диалог завершится.
            )
        )
    )
)

