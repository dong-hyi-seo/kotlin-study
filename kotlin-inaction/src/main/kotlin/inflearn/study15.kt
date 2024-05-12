package inflearn

/**
 * 강의15. 코틀린에서 배열과 컬렉션을 다루는 방법
 * 1. 배열 (배열은 잘 사용하지않는다. 이펙티브에서 List를사용하라고함)
 * 2. 코틀린에서 Collection - List, Set, Map
 * 3. 컬렉션의 null 가능성, Java와 함께 사용하기
 * - List<Int?> = 리스트에 null이 들어갈수있음 list는 null이 될수없음
 * List<Int>?, = 리스트에 null못들어가지만 list는 null이 될수있음
 * List<Int?>? = 둘다 null가능
 * java는 읽기전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다.
 *
 * - 가변(Mutable) 컬렉션 : 컬레션에 element를 추가 삭제 가능
 * - 불변 컬렉션 : 컬레션 element를 추가 삭제 할 수 없음
 */
fun main() {

    //[100, 200] 생성
    val array = arrayOf(100, 200)
    println("array = $array")

    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    for ((index, value) in array.withIndex()) {
        println("${index} ${value}")
    }

    //불변 add, remove 사용 못함
    val numbers = listOf(100, 200)
    numbers[0]
    numbers.get(0)
    for (number in numbers) {
        println(number)
    }

    for ((index, value) in numbers.withIndex()) {
        println("${index} ${value}")
    }

    //가변 List
    val numbers2 = mutableListOf(100, 200)
    numbers2.add(100)

    //empty list 타입 명시!!
    val emptyList = emptyList<Int>()
    printNumbers(emptyList()) //타입 추론


    //map
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    //불변맵
    val unMutableMap = mapOf(1 to "MONDAY", 2 to "WEDNESDAY", 3 to "THURSDAY");
    println("unMutableMap = ${unMutableMap}")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }

    //컬렉션의 null 가능성
}

private fun printNumbers(numbers: List<Int>) {

}