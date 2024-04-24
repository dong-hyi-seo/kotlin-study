package inflearn

class Money(val amount: Long) {

    //연산자 오버로딩(+) 기호로 사용 가능
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount);
    }

    override fun toString(): String {
        return "Money(amount=$amount)"
    }


}