package three

import java.lang.StringBuilder

/**
 * 3장. 함수정의와 호출
 * - 컬렉션, 문자열, 정규식을 다루기위한 함수
 * - 이름 붙인 인자, 디폴트 파라미터 값, 중위 호출 문법사용
 * - 확장 함수와 확장 프로퍼티를 사용해 자바 라이브러리 적용
 * - 최상위 및 로컬 함수와 프로퍼티를 사용해 코드 구조화
 */

fun main(args: Array<String>) {
    collectionStudy()
    callEasyFunc()
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
 * 3.2.2 디폴트 파라미터 값
 */


