package inflearn

/**
 * 동물 추상화 클래스
 * open을 주면 자식 클래스에서 사용가능 (오버라이드하려면 open이라는 것을 사용)
 */
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int,
) {

    abstract fun move()


}