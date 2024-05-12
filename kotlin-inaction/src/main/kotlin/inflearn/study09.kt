package inflearn

/**
 * 강의9. 코틀린에서 클래스르 다루는 방법
 * 1. 클래스와 프로퍼티
 * - 코틀린에서는 필드를만들면 getter, setter가 자동으로 생김
 * 2 주생성자, 부생성자
 * - 코틀린에서는 주생성자가 필수이다 (클래스이름 옆에)
 * - 부생성자를 만들수있지만 default parameter or 정적메소드 활용하는것을 추천
 * 3. 커스텀 getter, setter
 * - 실제 메모리에 존재하는 것과 무관하게 custom getter, custom setter 사용가능
 */
fun main() {
    //클래스와 프로퍼티
    val person : Person = Person("Seo Dong Hwi", 35)
    println("getter name = ${person.name}")
    person.age = 10;
    println("getter age = ${person.age}")

    //부생성자
    var baby = Person("Baby")
    println("=============")
    var hong = Person()

    //커스텀 getter, setter

}


/**
 * 자동으로 getter, setter 만들어줌
 * - 생성자안에 검증로직을 만든다면 ?
 * - 만약 생성자를 여러개 만들경우 ? (아기생성) 아기는 최초1살부터니까!
 * - 위 부생성자는 가능하지만 default parameter를 더 권장함 만약, 에일리언이 사람이 되는경우 부생성자보다 정적 팩토리 메소드를 사용
 */
class Person(
    name: String = "Seo Dong Hwi",
    var age: Int = 1) { //생성자 & 필드생성을 한번에! (주생성자는 무조건 있어야함)

    //setter (하지만 setter 지양을 해야한다) 그렇다보니 backing setter 잘안쓰긴함
    var name : String = name
        set(value) {
            field = value.uppercase()
        }


    //name의 custom getter (위 주생성자에 val를안주면 프로퍼티가아니기때문에 getter 생성안함)
    /*val name = name
        get() = field.uppercase()*/ //field를 사용하는이유? name이 name을 가르키는 무한루프가발생 (backing field)

    val getUpperCaseName: String
        get() = this.name.uppercase()

    //클래스가 초기화되는 시점 (생성자에 검증로직을 만든다면 여기다가 만들면됨)
    init {
        if (age <= 0) {
            throw IllegalArgumentException("age error")
        }
        println("초기화 블록")
    }

    //this는 위 주(Primary) 생성자를 호출
    constructor(name: String): this(name, 1) {
        println("아기 생성")
    }

    //이것은 부 생성자 호출 -> 부생성자가 주생성자 호출
    constructor() : this("홍길동") {
        println("홍길동 생성")
    }


    //custom getter - 장점 : 자기자신을 변경 가능
    val isAdult: Boolean
        //expression 표현
        get() = this.age >= 20

    fun nextYearAge(year: Int): Int {
        println("맴버함수")
        return this.age;
    }
}