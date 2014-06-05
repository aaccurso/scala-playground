package week6

object mapsPlayground {
  val word = "Scala Alan"                         //> word  : String = Scala Alan
  val occurrences = word.toList.groupBy(_.charValue().toLower)
                                                  //> occurrences  : scala.collection.immutable.Map[Char,List[Char]] = Map(s -> Li
                                                  //| st(S), n -> List(n), a -> List(a, a, A, a),   -> List( ), l -> List(l, l), c
                                                  //|  -> List(c))
  (for (o <- occurrences) yield (o._1, o._2.length)).toList.sortBy(_._2)
                                                  //> res0: List[(Char, Int)] = List((s,1), (n,1), ( ,1), (c,1), (l,2), (a,4))
  
}