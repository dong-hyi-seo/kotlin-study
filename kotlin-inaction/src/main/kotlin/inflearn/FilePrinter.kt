package inflearn

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * 7강관련
 * Kotlin 에서는 Checked Exception과 Unchecked Exception을 구분하지 않는다.
 * 모두 Unchecked Exception 이다.
 */
class FilePrinter {

    fun readFile() {
        val currentFile = File("")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    //kotlin에서 try resources가 없음 -> use 함수를 사용
    fun readFileV2(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine());
        }
    }

}