package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("times ['a', 'b']") {
    assert(times(List('a', 'a', 'b', 'b', 'a')) === List(('a', 3), ('b', 2)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
  
  test("makeOrderedLeafList for some large frequency table") {
    val chars = List('a', 'a', 'b', 'b', 'a', 'z', 'c', 'c', 'a', 'c')
    assert(makeOrderedLeafList(times(chars)) === List(Leaf('z',1), Leaf('b',2), Leaf('c',3), Leaf('a',4)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("combine of an even leaf list") {
    val leaflist = List(Leaf('x', 4), Leaf('a', 6))
    assert(combine(leaflist) === List(Fork(Leaf('x',4),Leaf('a',6),List('x', 'a'),10)))
  }
  
  test("combine of a Nil") {
    assert(combine(Nil) === Nil)
  }
  
  test("createCodeTree of t1 text should equal t1") {
    new TestTrees {
	    val text = "aabbb".toList
	    assert(createCodeTree(text) === t1)
    }
  }
  
  test("createCodeTree of t2 text should equal t2") {
    new TestTrees {
	    val text = "ababdbddd".toList
	    assert(createCodeTree(text) === t2)
    }
  }
  
  test("decode a very short text") {
    new TestTrees {
      assert(decode(t1, List(0, 1)) === "ab".toList)
    }
  }
  
  test("encode a very short text") {
    new TestTrees {
      assert(encode(t1)("ab".toList) === List(0, 1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("convert a CodeTree") {
    new TestTrees {
      assert(convert(t1) == List(('a', List(0)), ('b', List(1))))
      assert(convert(t2) == List(('a', List(0, 0)), ('b', List(0, 1)), ('d', List(1))))
    }
  }
  
  test("codeBits") {
    new TestTrees {
      val codeBits_t2 = codeBits(convert(t2))_
      assert(codeBits_t2('a') == List(0, 0))
      assert(codeBits_t2('b') == List(0, 1))
      assert(codeBits_t2('d') == List(1))
    }
  }
  
  test("quick encode and decode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
