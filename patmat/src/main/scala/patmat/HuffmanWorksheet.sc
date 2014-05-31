package patmat

object HuffmanWorksheet {
	val chars = List('a', 'a', 'b', 'b', 'a', 'z', 'c', 'c', 'f', 'o')
                                                  //> chars  : List[Char] = List(a, a, b, b, a, z, c, c, f, o)
  val times = Huffman.times(chars)                //> times  : List[(Char, Int)] = List((a,3), (b,2), (z,1), (c,2), (f,1), (o,1))
  Huffman.combine(
  	Huffman.makeOrderedLeafList(
  		times
  	)
  )                                               //> res0: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(z,1),Leaf(b,2),List(z, 
                                                  //| b),3), Leaf(a,3), Leaf(c,2), Leaf(f,1), Leaf(o,1))
  
  Huffman.until(Huffman.singleton, Huffman.combine)(Huffman.makeOrderedLeafList(times))
                                                  //> res1: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Fork(Leaf(z,1),Leaf(b,2)
                                                  //| ,List(z, b),3),Leaf(a,3),List(z, b, a),6),Leaf(c,2),List(z, b, a, c),8),Leaf
                                                  //| (f,1),List(z, b, a, c, f),9),Leaf(o,1),List(z, b, a, c, f, o),10)
  Huffman.createCodeTree(chars)                   //> res2: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Fork(Leaf(z,1),Leaf(b,2)
                                                  //| ,List(z, b),3),Leaf(a,3),List(z, b, a),6),Leaf(c,2),List(z, b, a, c),8),Leaf
                                                  //| (f,1),List(z, b, a, c, f),9),Leaf(o,1),List(z, b, a, c, f, o),10)
  
  Huffman.decodedSecret                           //> res3: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
}