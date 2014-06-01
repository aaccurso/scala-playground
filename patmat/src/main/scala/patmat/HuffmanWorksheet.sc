package patmat

import Huffman._

object HuffmanWorksheet {
	val chars = List('a', 'a', 'b', 'b', 'a', 'z', 'c', 'c', 'f', 'o')
                                                  //> chars  : List[Char] = List(a, a, b, b, a, z, c, c, f, o)
  val chars_times = times(chars)                  //> chars_times  : List[(Char, Int)] = List((a,3), (b,2), (z,1), (c,2), (f,1), (
                                                  //| o,1))
  makeOrderedLeafList(chars_times)                //> res0: List[patmat.Huffman.Leaf] = List(Leaf(o,1), Leaf(f,1), Leaf(z,1), Leaf
                                                  //| (c,2), Leaf(b,2), Leaf(a,3))
  
  combine(
  	makeOrderedLeafList(
  		chars_times
  	)
  )                                               //> res1: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(o,1),Leaf(f,1),List(o, 
                                                  //| f),2), Leaf(z,1), Leaf(c,2), Leaf(b,2), Leaf(a,3))
  
  until(singleton, combine)(makeOrderedLeafList(chars_times))
                                                  //> res2: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Fork(Leaf(o,1),Leaf(f,1)
                                                  //| ,List(o, f),2),Leaf(z,1),List(o, f, z),3),Leaf(c,2),List(o, f, z, c),5),Leaf
                                                  //| (b,2),List(o, f, z, c, b),7),Leaf(a,3),List(o, f, z, c, b, a),10)
  createCodeTree(chars)                           //> res3: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Fork(Leaf(o,1),Leaf(f,1)
                                                  //| ,List(o, f),2),Leaf(z,1),List(o, f, z),3),Leaf(c,2),List(o, f, z, c),5),Leaf
                                                  //| (b,2),List(o, f, z, c, b),7),Leaf(a,3),List(o, f, z, c, b, a),10)
  createCodeTree(List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
                                                  //> res4: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Fork(Fork(Fork(Fork(Fork
                                                  //| (Fork(Fork(Leaf(l,1),Leaf(c,1),List(l, c),2),Leaf(t,1),List(l, c, t),3),Leaf
                                                  //| (s,1),List(l, c, t, s),4),Leaf(e,1),List(l, c, t, s, e),5),Leaf(n,1),List(l,
                                                  //|  c, t, s, e, n),6),Leaf(a,1),List(l, c, t, s, e, n, a),7),Leaf(m,1),List(l, 
                                                  //| c, t, s, e, n, a, m),8),Leaf(u,1),List(l, c, t, s, e, n, a, m, u),9),Leaf(h,
                                                  //| 1),List(l, c, t, s, e, n, a, m, u, h),10),Leaf(o,2),List(l, c, t, s, e, n, a
                                                  //| , m, u, h, o),12),Leaf(f,2),List(l, c, t, s, e, n, a, m, u, h, o, f),14)
  
  decodedSecret                                   //> res5: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  val tree = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
                                                  //> tree  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  convert(tree)                                   //> res6: patmat.Huffman.CodeTable = List((a,List(0)), (a,List(1)))
}