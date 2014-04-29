package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
0:     1
1:    1 1
2:   1 2 1
3:  1 3 3 1
4: 1 4 6 4 1
   ...
   */
  def pascal(c: Int, r: Int): Int =
    if(c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(acc: Int, chars: List[Char]): Boolean = {
      if(chars.isEmpty)
        // There are no parentheses left to balance
        if(acc == 0) return true
        else return false
      // There are no opening parentheses
      if(acc == 0 && chars.head == ')') return false
      if(chars.head == '(') loop(acc + 1, chars.tail)
      else if(chars.head == ')') loop(acc - 1, chars.tail)
      else loop(acc, chars.tail)
    }
    loop(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
