package flatten

trait Part09 {

  // Most well-known typeclasses in Play are the ones for JSON: Reads, Writes and Format
  // Play provides some `instances` of them: Format[String], Reads[DateTime], etc.
  // You can define `instances` of these type classes for your own classes.

  // Exercise: without looking at the previous part, create a type class `Serializable`, a function `toBytes` that impicitly uses this
  // typeclass, and instances for `Int` and `String`.
  trait Serializable[A] {
    def serialize(value: A): Array[Byte]
  }

  def toBytes[A:Serializable](a: A): Array[Byte] = implicitly[Serializable[A]].serialize(a)

  implicit object MyIntSerializable extends Serializable[Int] {
    override def serialize(value: Int): Array[Byte] = value.toString.getBytes
  }

  implicit object MyStringSerializable extends Serializable[String] {
    override def serialize(value: String): Array[Byte] = value.getBytes
  }

}