package inflearn

/**
 * backing field 생성 가능
 */
interface Swimable {

    val swimAbility : Int
        get() = 3

    //java의 defualt 함수
    fun act() {
        println(swimAbility)
        println("어푸 어푸")
    }
}