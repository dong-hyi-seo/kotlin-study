package inflearn

class Cat(
    species: String
) : Animal(species, 4) {


    //override를 필히 넣어주어야함
    override fun move() {
        println("고양이가 사뿐싸분 걸어가")
    }
}