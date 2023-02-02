package `2장`

/**
 * @author donghyi.seo
 * @since 2023.02.02
 * 1. 함수를 최상위 수준에 정의 가능
 * 2. 세미클론을 붙이지 않아도됨
 */
fun main(args: Array<String>) {

    println("Kotlin in action 2장 시작") //java -> System.out.println();

    println(max(5, 3)) // max 값 뽑는 함수
    println(simpleMax(5, 3)) //위 max 함수를 더 간결하게
    println(simpleMax2(5, 3)) //위 max 함수를 더 간결하게
}

// max 값 뽑는 함수
fun max(a: Int,b: Int) : Int {
    return if (a > b) a else b;
}
//위 max 함수를 더 간결하게
//return 을 '=' 해당 부등호로 대체 가능
fun simpleMax(a:Int, b:Int) : Int = if (a > b) a else b

//위 simpleMax 함수를 더 간단하게 할수있다 ?!!!
//반환타입 생략 -> 컴파일러가 함수 본문 식을 분석하여 알아서 지정해준다 .
fun simpleMax2(a:Int, b:Int) = if (a > b) a else b
class base {

}