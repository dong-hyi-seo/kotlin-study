package inflearn

/**
 * 강의11. 코틀린에서 접근 제어를 다루는 방법
 * 1. 자바와 코틀린의 가시성 제어
 * 2. 코틀린 파일의 접근 제어
 * 3. 다양한 구성요소의 접근 제어
 * 4. Java와 Kotlin을 함께 사용할 경우 주의할 점
 *
 * Internal은 바이트코드상 public이 된다 (Java와 사용할경우!!) 주의 !!
 */
fun main() {

    /**
     * java   -> kotlin
     * public -> 모든 곳에서 접근 가능
     *
     * protected (같은패키지 또는 하위클래스접근) -> 선언된 클래스 또는 하위클래스에서만 접근가능 (kotlin에서는 패키지를 namespace를 관리하기 위한 용도)
     * - 파일 최상단에서는 사용 불가능
     * default -> internal (같은 모듈에서만 접근가능) - 다른 모듈 = 다른프로젝트
     * private -> 동일
     *
     */

    //util 성 함수는 kotlin 파일 생성하여 최상단에 생성하면 편함 (compile시에 java static으로 생성 )
    val isD = isDirectoryPath("/test")
    println(isD);
}

val g = 3

fun add(a: Int, b: Int): Int {
 return a + b
}

class Cat1 private constructor(

) {

}

/**
 * 생성자 변수에 internal 을 주면 name 에
 * owner getter, setter에 Private을 주고싶을경우 생성자에 붙인다
 *
 * _price에 setter에만 private을 주겠다?
 */
class Car(
    internal val name : String,
    private var owner : String,
    _price: Int
) {
    var price = _price
        private set
}
