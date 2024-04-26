package inflearn

import java.io.File

/**
 * 강의 07. 코틀린에서 예외를 다루는 방법
 * 1. try catch finally 구문
 * 2. Checked Exception 과 Unchecked Exception
 * 3. try with resources
 */
fun main() {
    //try catch finally
    parseIntOrThrow("123")
    parseIntOrThrowV2("123")

    //Checekd Exception & Unchecekd Exception
    /**
     * 7강관련
     * Kotlin 에서는 Checked Exception과 Unchecked Exception을 구분하지 않는다.
     * 모두 Unchecked Exception 이다.
     */
    val filePrinter: FilePrinter = FilePrinter()
    filePrinter.readFile()


    //kotlin에서 try resources가 없음 -> use 함수를 사용
    val currentFile = File("")
    filePrinter.readFileV2(currentFile.absolutePath + "/a.txt")


}

fun parseIntOrThrow(str: String) : Int {
    try {
        return str.toInt();
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }

}

//try catch 도 return type이 될 수있다. 즉 하나의 Expression으로 간주한다.
fun parseIntOrThrowV2(str: String) : Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}
