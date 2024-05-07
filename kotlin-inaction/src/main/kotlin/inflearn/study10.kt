package inflearn

/**
 * 강의10. 코틀린에서 상속을 다루는 방법
 * 1. 추상클래스
 * 2. 인터페이스
 * 3. 클래스를 상속할 때 주의할점
 *
 * final : override를 할수 없게한다. default로 보이지 않게 존재한다.
 * open : override를 열어준다
 * abstract : 반드시 override 해야한다
 * override : 상위 타입을 오버라이드 하고있다.
 */
fun main() {
    //인스턴스 (자식클래스) -> Base class의 number값이 디폴트값의 100 이아닌 0으로 됨
    /**
     * 이유는?
     * 상위 클래스 생성자가 실행되는 동안
     * 하위 클래스의 프로퍼티 즉 이 Derived를 인스턴스화 한다는 말은
     * Derived에 number를 넣어주는것
     *
     * 근데 이떄 상위클래스에서 넘버를 호출하게 되면 ?
     * 하위 클래스에있는 number를 가져온다
     * 근데 아직 상위 클래스에 constructor가 먼저 실행 된 단계라서
     * 하위 클래스에 number가 초기화된것이아님
     *
     * 즉 상위 클래스에서 하위클래스의 property를 접근하면 안된다.
     */
    Derived(300)
}

/**
 * 상위 클래스를 설계할 떄
 * 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 한다.
 *
 * 추상맴버가 아니면 기본적으로 오버라이드가 불가능 (open을 사용)
 */
open class Base(
    open val number : Int = 100
) {
    init {
        println("Base Class")
        println("parent number : $number") //상위 클래스에서 하위클래스의 property를 접근하면 안된다.
    }
}

class Derived(
    override val number : Int
): Base(number) {

    init {
        println("Derived Class")
        println("chiled number : $number")
    }
}