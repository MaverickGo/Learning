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
    fun isVoted(listOfVoted: MutableMap<String, Int>, name: String): Boolean{
        if (listOfVoted[name] == 1) {
            println("Kick $name out!")
            return true
        } else {
            println("Let $name to vote")
            listOfVoted[name] = 1
            return false
        }
    }
    fun isPossibleToGet(start: Int, target: Int, graph: Map<Int, Array<Int>>): Boolean{
        var searchQueue: ArrayDeque<Int> = ArrayDeque<Int>(setOf(start))
        var checkedPoints: MutableMap<Int, Int> = mutableMapOf()
        var currNode: Int
        while (!searchQueue.isEmpty()) {
            currNode = searchQueue.first()
            searchQueue.removeFirst()
            if (!checkedPoints.contains(currNode)) {
                continue
            }
            if (currNode == target) {
                return true
            } else {
                checkedPoints[currNode] = 1
                graph[currNode]?.forEach{ searchQueue.add(it) }
            }
        }
        return false
    }
    fun distanceToPoint(start: Int, target: Int, graph: Map<Int, Array<Int>>): Int{
        var searchQueue: ArrayDeque<Int> = ArrayDeque<Int>(setOf(start))
        var pointsToCheck: MutableMap<Int, Int> = mutableMapOf(start to 0)
        var currNode: Int
        var distanceToCurr: Int
        while (!searchQueue.isEmpty()) {
            currNode = searchQueue.removeFirst()
            distanceToCurr = pointsToCheck[currNode]!!
            if (currNode == target) {
                return distanceToCurr
            }
            graph[currNode]?.forEach { neighbor ->
                if (!pointsToCheck.containsKey(neighbor)) {
                    pointsToCheck[neighbor] = distanceToCurr + 1
                    searchQueue.add(neighbor)
                }
            }
        }
        return -1
    }



    // код от ИИ
    fun findPath(start: Int, target: Int, graph: Map<Int, Array<Int>>): ListNode? {
        if (!graph.containsKey(start)) return null

        val queue = ArrayDeque<Int>()
        val parent = mutableMapOf<Int, Int>()   // parent[node] = предыдущий узел на пути
        val visited = mutableSetOf<Int>()

        queue.addLast(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            if (curr == target) {
                // Восстанавливаем путь в обратном порядке
                val path = mutableListOf<Int>()
                var node = target
                while (node != start) {
                    path.add(node)
                    node = parent[node]!!
                }
                path.add(start)
                // Переворачиваем: start → ... → target
                path.reverse()
                // Собираем ListNode‑список
                val head = ListNode(path[0])
                var current = head
                for (i in 1 until path.size) {
                    val nextNode = ListNode(path[i])
                    current.next = nextNode
                    current = nextNode
                }
                return head
            }
            graph[curr]?.forEach { neighbor ->
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    parent[neighbor] = curr
                    queue.addLast(neighbor)
                }
            }
        }
        return null   // путь не найден
    }
}