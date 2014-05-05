object excercises {

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  	def loop(n: Int, acc: Int): Int =
  		if(n > b) acc
  		else loop(n + 1, combine(f(n), acc))
  	loop(a, zero)
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  	
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x)(1, 3)                           //> res0: Int = 6
  
  def factorial(n: Int) = product(x => x)(1, n)   //> factorial: (n: Int)Int
  factorial(4)                                    //> res1: Int = 24
}