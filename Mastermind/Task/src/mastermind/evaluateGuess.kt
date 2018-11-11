package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var numRightPosition = 0
    var numWrongPosition = 0
    var modSec = ""
    var modGue = ""
    for ((idx, ch) in secret.withIndex()){
        if(ch == guess[idx]) {
            numRightPosition++
        }else{
            modSec += ch
            modGue += guess[idx]
        }
    }

    println("secret -> " + secret + " " + modSec)
    println("guess -> " + guess + " " + modGue)


    for(i in 0 until modGue.length){
        val gueCh = modGue[i]
        var match = false
        for(secCh in modSec){
            if(gueCh == secCh)
                match = true
        }
        if(match)
            numWrongPosition++
    }

    return Evaluation(numRightPosition, numWrongPosition)
}



