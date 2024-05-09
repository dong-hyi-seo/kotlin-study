package inflearn

/**
 * 강의12. 코틀린에서 object 키워드를 다루는 방법
 * 1. static 함수와 변수
 * - 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리 값을 공유
 * 2. 싱글톤
 * - object 로 생성
 * 3. 익명 클래스
 * - 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
 */
fun main() {

    val person = Person12.newBaby("ABC")

    //val factoryPerson = Person12.Factory.newBaby("FACTORY")

    //익명 클래스 (java에서는 new ~~ 이걸로하지만 kotlin에서는 object : 이게됨)
    moveSomting(object: Movable {
        override fun fly() {
            TODO("Not yet implemented")
        }

        override fun move() {
            TODO("Not yet implemented")
        }
    })
}

class Person12(
    var name: String,
    var age: Int,
) {
    //kotlin에는 static이 존재하지 않음

    /**
     * 대신 동행객체가 있음 : 클래스와 동행하는 유일한 오브젝트
     *
     * JAVA 와 다른점 ?
     * companion object, 즉 동반객체도 하나의 객체로 간주된다.
     * 떄문ㅇ 이름을 붙일수도 있고, interface를 구현할수있음
     *
     * companion object에 유틸성 함수들을 넣어도 도지만, 최상단 파일을 활용하는 것을 추천
     *
     */
    companion object {
        private const val MIN_AGE = 1; //const는 컴파일시에 값이 할당됨. 기본타입과 String에 붙일 수 있음
        fun newBaby(name: String) : Person12 {
            return Person12(name, MIN_AGE)
        }
    }

    /**
     * companion 내에 interface 구현도 가능
     */
    /*companion object Factory : Log {
        private const val MIN_AGE = 1; //const는 컴파일시에 값이 할당됨. 기본타입과 String에 붙일 수 있음
        fun newBaby(name: String) : Person12 {
            return Person12(name, MIN_AGE)
        }

        override fun log() {
            println("난 Factor 동해객체의 인터페이스 log 함수 !")
        }
    }*/
}

//singleton instance 하나!
//강사님은 개발할때 직접적으로 쓰진 않았다고함 ..
object Singleton {
    var a: Int = 0
}

private fun moveSomting(movable: Movable) {
    movable.move()
    movable.fly()
}
