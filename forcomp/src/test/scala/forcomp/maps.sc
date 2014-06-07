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
}