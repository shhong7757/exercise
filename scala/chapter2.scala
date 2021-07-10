object MyModule {
  def main(args: Array[String]): Unit = {
    // 연습문제 2.1
    println(fib(5))

    // 연습문제 2.2
    val intArraySorted = Array(1, 2, 3, 4, 5)
    val intArray = Array(1, 3, 2, 5, 4)

    println(
      isSorted(intArray, isIntOrdered),
      isSorted(intArraySorted, isIntOrdered)
    )

    // 연습문제 2.3
    println(curry((a: Int, b: Int) => a + b)(1)(2))

    // 연습문제 2.4
    println(uncurry((a: Int) => (b: Int) => a + b)(1, 2))

    // 연습문제 2.5
    println(compose((a: Int) => a - 1, (b: Int) => b * b)(2))
  }

  // 연습문제 2.1
  // n번째 피보나치 수를 돌려주는 재귀 함수를 작성하라.
  // 처음 두 피보나치 수는 0과 1이다. n번째 피보나치 수는 항상 이전 두 수의 합이다.
  // 즉, 피보나치수열은 0, 1, 1, 2, 3, 5로 시작한다.
  // 반드시 지역 꼬리 재귀 함수를 사용해서 작성할 것.
  def fib(n: Int): Int = {
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)

    loop(n, 0, 1)
  }

  // 연습문제 2.2
  // Array[A]가 주어진 비교 함수에 의거해서 정렬되어 있는지 점검하는 isSorted 함수를 구현하라.
  // 서명은 다음과 같다.
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def go(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (ordered(as(n), as(n + 1))) false
      else go(n + 1)

    go(0)
  }

  def isIntOrdered(a: Int, b: Int): Boolean = a > b

  // 연습문제 2.3
  // 또 다른 예로, 인수가 두 개인 함수 f를 인수 하나를 받고 그것으로 f를 부분 적용하면 함수로 변환하는 커링을 살펴보자
  // 이번에도 컴파일되는 구현은 단 한가지다. 그러한 구현을 작성하라.
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

  def sum(a: Int, b: Int): Int = a + b

  // 연습문제 2.4
  // curry의 변환을 역으로 수행하는 고자 함수 uncurry를 구현하라.
  // =>는 오른쪽으로 묶이므로, A => (B => C)를 A => B => C라고 표기할 수 있음을 주의할 것.
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  // 연습문제 2.5
  // 두 함수를 합성하는 고차 함수를 구현하라.
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
}
