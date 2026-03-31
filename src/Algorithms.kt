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
}