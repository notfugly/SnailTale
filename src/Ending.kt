class Ending(
    val playerState: PlayerState
) {
    fun finalEnding(playerState: PlayerState) {

    }

    fun printEnding(playerState: PlayerState) {
        if (playerState.readiness >= 100) {
            println("Ураа! Снимай штаны")
        } else {
            println("Ты медик. Я тебя ненавижу")
        }
    }

    fun printStatistics(playerState: PlayerState) {
        playerState.printFinalStatistics(playerState)
    }

}