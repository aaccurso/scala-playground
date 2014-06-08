package forcomp
import Anagrams._

object maps {
  val s = List("aaasddd", "Scala")                //> s  : List[String] = List(aaasddd, Scala)
  val char_map = (for(word <- s) yield wordOccurrences(word)).flatten.groupBy(_._1)
                                                  //> char_map  : scala.collection.immutable.Map[Char,List[(Char, Int)]] = Map(s -
                                                  //| > List((s,1), (s,1)), a -> List((a,3), (a,2)), l -> List((l,1)), c -> List((
                                                  //| c,1)), d -> List((d,3)))
  (for(c <- char_map; o <- c._2) yield (c._1, o._2)).toList.sorted
                                                  //> res0: List[(Char, Int)] = List((a,2), (c,1), (d,3), (l,1), (s,1))
	List("a", "b").foldRight("")(_+_)         //> res1: String = ab
	char_map.get('a')                         //> res2: Option[List[(Char, Int)]] = Some(List((a,3), (a,2)))
	char_map.get('z')                         //> res3: Option[List[(Char, Int)]] = None
	char_map.apply('a')                       //> res4: List[(Char, Int)] = List((a,3), (a,2))
	
	val occur = List(('a', 2), ('b', 2))      //> occur  : List[(Char, Int)] = List((a,2), (b,2))
	
	(for {
		o <- occur
		r <- 1 until o._2 + 1
	} yield (o._1, r))
	.groupBy(_._1)                            //> res5: scala.collection.immutable.Map[Char,List[(Char, Int)]] = Map(b -> List
                                                  //| ((b,1), (b,2)), a -> List((a,1), (a,2)))
	
	for {
		o <- occur
		o2 <- occur if o2._1 != o._1
		r <- 1 until o._2 + 1
		r2 <- 1 until o2._2 + 1
	} yield List((o._1, r), (o2._1, r2))      //> res6: List[List[(Char, Int)]] = List(List((a,1), (b,1)), List((a,1), (b,2)),
                                                  //|  List((a,2), (b,1)), List((a,2), (b,2)), List((b,1), (a,1)), List((b,1), (a,
                                                  //| 2)), List((b,2), (a,1)), List((b,2), (a,2)))
  List(('a', 1)) ::: List(('b', 2))               //> res7: List[(Char, Int)] = List((a,1), (b,2))
  val o = ('a', 1)                                //> o  : (Char, Int) = (a,1)
  (for(r <- 1 until o._2 + 1) yield (o._1, r)).toList
                                                  //> res8: List[(Char, Int)] = List((a,1))
	
	combinations(List(('a',2), ('b',2)))      //> res9: List[forcomp.Anagrams.Occurrences] = List(List(), List((b,1)), List((b
                                                  //| ,2)), List((a,1)), List((a,1), (b,1)), List((a,1), (b,2)), List((a,2)), List
                                                  //| ((a,2), (b,1)), List((a,2), (b,2)))
	
}