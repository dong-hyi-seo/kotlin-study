package inflearn

/**
 * 강의17. 코틀린에서 람다를 다루는 방법
 * 1. Java에서 람다(이름이 없는 함수)를 다루기위한 노력
 *
 * 2. 코틀린에서의 람다
 * - kotlin에서는 함수가 그자체로 값이됨
 *
 * 3. Closure
 * - Java는 람다를 쓸때 사용할수 있는 변수제약(외부변수 사용불가능)
 * - 하지만 코틀린은 가능하다. (어떻게?)
 * - 람다를 진정한 일급시민으로 간주할수있다. 이 데이터구조를 Closure
 * - 코틀린에서는 람다가 시작하는 지점에 참조하고있는 변수들을 모두포획하여 그정보를 가지고있음
 *
 * 4. try with resources (use)
 */
fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_000),
        Fruit("사과", 1_000),
        Fruit("사과", 1_000),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000),
    )
    println(fruits);

    //함수를 만들어 람다를 만드는방법 (이름만빠짐)
    //closure
    val filterFruitName = "사과"; //java에서는 에러가발생 외부변수 사용불가능 람다내에서
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == filterFruitName
    }

    //위에것보다 중가로를 활용하여 함수 만듬(람다)
    //val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }
    val isApple2: (Fruit) -> Boolean = { it.name == filterFruitName }

    val filterFruitList = filterFruits(fruits, isApple);
    val filterFruitList2 = filterFruits(fruits, isApple2);
    println("filterFruitList = ${filterFruitList}")
    println("filterFruitList2 = ${filterFruitList2}")
}

private fun filterFruits(fruits: List<Fruit>,
                         filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}