package streams

import Bloxorz._

object BloxorzPlayground {
	val level = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
                                                  //> level  : scala.collection.immutable.Vector[scala.collection.immutable.Vector
                                                  //| [Char]] = Vector(Vector(S, T), Vector(o, o), Vector(o, o))
	level.indices.contains(3)                 //> res0: Boolean = false
	level(1).indexOf('a')                     //> res1: Int = -1
	Nil.head                                  //> java.util.NoSuchElementException: head of empty list
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:337)
                                                  //| 	at streams.BloxorzPlayground$$anonfun$main$1.apply$mcV$sp(streams.Bloxor
                                                  //| zPlayground.scala:9)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at streams.BloxorzPlayground$.main(streams.BloxorzPlayground.scala:5)
                                                  //| 	at streams.BloxorzPlayground.main(streams.BloxorzPlayground.scala)
}