def mapFun[T, U](xs: List[T], f: T => U): List[U] = (xs foldRight List[U]())(f(_) :: _)

def lengthFun[T](xs: List[T]): Int = (xs foldRight 0)((a, b) => 1 + b)


val list = 1 to 100 toList

mapFun[Int, Int](list, x => x * 2)
lengthFun[Int](list)