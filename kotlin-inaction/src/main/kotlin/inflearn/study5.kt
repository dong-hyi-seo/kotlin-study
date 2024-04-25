package inflearn

/**
 * 5강
 * 1. if문
 * 2. Expression 과 Statement
 * 3. switch & when
 */
fun main() {
    //judgeNumber2(null);
}

/**
 * void 생략 및 new 생략
 */
fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}느 0보다 작을 수 없다.")
    }

    //0 과 100사이에 없는 경우 ?!
    if (score !in 0..100) {

    }

    //0과 100사이에 있는경우!!
    if (score in 0..100) {

    }
}

/**
 * kotlin에서 if else 는?
 * Statement : 프로그램의 문장 하나의 값으로 도출되지 않는다.
 * Expression: 하나의 값으로 도출되는 문장
 *
 * java에서는 if 문을 하나의 값으로 취급하지 않고, 이를 대응하려면 삼항연산자로 쓴다. (Expression)
 * 그러면 Kotlint 은?
 *
 */
fun getPassOrFail(score: Int): String {
    //java & kotlin 방식
    /*if (score >= 50) {
        return "P"
    } else {
        return "F"
    }*/

    //kotlin에서는 if문을 expression으로 보기때문에 아래와 같이가능하고, 다만 3항연산자는 안됨
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int) : String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

/**
 * switch && when
 * when 도 하나의 expression이기 때문에 return을 바로 할 수 있음.
 * when은 enum, sealed class와 같이활용하면 더욱 진가를 발휘한다.
 */
fun getGradeWithSwitch(score: Int) : String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwitch2(score: Int) :String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("a")
        else -> false
    }
}

fun judgeNumber(number: Int): Unit {
    when (number) {
        1, 0 -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0 , -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int?) {
    if (number != null) {
        when {
            number == 0 -> println("주어진 숫자는 0 입니다")
            number % 2 == 0 -> println("주어진 숫자는 짝수 !")
            else -> println("주어지는 숫자는 홀수")
        }
    }
}