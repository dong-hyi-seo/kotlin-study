package inflearn

/**
 * 2강. 코틀린에서 null을 다루는 방법
 *
 * java 와 같이 사용할경우 Java 필드에 @NotNull, @Nullable 어노테이션으로 구분하게해야함!
 * 코틀린은 해당 어노테이션을 이해한다.
 * 그리고 만약 이것을 안주게되면 컴파일시에 에러가 나는게아니라 runtime시에 에러가 발생함
 *
 * 이런경우 주로 library를 사용할경우에 java로된것..
 * 해당 library 소스의 nullable 여부를 확인해야함
 */
fun main() {
    //safe call
    val str: String? = "ABC"
    println(str?.length) //Null이 아닐경우 length 함수 실행 null이면 전체가 null이됨

    //elvis 연산자
    val str2: String? = null
    val length = str2?.length ?: 0 //앞의 연산결과가 null이면 뒤의 값 사용
    println("elvis : = $length")

    println("!! : = " + startsWithA4(null));
}


fun startsWithA1(str: String?): Boolean {
    /*if (str == null) {
        throw IllegalArgumentException("null input")
    }
    return str.startsWith("A")*/
    return str?.startsWith("A") ?: throw IllegalArgumentException("null input!")
}

fun startsWithA2(str: String?) : Boolean? {
    /*if (str == null) {
        return null;
    }
    return str.startsWith("A")*/
    return str?.startsWith("A") //str값이 null이면 null을 return
}

fun startsWithA3(str: String?): Boolean {
    /*if (str == null) {
        return false;
    }
    //위 null check가없으면 아래는 에러가 발생 (null대응)
    return str.startsWith("A")*/
    return str?.startsWith("A") ?: false
}

/**
 * str!! 이 것은 해당 str값이 절대 Null이 될수없음 !
 * 컴파일에서는 에러가 발생하지 않지만 런타임에서는 에러가 발생한다!
 * 정말 null이 아닌게 확실한 경우에만 null 아님 단언!!을 사용!!
 */
fun startsWithA4(str: String?) : Boolean {
    return str!!.startsWith("A")
}
