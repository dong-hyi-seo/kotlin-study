package inflearn

import two.Person

fun main() {

    var number1 = 10L
    number1 = 11L;

    //final = read only
    val number2 = 10L;
    //number2 = 11L;


    /**
     * 이펙티브자바에서 연산을할때는 레퍼런스타입을 쓰지말라하는데
     * boxing과 unboxing이 이루어짐
     *
     * 하지만 코틀린에서는 ?
     * 아래는 java로 따지면 레퍼런스타입으로 느끼겠지만, 코틀린에서 연산시에 알아서 primitive type으로 바꾸어서 연산함
     */
    val number3: Long = 11L;

    /**
     * null 허용
     * 타입 뒤에 ? 를 붙여야함
     */
    var number4: Long? = null;

    /**
     * 객체 인스턴스화시에 new 가 필요없음
     */
    var persion = Person("afaf");
}