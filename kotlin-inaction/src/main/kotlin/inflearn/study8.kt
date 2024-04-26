package inflearn

/**
 * 강의 8. 코틀린에서 함수를 다루는 방법
 * 1. 함수 선언 문법
 * 2. default parameter
 * 3. named argument (parameter)
 * 4. 같은 타입의 여러 파라미터 받기 (가변인자)
 */
fun main() {

    //두 정수를 받아 더 큰정수를 반환하는 예제
    val maxValue: Int = max(3, 5)
    println(maxValue)

    //default parameter -> java에서 여러 method를 만들어야하는 오버로딩이 하나의 method로 단순해진다.
    repeat("test", 3)
    repeat("test", 3, false)
    repeat("test", useNewLine = true)

    //만약 아래의 함수에 타입이 둘다 String일 경우, 서로 값이 뒤바뀐채 넣어줄 수도있다 실수로..
    //이 실수를 방지하려면 ? (named arguments) -> builder를 만들지는않지만 builder처럼 사용가능
    printNameAndGender("", "")
    printNameAndGender(gender = "MAN", name = "서동휘")

    //가변인자
    val array = arrayOf("A", "B", "C")
    printAll(*array) //kotlin에서는 가변인자에 해당하는 배열인자를 넣을경우 스프레드연산자를 앞에 붙여주어야한다.
}

// return type도 생략 가능 단, block {} 이것을 사용하는경우 반환 타입 지정해야함
fun max(a: Int, b: Int): Int = if (a > b) a else b

//만약 useNewLine이 항상 true인경우 대응하는 함수가 필요할경우 java에서는 오버로딩을한다. (즉 ,또하나의 method를 만들어야함 )
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

//가변인자 함수 Java -> ...string
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}

