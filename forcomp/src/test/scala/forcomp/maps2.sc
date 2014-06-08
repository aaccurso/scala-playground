package forcomp

object maps2 {
  val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
	val r = List(('r', 1))                    //> r  : List[(Char, Int)] = List((r,1))
	
	lard.head                                 //> res0: (Char, Int) = (a,1)
	lard.tail.head                            //> res1: (Char, Int) = (d,1)
	
	val subMap = (lard ::: r).groupBy(_._1)   //> subMap  : scala.collection.immutable.Map[Char,List[(Char, Int)]] = Map(d -> 
                                                  //| List((d,1)), a -> List((a,1)), r -> List((r,1), (r,1)), l -> List((l,1)))
	
	subMap.mapValues(l => l.map(_._2).foldRight(0)(_-_)).filterNot(_._2 <= 0)
                                                  //> res2: scala.collection.immutable.Map[Char,Int] = Map(d -> 1, a -> 1, l -> 1)
                                                  //| 
}