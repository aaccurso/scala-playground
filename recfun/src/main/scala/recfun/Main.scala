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
    def loop(openingParentheses: Int, chars: List[Char]): Boolean = {
      def isOpeningParentheses =
        chars.head == '('
      def isClosingParentheses =
        chars.head == ')'
      // There are no opening parentheses left to balance => balanced
      if(chars.isEmpty && openingParentheses == 0) true
      // Opening parentheses remain unbalanced or
      // there are no opening parentheses for a closing one => unbalanced
      else if(chars.isEmpty || openingParentheses == 0 && isClosingParentheses) false
      else if(isOpeningParentheses) loop(openingParentheses + 1, chars.tail)
      else if(isClosingParentheses) loop(openingParentheses - 1, chars.tail)
      else loop(openingParentheses, chars.tail)
    }
    loop(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
      if(money == 0) 1
      else if(money < 0 || coins.isEmpty) 0
      else countChange(money - coins.head, coins) +
      	countChange(money, coins.tail)
}
