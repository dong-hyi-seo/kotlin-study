package inflearn

/**
 * 강의13. 코틀린에서 중첩 클래스를 다루는 방법
 * 1. 중첩 클래스 종류
 * - 내부클래스
 *  - 내부클래스는 숨겨진 외부 클래스 정보를 가지고 있어,
 *  참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고,
 *  이를 디버깅 하기 어렵다.
 *  - 내부 크래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다.
 *  - 그래서 내부클래스를 사용하려면 static을 사용해라
 *  - Java에서는 위와같이 해야하지만 kotlin에서는 위 권장사항을 그대로 따라하고있음
 *
 */
fun main() {

}

/**
 * 바깥클래스와 연결이 안된것 (권장!!)
 * kotlin에서는 아래와 같이 만들면
 * 바깥의 클래스와 참조되지않는 내부클래스가 자동으로 생성됨
 */
class JavaHouse (
    private val address: String,
    private val livingRoom: LivingRoom
) {

    class LivingRoom(
        private val area: Double
    ) {

    }
}

/**
 * 바깥클래스와 연결이 된 내부클래스 (관장하지않음!!)
 *
 * inner라는것을 사용하면됨
 */
class House (
    private var address: String
) {

    inner class LivingRoom(
        private val area: Double,
    ) {
        val address: String
            get() = this@House.address
    }
}
