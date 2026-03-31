import kotlin.random.Random

class Tools {
    fun getArrayOfInts(size: Int, from: Int, until: Int): Array<Int> {
        var array: Array<Int> = Array(size) { 0 }
        for (i in 0..size-1) {
            array[i] = Random.nextInt(from, until)
        }
        return array
    }
    fun selectionSort(array: Array<Int>): Array<Int> {
        var temp: Int
        var min: Int
        var minIndex: Int

        for (i in 0..array.size-1) {
            min = array[i]
            minIndex = i
            for (j in i + 1..array.size-1) {
                if (array[j] < min) {
                    min = array[j]
                    minIndex = j
                }
            }
            temp = array[i]
            array[i] = min
            array[minIndex] = temp
        }
        return array
    }
}