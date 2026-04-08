
    fun main() {
        val tasks: LeetCodeTasks = LeetCodeTasks()
        val tools: Tools = Tools()
        val algorithms : Algorithms = Algorithms()

        //println(algorithms.maxInArray( arrayOf(0, 12, 1, 2, 3, 4, 5, 6) ))
        // arrayOf(0, 1, 2, 3, 4, 5, 6)

//        val usortedArray = tools.getArrayOfInts(500, 0, 2000)
//        println(usortedArray.contentToString())
//        val sortedArray = algorithms.quickSort(usortedArray)
//        println(sortedArray.contentToString())

//        print(tasks.isAnagram("aacc", "ccac"))

//        var index = 0
//        var t = "012345"
//        t = t.subSequence(0, index).toString().plus(t.subSequence(index + 1, t.length))
//        //t = t.subSequence(0, t.length).toString()
//        print(t)

//        var list: MutableMap<String, Int> = mutableMapOf()
//        algorithms.isVoted(list, "Mike")
//        algorithms.isVoted(list, "Alex")
//        algorithms.isVoted(list, "Kate")
//        algorithms.isVoted(list, "Alex")

//        var numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
//        var smallerThanCurr = tasks.smallerNumbersThanCurrent(numbers)
//        for (i in smallerThanCurr.indices) {
//            println(smallerThanCurr[i])
//        }

        var graph: Map<Int, Array<Int>> = mapOf(
            1 to arrayOf(2, 3, 4),
            2 to arrayOf(1, 5, 6),
            3 to arrayOf(1, 7),
            4 to arrayOf(1, 8, 9),
            5 to arrayOf(2, 8),
            6 to arrayOf(2, 7),
            7 to arrayOf(3, 6, 9),
            8 to arrayOf(4, 5),
            9 to arrayOf(4, 7),
            10 to arrayOf()
        )
        print(algorithms.distanceToPoint(11, 1, graph))

    }

