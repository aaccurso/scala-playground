package week4

object funobjects {
  object List {
  	def apply(x: Int) = x * x
  }
  List(2)                                         //> res0: Int = 4
  
  class FunObject {
  	def apply(x1: Int, x2: Int) = x1 * x2
  }
  val funobj = new FunObject()(2,4)               //> funobj  : Int = 8
}