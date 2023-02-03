package two

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
