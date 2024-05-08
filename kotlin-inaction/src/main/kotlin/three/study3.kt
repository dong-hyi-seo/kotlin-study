package three

import inflearn.Car
import kotlin.text.StringBuilder

fun main(args: Array<String>) {

    collectionStudy()
    callEasyFunc()
    /**
     * 확장함수
     */
    val list = listOf(1, 2, 3);
    println(list.joinToStringExtendFunction(separator = "; ", prefix = "(", postfix = ")"))
    println("kotlin".lastChar);
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!';
    println("sb = ${sb.toString()}")

    /**
     * 3.4 컬렉션 처리
     */
    //3.4.1 자바컬렉션 API확장
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last()) //어떻게 자바 라이브러리 클래스의 인스턴스인 컬렉션에 대해 코틀린이 새로운 기능을 추가할수있을까?
    //이것은 바로 확장함수를 쓴것!! 즉 last()는 List의 확장함수였던것
    val numbers: Collection<Int> = setOf(1, 14, 2)
    println(numbers.max())
    //3.4.2 가변인자함수 : 인자의 개수가 달라질 수 있는 함수 정의
    //args 표현
    val arr: Array<String> = arrayOf("test1", "test2")
    val argsList = listOf("args : ", *arr);
    println(argsList)
    println(argsList.size)

    //3.4.3 값의 쌍 다루기 : 중위 호출과 구조 분해 선언
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three");
    //위 map 선언시 to라는 것은 kotlin의 키워드가 아니다. 이코드는 중위호출이라는 특별한 방식으로 to라는 일반 메서드를 호출한것이다.(infix)
    println("map : ${map}")
    val (number, name) = 1 to "one" //구조분해선언 infix (Pair)
    println("number : ${number} // name : ${name}")

    /**
     * 3.5 문자열과 정규식 다루기
     * 코틀린은 다양한 확장함수를 제공함으로써 표준 자바 문자열을 더 즐겁게 다루게 해준다.
     */
    //3.5.1 문자열나누기 (자바는 spring에서 (.)에대해서 나눌때 정규식으로 인정되어 잘 안될것
    println("kotlin split : " + "12.345-6.A".split("\\.|-".toRegex()))
    println("kotlin split : " + "12.345-6.A".split(".", "-"))//toRegex를 안하면 ., -이걸로 자른다.


}

/**
 * 3.1 코틀린에서 컬렉션 만들기
 * 코틀린 컬렌셕 클래슨느 자바 클래스를 활용한다
 */
fun collectionStudy() {
    println("============ collection study ============")
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "One", 7 to "seven", 53 to "fifty-three") //앞에 숫자는 key, to 뒤에 string은 value

    println("set : ${set}")
    println("list : ${list}")
    println("map : ${map}")

    val strings = listOf("first", "second", "fourteenth")
    println("strings last element : ${strings.last()}");
}

/**
 * 3.2 함수를 호출하기 쉽게 만들기
 */
fun callEasyFunc() {
    //(1; 2; 3) 리스트 원소를 만들려면 ? -> 코틀린 표준 라이브러리에서 제공 (하지만 이번엔 직접 함수구현)
    val list = listOf(1, 2, 3)
    val resultList = joinToString(list, "; ", "(",")") //해당 함수는 인자값이 어떠한것들을 받는지 햇갈린다
    println(resultList)

    //위 인자값 명을 명시가 가능하다
    val resultList2 = joinToString(list, separator = "; ", prefix = "(", postfix = ")")
    println(resultList2)
}
fun<T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix : String
): String {
    val result = StringBuilder(prefix)
    //collection withIndx ? : collection의 index를 모두 받는다.
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString();
}

/**
 * 3.3 메서드를 다른 클래스에 추가 : 확장 함수와 확장 프로퍼티
 * 어떤 면에서는 String 클래스에 새로운 메서드를 추가하는 것과 같다.
 * 주의!
 * 어떤 클래스를 확장한 함수와 그 클래스의 맴버 함수의 이름과 시그니처가 같다면 확장함수가 아니라
 * 멤버 함수가 호출된다(멤버 함수의 우선순위가 더높음!)
 */
fun<T> Collection<T>.joinToStringExtendFunction(
    separator: String = ", ",
    prefix: String = "",
    postfix : String = ""
): String {
    val result = StringBuilder(prefix)
    //collection withIndx ? : collection의 index를 모두 받는다.
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString();
}

val String.lastChar: Char
    get() = get(length - 1)
var StringBuilder.lastChar: Char
    get() = get(length - 1) //프로퍼티 게터
    set(value: Char) { //프로퍼티 세터
        this.setCharAt(length - 1, value)
    }

/**
 * 3.4 컬레션 처리 : 가변길이인자, 중위함수호출, 라이브러리 지원
 */
//3.4.3 값의 쌍 다루기 : 중위호출 관련
infix fun Any.to(other: Any) = Pair(this, other)






