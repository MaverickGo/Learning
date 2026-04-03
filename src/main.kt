
    fun main() {
        val tasks: LeetCodeTasks = LeetCodeTasks()
        val tools: Tools = Tools()
        val algorithms : Algorithms = Algorithms()

        //println(algorithms.maxInArray( arrayOf(0, 12, 1, 2, 3, 4, 5, 6) ))
        // arrayOf(0, 1, 2, 3, 4, 5, 6)

        val usortedArray = tools.getArrayOfInts(500, 0, 2000)
        println(usortedArray.contentToString())
        val sortedArray = algorithms.quickSort(usortedArray)
        println(sortedArray.contentToString())

    }

