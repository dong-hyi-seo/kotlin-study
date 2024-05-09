package inflearn

/**
 * [질문 요약 ]
 *
 * abstract class vs sealed class
 * - abstract class 보다 계층 구조를 안전하게 하기 위해 sealed class가 생긴 것으로 이해
 * - sealed class 가 상위호환 아닌가?
 *
 * 둘의 가장 큰 차이는 구현체가 같은 패키지에만 있어야하나, 어디든 있어도 되냐?
 * 라이브러리 / 프레임워크 : abstract class 가져가게 하고 싶다
 *
 * 실무 : 멀티 모듈을 쓰는 경우 : A 모듈에서 만들어둔 class를 B 모듈과 C 모듈에서 구현하게 하고싶다 -> abstract class
 * 그렇다면 interface 쓰면 되는거ㅏㅇ냐? 왜 abstract??
 * 머 둘의 차이는 공통된 구현 코드가 있는가? / 없는가 (행위만을 규정하는가)??
 *
 *
 */