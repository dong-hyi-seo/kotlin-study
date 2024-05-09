package inflearn

/**
 * 강의14. 코트린에서 다양한 클래스를 다루는 방법
 * 1. data class
 * 2. enum class
 * 3. sealed class, sealed interface
 * - 상소이 가능하도록 추상클래스를 만들까 하는데..
 * 외부에서는 이 클래스를 상속받지 않았으면 좋겠어..
 * - 컴파일 타임 떄 하위 클랫의 타입을 모두 기억한다.
 * 즉, 런타임떄 클래스 타임이 추가 될 수 없다.
 * 하위 클래스는 같은 패키지에 있어야한다.
 * - Enum과 다른점은 클래스를 상속받을수 없으며, 하위 클래스는 멀티 인스턴스가 가능하다.
 */

fun main() {
    val personDto1 = PersonDto("서동휘", 35)
    val personDto2 = PersonDto("서동휘", 37)

    println(personDto1 == personDto2)

}

//java로 따지면 record
//data를 붙여주면 equals, hashcode, toString
data class PersonDto(
    val name : String,
    val age : Int
) {

}

/**
 * when은 enum class혹은 seald와 같이쓰면 더 유용함
 * 소스의 간결함을 가져가고
 * 가독성이 늘어남
 * enum의 변화가생기면 when에서 알려주다.
 */
fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

/**
 * when은 enum class혹은 seald와 같이쓰면 더 유용함
 */
enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US")
    ;
}


/**
 * sealed class ,sealed interface
 * enum 처럼 컴파일때 타입이 확정되므로 런타임떄 변경되지못함 즉 enum과 같아 when에서도 사용가능
 */
sealed class  HyunaiCar (
    val name: String,
    val price: Long,
) {

}

