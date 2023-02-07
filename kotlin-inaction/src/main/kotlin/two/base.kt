package two

import two.Color.*
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

    //변수 (var, val)에 관한것
    valueTest();

    //더 쉬운 문자열 지정
    useString();

    //property 사용 (접근) getter가아닌 프로퍼티 필드 자체 접근
    val person = Person2("Donghyi", false)
    println("person class name : ${person.name}")
    println("person class isMarried : ${person.isMarried}")

    //커스텀 프로퍼티
    val rectangle = Rectangle(41, 43)
    println("rectable isSquare : ${rectangle.isSquare}")

    //enum
    println("enum : ${Color.BLUE.rgb()}")

    //when
    println("when : ${getMnemonic(Color.YELLOW)}")
    println("when : ${getWarmth(Color.YELLOW)}") //when 분기조건 묶기
    println("when : ${mix(Color.YELLOW, Color.RED)}") //when에서 임의의 객체를 함께 사용
    println("when : ${mixOptimized(Color.YELLOW, Color.RED)}") //위 mix 함수 호출시 set 인스턴스매번생성 하는 것을 다른코드로 짠것

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

//val, var 공부
fun valueTest() {
    //변경 불가능한 참조를 저장하는 변수
    val immutableValue : Int = 22;
    //immutableValue = 3 // -> 변경 불가능!!

    //변경 가능한 변수
    var mutableValue = 22;
    println(mutableValue);
    mutableValue = 3;
   //mutableValue = "miss match" (초반에 선언한 변수가 Int형이기 떄문에 스트링으로 데이터 주입시 error 발생)
    println(mutableValue);

    //val 참조 자체는 불변일지라도 그 참조가 가리키는 객체의 내부 값은 변경될 수 있따는 사실을 기억
    val languages = arrayListOf("Java") // -> 불변 참조를 선언한다.
    languages.add("Kotlin") // -> 참조가 가리키는 객체 내부를 변경한다.
    println(languages)
}

//더 쉽게 문자열 형식 지정
fun useString() {
    val str = "Kotlin"
    println("Hello $str");
    println("Hello ${if (str == "kotlin") "kotlin" else str}")
}

fun simpleMax2(a:Int, b:Int) = if (a > b) a else b

/**
 * class와 프로퍼티 관련
 * java person 객체
 *
 * 아래 Person 객체를 java로 할경우 별도 생성자와 getter를 만들어야한다.
 * 하지만 kotlin에서 자동적으로 생성해줌.
 * 아래 유형의 클래스(코드가 없이 데이터만 저장하는 클래스)를 값 객체(Value Object)라 부른다.
 *
 * 프로퍼티(Property)
 * 자바에서는 필드와 접근자를 한데 묶어 프로퍼티라고 부른다.
 */
class Person(val name: String)

//property
class Person2 (
    val name : String,
    var isMarried: Boolean
)

/**
 * 커스텀 접근자
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() { //프로퍼티 게터선언
            return height == width
        }
}

/**
 * enum
 */
enum class Color (
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b;
}

/**
 * when
 * java와 달리 break가 필요없다.
 *
 */
fun getMnemonic(color : Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "York"
        Color.BLUE -> "York"
    }

//when 분기 조건 묶기
fun getWarmth(color : Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW-> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE -> "cold"
}

//when과 임의의 객체를 함께 사용
//java에서 분기조건 상수, 리터럴만 사용가능한 것에 비해 코틀린 when의 분기조건은 임의의 객체를 허용한다.
fun mix(c1: Color, c2:Color) = when(setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.GREEN, Color.BLUE) -> Color.YELLOW
    else -> throw Exception("Dirty Color")
}

/**
 * when 인자 없는 when 사용
 * 위 mix함수는 비효율적임 : 호출될 때마다 인자루 주어진 두색이 when의 분기조건에 있는 다른 두색과 같은비 비교하기위해
 * set인스턴스를 매번 생성하게됨 (가비지 객체가 늘어남)
 *
 * 해결 : 인자가 없는 when 식을 사용하면 불필요한 객체 생서을 막을수있다.
 * 하지만 가독성이 떨어지수도있음
 */
fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
    (c1 == GREEN && c2 == BLUE) || (c1 == BLUE && c2 == GREEN) -> YELLOW
    else -> throw Exception("Dirty Color")
}

