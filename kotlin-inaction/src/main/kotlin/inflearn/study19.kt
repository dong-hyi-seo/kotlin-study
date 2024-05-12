package inflearn

/**
 * 강의19. 코틀린의 이모저모
 * 1. Type Alias와 as import
 * - 긴 이름의 클래스 혹은 함수타입이 있을떄, 축약하거나 더 좋은 이름을 쓰고싶다!
 * 2. 구조분해와 componentN 함수
 * - 구조분해 : 복합적인 값을 분해하여 여러 변수를 한번에 초기화 하는것
 * 3. Jump와 Label
 * 4. TakeIf와 takeUnless
 * - 특정 expression 라벨이르@을 붙여하나의 라벨로 간주하고 break, continue, return등을 사용
 */

//data class는 componentN을 만들어준다 기본적으로
//component1은 name을가져오고, component2는 age를 가져온다
data class Person19(
    val name: String,
    val age: Int
) {}
//만약 data class가 아닌데 componentN을 사용 하고싶을떄
class Person19_1(
    val name: String,
    val age: Int
) {
    //operator : 연산자 오버로딩 (코틀린에서 이미 정해져있는 함수를 새롭게정의할떄 사용)
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun main() {
    val person = Person19("test",100)
    val (name, age) = person //name, age를 인식해서 가져오는것이아님! 순서가있음
    println("$name, $age")

    val person1 = Person19_1("test",100)
    val (name1, age1) = person1 //name, age를 인식해서 가져오는것이아님! 순서가있음
    println("$name1, $age1")

    //jump!
    val numbers = listOf(1, 2, 3)
    //foreach내에서 continue, break 사용 안됨 전통적인 for문에서는 가능
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    //만약 꼭쓰겠다면?
    //굳이 사용하지말고 가급적이면 익숙한 for문을 사용추천
    //다른 사람들에게도 익숙한 코드로!!
    run {
        numbers.forEach { number ->
                if (number == 2) {
                    return@run //break
                    //return@forEach //continue
                }
            }
    }

    //라벨기능을 사용하면 맨 바깥이 break
    //즉 라벨걸린 for문 break
    //라벨을 사용한 jump는 강력하게 사용하지 않는것으로 추천
    abc@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@abc
            }
            println("$i, $j")
        }
    }

    for (i in 1..100) {
        abc@ for (j in 1..100) {
            if (j == 2) {
                break@abc
            }
            println("$i, $j")
        }
    }
}

//이게 너무길어! 타입을 축약해보자
typealias FruitFilter = (Fruit) -> Boolean
private fun filterFruits2(fruits: List<Fruit>,
                          filter: FruitFilter): List<Fruit> {
    return fruits.filter(filter)
}

data class UltraSuperGuardianTribe(val name : String)
typealias USGTMap = Map<String, UltraSuperGuardianTribe>

fun getNumberOrNull(number:Int) : Int? {
    return if (number <= 0) {
        null
    } else {
        0
    }
}

//주어진 조건을 만족하면 그값이, 그렇지 않으면 Null이 반환
fun getNumberOrNullV2(number:Int): Int? {
    return number.takeIf { it > 0 }
}

//주어진 조건을 만족하지 않으면 그값이, 그렇지 않으면 null
fun getNumberOrNullV3(number:Int): Int? {
    return number.takeUnless { it > 0 }
}