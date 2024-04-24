package inflearn

import JavaMoney

/**
 * 강의 4
 * 1. 단항 연산자/ 산술 연산자
 * 2. 비교 연산자와 동등성, 동일성
 * 3. 논리 연산자 / 코틀린에 있는 특이한 연산자
 * 4. 연산자 오버로딩
 */
fun main() {

    //단항연산자 ++ ,--
    //산술연산자 +, -, * 등등 자바와 동일
    val money1 = JavaMoney(2000L);
    val money2 = JavaMoney(1000L);

    //코틀린에서 비교연산자는 해당 JavaMoney compareTo를 자동으로 수행시킨다!
    if (money1 > money2) {
        println("Money1이 Money2보다 금액이 크다");
    }

    /**
     * 동등성(Equality) : 두 객체의 값이 같은가?!
     * 동일성(Identity) : 완전히 동일한 객체인가? 즉 주소가 같은가?!!
     *
     * Java에서는
     * 동일성은 ==
     * 동등성은 object의 equals 사용
     *
     * Kotlin에서는?
     * 동일성은 ===
     * 동등성은 ==를 호출
     */
    val money3 = JavaMoney(1_000L);
    val money4 = money3;
    val money5 = JavaMoney(1_000L);

    println("동일성 체크 money3 === money4 ----> ${money3 === money4}")
    println("동등성 체크 money4 == money5 ----> ${money3 == money5}")

    /**
     * lazy 연산자
     * 또는에서는 fun1이 무조건 true이기 때문에 fun2함수수행까지 가지않음
     */
    if (fun1() || fun2()) {
        println("본문")
    }

    /**
     * in / !in
     * - 컬렉션이나 범위에 포함되어있다, 포함되어있지 않다!!
     *
     * a..b
     * - a부터 b까지의 범위 객체를 생성한다.!(반목문)
     */

    /**
     * 연산자 오버로딩
     * kotlin에서는 객체마다 연산자를 직접 정의 가능
     * java : money1.plus(money2)
     * 하지만 코틀린에서는?
     */
    val kotlinMoney1 = Money(1_000L)
    val kotlinMoney2 = Money(2_000L)
    println("java 방식 ${kotlinMoney1.plus(kotlinMoney2)}")
    println("다른 방식 ${kotlinMoney1 + kotlinMoney2}")


}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}