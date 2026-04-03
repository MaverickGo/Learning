import kotlin.collections.lastIndex
import kotlin.collections.sliceArray

class Algorithms {
    fun binarySearch(array: Array<Int>, itemToFind: Int): Int? {
        var low: Int = 0
        var high: Int = array.size - 1
        var mid: Int
        while (low <= high) {
            mid = (low + high) / 2
            if (array[mid] == itemToFind) {
                return mid
            } else if (array[mid] < itemToFind) {
                low = mid + 1
            } else if (array[mid] > itemToFind) {
                high = mid - 1
            }
        }
        return null
    }
    fun factorial(number: Int): Int {
        if (number == 1) { return number }
        return number * factorial(number - 1)
    }
    fun euclidean_algorithm(a: Int, b: Int): Int {
        if (a > b) {
            if (a % b == 0) { return b }
            else { return euclidean_algorithm( a % b, b) }
        } else if (a < b) {
            if (b % a == 0) { return a }
            else { return euclidean_algorithm( a, b % a) }
        } else {
            return a
        }
    }
    fun arraySum(array: Array<Int>): Int {
        if ( array.size == 1 ) { return array[0] }
        else { return array[0] + arraySum(array.sliceArray(1..array.lastIndex)) }
    }
    fun arraySize(array: Array<Int>): Int{
        if (array.isEmpty()) { return 0 }
        else {
            return 1 + arraySize(array.sliceArray(1..array.lastIndex))
        }
    }
    fun maxInArray(array: Array<Int>): Int {
        if (array.size == 0) { return Int.MIN_VALUE }
        else {
            val max = maxInArray(array.sliceArray(1..array.lastIndex))
            if (array[0] > max) { return array[0] }
            else { return max }
        }
    }
    fun quickSort(array: Array<Int>): Array<Int> {
        if (array.size < 2) { return array }
        else {
            val pivot = array[0]
            val biggerThanPivot: Array<Int> = array.filter{it > pivot}.toTypedArray()
            val equals: Array<Int> = array.filter{it == pivot}.toTypedArray()
            val smallerThanPivot: Array<Int> = array.filter{it < pivot}.toTypedArray()
            return arrayOf(*quickSort(smallerThanPivot), *equals, *quickSort(biggerThanPivot))
        }
    }
}