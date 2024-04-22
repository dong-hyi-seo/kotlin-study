package inflearn

import two.Person

/**
 * 코틀린에서 Type을 다루는 방법
 * 1. any = Object -> Primitive type에서 최상위
 * 2. unit = void //타입자체로도 사용이 가능 (타입인자로 사용가능하다는것!!)
 * 3. Nothing은 함수가 저상적으로 끝나지 않았다는 사실을 표현 (무조건 예외를 반환하는 함수!!!)
 * 4. String interpolation / String indexing
 */
fun main() {
    //기본 타입간의 변환은 명시적으로 이루어져야한다. (java는 암시적으로 됨)
    /**
     * val number1 = 4
     * val number2: Long = number1; <- 이거안됨
     */

    val number1 = 3
    val number2: Long = number1.toLong();
    println("number2 = $number2");

    //줄바꿈 쉽게 쓰기
    val test = """
        굿굿굿
        코틀린 3강!
    """.trimIndent()

    println("줄바꿈 테스트 : ${test}")

    //문자내에서 특정위치 단어가져오기
    val test1: String = "ABC"
    println("1 = ${test1[0]}");
    println("2 = ${test1[1]}");
    println("3 = ${test1[2]}");

}

fun printNameIfPerson(obj: Any?) {

    //null 허용하게끔 할려면 ?
    val person = obj as? Person //obj가 Person type이 아니면 예외발생하는 것이아닌 null로나옴 (? <- 때문에) safe call방식
    println(person?.name)


    /*if (obj is Person) { //java로 따지면 instanceOf
        val name = obj.name; //smart casting
        ///생략 또한 가능
        //val person = obj as Person; // java로 따지면 (Person) casting
        println(name);
    }*/

    //위 조건 반대 표현
    /*if (obj !is Person) {

    }*/
}