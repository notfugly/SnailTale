import GameEvent.DialogueChoice
import GameEvent.DialogueNode

val Event1: GameEvent = GameEvent(
    title = "Встреча",
    description = "У выхода из университета вы замечаете девушку, которая смотрит на падающие жёлтые листья.",
    startNode = DialogueNode(
        text = "Она выглядит задумчивой. Что вы сделаете?",
        choices = listOf(
            DialogueChoice(
                text = "Спросить, всё ли в порядке",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 5,
                        budgetChange = 0,
                        energyChange = -1,
                        readinessChange = 0
                    )
                },
                next = DialogueNode(
                    text = "Она улыбается: «Спасибо, что выслушал». Вы знакомитесь.",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Подарить цветы (10 бюджета)",
                condition = { player -> player.budget >= 10 },
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 10,
                        budgetChange = -10,
                        energyChange = 0,
                        readinessChange = 0
                    )
                },
                next = DialogueNode(
                    text = "Она с удивлением принимает цветы, благодарит вас и представляется.",
                    choices = emptyList()
                )
            ),
            DialogueChoice(text = "Пройти мимо")
        )
    )
)

val Event2: GameEvent = GameEvent(
    title = "Встреча в магазине человеческих черепов",
    description = """
        Ты видишь ее, рассматривающей череп твоей матери, твои действия?
    """.trimIndent(),
    startNode = DialogueNode(
        text = "Выборы в единой россии",
        choices = listOf(
            DialogueChoice(
                text = """Харкнуть ей в рот (с кровью) (с ухмылкой)
                    |*Вы чувствуете решимость*
                """.trimMargin(),
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 5
                    )
                },
                next = DialogueNode(
                    text = "Ей понравилось",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Купить куни (5 денег)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -10
                    )
                },
                next = DialogueNode(
                    text = "Пошел нахуй уёбок гриб декоративный пидорас корзинка трахать сперма пирожки",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Принять эмоцию \"дурак\"",
                effect = { player -> },
                next = DialogueNode(
                    text = "Вы чувствуете, что хорошо отдохнули",
                    choices = emptyList()
                )
            )
        )
    )
)

val Event3: GameEvent = GameEvent(
    title = "Сегодня день святого валинтина)) полный интим))",
    description = """
        Вы замечаете ее под солями, ваши действия?
    """.trimIndent(),
    startNode = DialogueNode(
        text = "ААААА",
        choices = listOf(
            DialogueChoice(
                text = "Дать в рот",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 5,
                    )
                },
                next = DialogueNode(
                    text = "Ей понравилось",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Купить ей мороженое",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 1,
                    )
                },
                next = DialogueNode(
                    text = "Ее зубы выпали от переохлаждения",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Пройти мимо",

            )
        )
    ),
)
val Event4: GameEvent = GameEvent(
    title = "Сегодня концерт '3 дня вождя'",
    description ="""
        Вы хотите послушать самые лучшие треки, ваши действия?
    """.trimIndent(),
    startNode = DialogueNode(
        text = "На какой трек пойдем?",
        choices = listOf(
            DialogueChoice(
                text = "Отсосать(slowed-reverb)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 3,
                        energyChange = 1
                    )
                },
                next = DialogueNode(
                    text = "Слезы от счастья текут по щекам,как жидкое пламя его по устам",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Отсосать",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 2,
                    )
                },
                next = DialogueNode(
                    text = "банально,но нормально",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Отсосать(Speed-up)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 1,
                    )
                },
                next = DialogueNode(
                    text = "херня,но 3 дня дождя всё равно топ",
                    choices = emptyList()
                )
            )
        )
    ),
)