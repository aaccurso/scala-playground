package forcomp

import Anagrams._

object maps2 {
  //val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
	//val r = List(('r', 1))
	
	//val subMap = (lard ::: r).groupBy(_._1)
	
	//subMap.mapValues(l => l.map(_._2).foldRight(0)(_-_)).filterNot(_._2 <= 0)
	//List("I", "love", "you").foldLeft("")(_+_)
	
	val occ = sentenceOccurrences(List("Linux", "rulez"))
                                                  //> occ  : forcomp.Anagrams.Occurrences = List((e,1), (i,1), (l,2), (n,1), (r,1)
                                                  //| , (u,2), (x,1), (z,1))
	sentenceOccurrences(List())               //> res0: forcomp.Anagrams.Occurrences = List()
	//sentenceAnagrams(List("I", "love", "you"))
}