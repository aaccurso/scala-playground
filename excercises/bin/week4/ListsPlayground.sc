package week4

object ListsPlayground {
  val l = List(('c', 4))                          //> l  : List[(Char, Int)] = List((c,4))
  val n = ('a',2)::('b',3)::l                     //> n  : List[(Char, Int)] = List((a,2), (b,3), (c,4))
  n.take(0)                                       //> res0: List[(Char, Int)] = List()
  List(1).drop(1)                                 //> res1: List[Int] = List()
  
  def match_pair(pair: (Char, Int), char_to_match: Char): Boolean = pair match {
  	case (char, int) => char == char_to_match
  }                                               //> match_pair: (pair: (Char, Int), char_to_match: Char)Boolean
  
  val pair = n.find((pair) => match_pair(pair, 'b')).head
                                                  //> pair  : (Char, Int) = (b,3)
  n.find((pair) => match_pair(pair, 'b')).isDefined
                                                  //> res2: Boolean = true
  val index = n.indexOf(pair)                     //> index  : Int = 1
  n take index                                    //> res3: List[(Char, Int)] = List((a,2))
  n drop index + 1                                //> res4: List[(Char, Int)] = List((c,4))
  (pair._1, pair._2 + 1) :: n.take(index) ::: n.drop(index + 1)
                                                  //> res5: List[(Char, Int)] = List((b,4), (a,2), (c,4))
	n.find((pair) => match_pair(pair, 'z')).isDefined
                                                  //> res6: Boolean = false
}