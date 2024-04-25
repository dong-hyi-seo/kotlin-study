package inflearn

/**
 * 강의 6. 코틀린에서 반복문을 다루는 방법
 * 1. for-each 문 (향상된 for문)
 * 2. 전통적인 for
 * 3. Progression과 Range
 * 4. While 문
 */
fun main() {

    println(" ========== for ========= ")
    //숫자가 들어 있는 리스트를 하나씩 출력하는 예제
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println("number : $number")
    }

    //전통적인 for문 kotlin 방법
    for (i in 1..3) {
        println("i : $i")
    }
    //위 코드를 역순일경우 ?
    for (i in 3 downTo 1) {
        println("downTo i : $i")
    }

    //2카씩 올라가는경우?
    //1부터 5까지 등차수열을 생성하고, 2공차에 값을 뽑아서 출력
    for (i in 1..5 step 2) {
        println("step 2 : $i")
    }

    /**
     * .. <- 범위
     * IntRange ---> Progression (등차수열)
     * downTo, step 등은 중위함수임
     */


    /**
     * While은 자바와 같음
     */
}