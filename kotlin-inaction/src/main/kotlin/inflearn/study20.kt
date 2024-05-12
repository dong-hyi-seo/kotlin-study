package inflearn

/**
 * 강의20. 코틀린의 scope function
 * 1. 뭘까요?
 * - scope(영역) function(함수) : 일시적인 영역을 형성하는 함수
 * - let : 확장함수, 람다를 받아, 람다 결과를 반환한다.
 * - 람다를 사용해 일시적인 영역을만들어
 * - 코드를 더간결하게됨, method chaning에 활용
 *
 * 2. scope function의 분류
 * - let(it 사용), run(this 사용) 람다의 결과가 반환됨
 * - also(it 사용), apply(this 사용) 객체 자체가 반환됨 (람다의 결과와 무관하게 객체가 반환됨)
 * - with(this 사용)
 *
 * 3. 언제 어떤 scope function을 사용?
 * - let : 하나 이사으이 함수를 call chain 결과로 호출할때
 * : non-null 값에 대해서만 code block을 실행시킬때 (제일 많이사요됨)
 * - run : 객체를 만들어 DB에 바로 저장하고, 그인스턴스를 활용할떄
 * - apply : 객체 그 자체가 반환한다.
 * 4. scope function과 가독성
 */

fun main() {

    var str : String? = "test"
    //let 함수 제일많이사용됨
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

}

//scope function
//
fun printPerson(person: Person?) {
    //let은 scope function
    //let : 확장함수, 람다를 받아, 람다 결과를 반환한다.
    person?.let {
        println(it.name)
        println(it.age)
    }
    /*if (person != null) {
        println(person.name)
        println(person.age)
    }*/
}
