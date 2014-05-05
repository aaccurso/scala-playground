package week2

object rationals {
  val x = new Rational(1,3)
  val y = new Rational(5,7)
  
  x.add(y)
}

class Rational(x: Int, y: Int) {
	val numer = x
	val denom = x
	
	def add(that: Rational) =
		new Rational(numer * that.numer + denom * that.denom, denom * that.denom)
  
  override def toString = numer + "/" + denom
}