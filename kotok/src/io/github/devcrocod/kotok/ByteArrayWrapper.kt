package io.github.devcrocod.kotok

public class ByteArrayWrapper(private val array: ByteArray) {

    public val size: Int
        get() = array.size

    public fun getBytesBetween(start: Int, end: Int): ByteArrayWrapper {
        when {
            start < 0 || start >= array.size -> throw IndexOutOfBoundsException("Start index out of bounds: $start")
            end < 0 || end > array.size -> throw IndexOutOfBoundsException("End index out of bounds: $start")
            start >= end -> throw IndexOutOfBoundsException("Start index must be less than end index: $start >= $end")
        }

        val length = end - start
        val result = ByteArray(length)
        array.copyInto(result, 0, start, end)
        return ByteArrayWrapper(result)
    }

    public override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other !is ByteArrayWrapper || size != other.size -> false
            else -> array.contentEquals(other.array)
        }
    }

    public override fun hashCode(): Int {
        return array.contentHashCode()
    }

    override fun toString(): String {
        return array.contentToString()
    }
}