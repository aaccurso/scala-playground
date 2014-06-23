package streams

import Bloxorz._

object BloxorzPlayground {
	val level = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
                                                  //> level  : scala.collection.immutable.Vector[scala.collection.immutable.Vector
                                                  //| [Char]] = Vector(Vector(S, T), Vector(o, o), Vector(o, o))
	level.indices.contains(3)                 //> res0: Boolean = false
	level(1).indexOf('a')                     //> res1: Int = -1
	
}