
    fun main() {
        var task: LeetCodeTasks = LeetCodeTasks()
        var tools: Tools = Tools()
        var algorithms : Algorithms = Algorithms()

        var array = tools.getArrayOfInts(20, 0, 101)
        array = tools.selectionSort(array)
        for (i in 0..array.size-1) {
            print("${array[i]} ")
        }
        println()
        print(algorithms.binarySearch(array, 6))
    }

