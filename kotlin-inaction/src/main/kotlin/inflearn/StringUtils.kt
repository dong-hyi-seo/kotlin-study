package inflearn

//util 성 함수는 kotlin 파일 생성하여 최상단에 생성하면 편함 (compile시에 java static으로 생성 )
fun isDirectoryPath(path : String) : Boolean {
    return path.endsWith("/")
}