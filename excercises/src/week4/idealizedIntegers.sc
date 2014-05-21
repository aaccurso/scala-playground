package week4

object integers {
	abstract class Nat {
		def isZero: Boolean
		def predecessor: Nat
		def successor: Nat = new Succ(this)
		def + (that: Nat): Nat
		def - (that: Nat): Nat
	}
	
	object Zero extends Nat {
		def isZero: Boolean = true
		def predecessor: Nat = throw new ZeroNat
		def + (that: Nat): Nat = that
		def - (that: Nat): Nat = if(that.isZero) this else throw new OnlyPositive
	}
	
	class Succ(n: Nat) extends Nat {
		def isZero: Boolean = false
		def predecessor: Nat = n
		def + (that: Nat): Nat = new Succ(predecessor + that)
		def - (that: Nat): Nat = if(that.isZero) this else predecessor - that.predecessor
	}
	
	class ZeroNat extends Exception
	class OnlyPositive extends Exception
	
	1 + 1                                     //> res0: Int(2) = 2
}