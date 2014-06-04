package week6

object polynomials {
  class Poly(terms0: Map[Int, Double]) {
  	val terms = terms0 withDefaultValue(0.0)
  	def this(pairs: (Int, Double)*) = this(pairs.toMap)
  	def + (other: Poly): Poly = new Poly((other.terms foldLeft terms)(addTerm))
  	def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
  		val (exp, coeff) = term
  		terms + (exp -> (coeff + terms(exp)))
  	}
  	override def toString() =
  		(for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "X^" + exp) mkString " + "
  }
  
  val pol1 = new Poly(2 -> 2.2, 1 -> 3)           //> pol1  : week6.polynomials.Poly = 2.2X^2 + 3.0X^1
  val pol2 = new Poly(4 -> 2, 2 -> 3)             //> pol2  : week6.polynomials.Poly = 2.0X^4 + 3.0X^2
  pol1 + pol2                                     //> res0: week6.polynomials.Poly = 2.0X^4 + 5.2X^2 + 3.0X^1
}