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
    title = "Встреча в столовой вуза",
    description = """
        Взяв самый лучший борщ на свете ты замечаешь свою новую знакомую: она отчаянно пытается найти свободный столик
    """.trimIndent(),
    startNode = DialogueNode(
        text = "ты сидишь за столом один,что будешь делать?",
        choices = listOf(
            DialogueChoice(
                text = """предложить ей сесть рядом и пообедать вместе
                """.trimMargin(),
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 5
                    )
                },
                next = DialogueNode(
                    text = "она поблагодарила вас и села рядом",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "быстро доесть борщ и предложить ей свободный стол",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 1
                    )
                },
                next = DialogueNode(
                    text = "ей показалось странным то,как вы быстро съели суп,но она поблагодарила вас за свободное место",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "поставить ноутбук на стол и сделать вид что ты ее не видишь",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -3
                    )
                },
                next = DialogueNode(
                    text = "она заметила вас, но так как вы заняли весь стол- ей пришлось сесть к другим студентам",
                    choices = emptyList()
                )
            )
        )
    )
)

val Event3: GameEvent = GameEvent(
    title = "День открытых профессий(надо вспомнить название)",
    description = """
        Стоя возле стенда компании 'Смак Овечки' вы слышите ее голос:
    """.trimIndent(),
    startNode = DialogueNode(
        text = "«у них довольно вкусные булочки»",
        choices = listOf(
            DialogueChoice(
                text = "сказать:«Да,особенно шоколадные»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 5,
                    )
                },
                next = DialogueNode(
                    text = "«Даааа,обожаю их»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "сказать:«не пробовал,сходим потом вместе попробовать?»(2 бюджета)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 3,
                         budgetChange = -2,
                        energyChange = 2
                    )
                },
                next = DialogueNode(
                    text = "«ооо,давай,я согласна»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "сказать:«Нет,они вообще ужасные и я тут за профессией,а не булками»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -10,
                    )
                },
                next = DialogueNode(
                    text = "«не обязательно быть мудаком..»-слышите вы ее шепот уходя" +
                            "    «вроде сама знаешь что обязательно»- пронеслось у вас в голове",
                    choices = emptyList()
                )
            )
        )
    ),
)
val Event4: GameEvent = GameEvent(
    title = "Сегодня концерт '3 дня вождя'",
    description ="""
        Вам пишет та самая знакомая:
    """.trimIndent(),
    startNode = DialogueNode(
        text = "Привет,не хочешь сегодня сходить на концерт '3 дня вождя':)?",
        choices = listOf(
            DialogueChoice(
                text = "написать: «Давай,обожаю их треки)»(3 бюджета)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 6,
                        budgetChange = -3,
                    )
                },
                next = DialogueNode(
                    text = "это был лучший концерт в вашей жизни",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Написать:«Насчет концерта не знаю,может сходим на пробежку?»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 2,
                        energyChange = -4
                    )
                },
                next = DialogueNode(
                    text = "«Давай,тогда в 18:00 у парка»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Написать:«Не,я занят»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -2,
                    )
                },
                next = DialogueNode(
                    text = "«Печально,тогда пока:(»",
                    choices = emptyList()
                )
            )
        )
    ),
)
val Event5: GameEvent = GameEvent(
    title = "обычный учебный день",
    description = """
        даже на фестивале бывают спокойные минуты,так и тут тихий день,когда мало людей и ничего не происходит кроме того, что вы снова встретили ее:
        """.trimIndent(),
    startNode = DialogueNode(
        text = "«привет у нас скоро кр будет по иностранному языку,не хочешь сегодня вместе позаниматься?»",
        choices = listOf(
            DialogueChoice(
                text = "Сказать:«Да,давай мне как раз нужна практика»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 5,
                        energyChange = -2
                    )
                },
                next = DialogueNode(
                    text = "«отлично тогда созвонимся сегодня вечером»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Сказать:«Not today bb»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 1,
                    )
                },
                next = DialogueNode(
                    text = "«хах,окей,тогда до встречи:)»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Сказать:«у вас кр скоро,у нас нет,поэтому сама разбирайся»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -10,
                    )
                },
                next = DialogueNode(
                    text = "«Ох...прости тогда что отвлекла тебя...»" +
                    "   уходя на пару по пустому коридору вы слышите как кто-то сзади начал тихо плакать",
                    choices = emptyList()
                )
            )
        )
    ),
)
val Event6: GameEvent = GameEvent(
    title = "экскурсия в Тверь",
    description = """
        сегодня ты поехал на экскурсию от вуза, идя со своей группой по холодной улице среди неизвестных лиц ты видишь ее:
    """.trimIndent(),
    startNode = DialogueNode(
        text = "«Ты тоже здесь! Может вместе будем идти? Так веселей и теплей»",
        choices = listOf(
            DialogueChoice(
                text = "Предложить ей купить кофе(2 бюджета)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 2,
                        budgetChange = -2
                    )
                },
                next = DialogueNode(
                    text = "«спасибо большое! это очень приятно в такой холод получить теплую поддержку)»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "Предложить ей свою шапку(3 энергии)",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 3,
                        energyChange = -3
                    )
                },
                next = DialogueNode(
                    text = "«Спасибо большое,это очень мило с твоей стороны) Главное сам не замерзни:)»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "отказаться ходить вместе:«мне и так весело и тепло,ведь оделся я нормально»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -3,
                    )
                },
                next = DialogueNode(
                    text = "«ну ладно(»",
                    choices = emptyList()
                )
            )
        )
    ),
)
val Event7: GameEvent = GameEvent(
    title = "День всех влюбленных",
    description = """
        многие обожают этот день- это их шанс стать счастливее вместе, а некоторые ненавидят- сегодня они особенно одиноки 
    """.trimIndent(),
    startNode = DialogueNode(
        text = "после вуза вы встречаете ее:«слушай,я давно хотела это сделать,но сегодня лучший день для этого- пойдем на свидание?»",
        choices = listOf(
            DialogueChoice(
                text = "«Я хотел предложить тебе то же самое! пойдем) дома напишу в какой ресторан поедем вечером)»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = 33,
                        energyChange = 3,
                        budgetChange = -20
                    )
                },
                next = DialogueNode(
                    text = "«УРАААА», она обнимает вас, «тогда до вечера;)» ",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "«Ох ты,мне очень приятно,но давай лучше останемся знакомыми...»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -10,
                    )
                },
                next = DialogueNode(
                    text = "«Оу... ну хорошо..»",
                    choices = emptyList()
                )
            ),
            DialogueChoice(
                text = "«С тобой? Фу, ты не стоишь и капли моего внимания,меня раздражают твои глаза,твой голос и ты в принципе,если бы был выбор между тобой и тем,чтобы запереться на год в башне,то я явно бы не выбрал тебя»",
                effect = { player ->
                    player.changeResources(
                        attitudeToPlayerChange = -100,
                    )
                },
                next = DialogueNode(
                    text = "«Прости...»",
                    choices = emptyList()
                )
            )
        )
    ),
)