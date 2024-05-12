package inflearn

/**
 * 강의16. 코틀린에서 다양한 함수를 다루는 방법
 * 1. 확장함수
 * - 코틀린은 java와 100%호환을 목적으로함
 * - 확장함수는 클래스에 있는 private or protected 맴버를 가져올수없다.!
 * - 맴버함수가 우선적으로 호출됨
 * - 확장함수가 오버라이드? -> 해당 변수의 현재타입 함수가 호출됨
 * 2. infix 함수
 * - 3 add2 4 이런식을 쓸수있게끔한다
 * 3. inline 함수
 * - 함수를 파라미터로 전달할때에 오버헤드를 줄일수있음
 * - 함수를 복사-붙여넣기 하는 함수
 * 4. 지역함수
 * -
 */
fun main() {
    val test: String = "test"
    println("test lastChar = ${test.lastChar()}")

    //확장함수 vs 맴버함수
    val person: Person = Person("test", 10)
    println("확장 vs 맴버 = ${person.nextYearAge(1)}")

    //infix
    println(2 add2 5);
}
//String 안에 기능구현 (확장함수)
fun String.lastChar(): Char = this[this.length - 1]

infix fun Int.add2(other: Int) = this + other

inline fun Int.add(other: Int): Int = this + other

//확장함수가 public이고, 확장함수에서 수신객체클래스의 private 함수를 ?

fun Person.nextYearAge(): Int {
    println("확장함수")
    return this.age + 1
}

//지역함수 활용예제 - 함수내에서만 쓰고싶은경우
//다만 코드가 길어짐 ... depth가 깊어짐, 코드가 그렇게 깔끔하지는 않다.
fun createPerson(firstName: String, lastName: String): Person? {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Name is empty");
        }
    }

    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return null;
}