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
   */
  def pascal(c: Int, r: Int): Int = {
      def pascalIter(c: Int, r: Int): Int = {
          if (c <  0 || r < 0) 0
          else if (c == 0 || c == r) 1
          else pascalIter(c-1, r-1) + pascalIter(c, r-1)
      }
      pascalIter(c, r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceIter(chars: List[Char], opened: Int): Boolean = {
      if (chars.isEmpty) opened == 0
      else if (opened<0) false
      else if (chars.head == '(') balanceIter(chars.tail, opened+1)
      else if (chars.head == ')') balanceIter(chars.tail, opened-1)
      else balanceIter(chars.tail, opened)
    }

    balanceIter(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

      def ways(amount: Int, xs: List[Int]):Int = {
      
      if (amount == 0) 1
      else if (amount < 0 || xs.isEmpty) 0 
      else {
        ways(amount, xs.tail) + ways(amount-xs.head, xs)
      }
      
    }

    ways(money, coins)

  }
}
