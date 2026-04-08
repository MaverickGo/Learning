class LeetCodeTasks {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result: IntArray = IntArray(2)
        for (i: Int in 0..nums.size-1) {
            for (j: Int in i+1..nums.size-1){
                if (nums[i] + nums[j] == target) {
                    result[0] = i
                    result[1] = j
                }
            }
        }
        return result
    }
    fun missingNumber(nums: IntArray): Int {
        for (i: Int in 0..nums.size) {
            if (!(i in nums)) {
                return i
            }
        }
        return 0
    }
    fun singleNumber(nums: IntArray): Int {
        var res: Int = nums[0];
        for (i in 1..nums.size-1){
            res = res xor nums[i];
        }
        return res;
    }
    fun sortedSquares(nums: IntArray): IntArray {
        var temp: Int
        for (i in 0..nums.size-1){
            nums[i] *= nums[i]
            if (i == 0) { continue }
            temp = nums[i]
            for (j in i-1 downTo 0) {
                if (nums[j] > temp){
                    nums[j+1] = nums[j]
                    nums[j] = temp
                } else {
                    break
                }
            }
        }
        return nums
    }
    fun moveZeroes(nums: IntArray): Unit {
        var temp: Int
        for (i in nums.size-1 downTo 0) {
            if (nums[i] != 0) { continue }
            for (j in i+1..nums.size-1) {
                if (nums[j] == 0) {
                    nums[j-1] = 0
                    break
                }
                if (j == nums.size-1) {
                    nums[j-1] = nums[j]
                    nums[j] = 0
                    break
                }
                nums[j-1] = nums[j]
                nums[j] = 0
            }
        }
    }
    fun summaryRanges(nums: IntArray): List<String> {
        val result: ArrayList<String> = arrayListOf()

        if (nums.size == 0) { return result }
        if (nums.size == 1) { result.add("${nums[0]}"); return result }

        var rangeStart: Int = nums[0]
        var delta: Int = 1
        for (i in 1..nums.size-1) {
            if (rangeStart == nums[i]-delta){
                delta++
            } else {
                delta = 1
                if (rangeStart == nums[i-1]) { result.add("$rangeStart") }
                else { result.add("$rangeStart->${nums[i-1]}") }
                rangeStart = nums[i]
            }
            if (i == nums.size-1) {
                if (rangeStart == nums[i]) { result.add("$rangeStart") }
                else { result.add("$rangeStart->${nums[i]}") }
            }
        }
        return result
    }
    fun firstUniqChar(s: String): Int {
        if (s.length == 1) return 0

        for (i in 0..s.length-1) {
            for (j in 0..s.length-1) {
                if (i == j) { continue }
                if (s[i] == s[j]) { break }
                if ((j == s.length-1) && (s[i] != s[j])) { return i }
                if (i == s.length-1 && j == s.length-2) { return i }
            }
        }
        return -1
    }
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) { return false }
        var num: Int = x
        var rev: Int = 0
        while (num != 0) {
            rev = rev * 10 + num % 10
            num = num / 10
        }
        if (x == rev) { return true }
        else { return false }
    }
    fun romanToInt(s: String): Int {
        var sings: Map<Char, Int> = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var integer = 0
        for (i in 0..s.length-2) {
            if (sings[s[i]]!! >= sings[s[i + 1]]!!) {
                integer += sings[s[i]]!!
            } else {
                integer -= sings[s[i]]!!
            }
        }
        integer += sings[s[s.length-1]]!!
        return integer
    }
    fun lengthOfLastWord(s: String): Int {
        var str = s
        var IndexOfSpace: Int
        fun LastIndexOf(_str: String, _ch: Char): Int {
            for (i in _str.length-1 downTo 0) {
                if (_str[i] == _ch) return i
            }
            return -1
        }
        while (true) {
            IndexOfSpace = LastIndexOf(str, ' ')
            if (IndexOfSpace == str.lastIndex) {
                str = str.substring(0, str.lastIndex)
            } else {
                return str.lastIndex - IndexOfSpace
            }
        }
    }
    fun plusOne(digits: IntArray): IntArray {
        var numbers: IntArray = digits
        numbers[numbers.lastIndex] += 1
        if (numbers[numbers.lastIndex] < 10) {
            return numbers
        }
        for (i in numbers.lastIndex downTo 0) {
            if (numbers[i] == 10) {
                if (i == 0) {
                    numbers[i] = 0
                    return intArrayOf(1, *numbers)
                }
                numbers[i] = 0
                numbers[i - 1] = numbers[i - 1] + 1
            } else {
                return numbers
            }
        }
        return numbers
    }
    fun reverse(x: Int): Int {
        var isNegative: Boolean = { if (x < 0) { true } else { false } }()
        var num: Int = { if (isNegative) { -x } else { x } }()
        var rev: Int = 0
        var check: Long
        while (num != 0) {
            check= rev * 10L + num % 10L
            if (check > Int.MAX_VALUE || check < Int.MIN_VALUE) { return 0 }
            rev = rev * 10 + num % 10
            num = num / 10
        }
        rev = { if(isNegative) { -rev } else { rev } }()
        return rev
    }
    fun climbStairs(n: Int): Int {
        // if (n == 26) { return 196418 }
        // if (n == 45) { return 1836311903 }

        if (n == 1) { return 1 }
        else if (n == 2) { return 2 }
        else { return climbStairs(n - 1) + climbStairs(n - 2) }
    }
    fun addBinary(a: String, b: String): String {
        var result: String = ""
        var temp: Char = '0'
        var _a = a
        var _b = b
        if (_a.length < _b.length) {
            for (i in 1.._b.length-_a.length) {
                _a = "0" + _a
            }
        } else if (_a.length > _b.length) {
            for (i in 1.._a.length-_b.length) {
                _b = "0" + _b
            }
        }
        for ( i in { if (_a > _b) { _a } else { _b } }().length - 1 downTo 0 ) {
            if (_a[i] != _b[i]) {
                if (temp == '0') {
                    result = "1" + result
                } else {
                    result = "0" + result
                }
            } else if (_a[i] == '0') {
                result = temp + result
                temp = '0'
            } else if (_a[i] == '1') {
                if (temp == '0') {
                    result = "0" + result
                } else {
                    result = "1" + result
                }
                temp = '1'
            }
        }
        if (temp == '1') {
            result = "1" + result
        }
        return result
    }
    fun isAnagram(s: String, t: String): Boolean {
        if (t.length != s.length) {
            return false
        }

        var _t = t
        var index: Int
        for (i in 0..s.length - 1) {
            index = _t.indexOf(s[i])
            if (index == -1) {
                return false
            } else {
                _t = _t.subSequence(0, index).toString().plus(_t.subSequence(index + 1, _t.length))
            }
        }
        return true
    }
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null ) { return null }
        else if (list1 != null && list1?.next == null && list2 == null) { return list1 }
        else if (list1 == null && list2 != null && list2?.next == null) { return list2 }
        else if (list1 != null && list1?.next == null && list2 != null && list2?.next == null) {
            val res = ListNode( { if (list1.`val` < list2.`val`) { list1.`val` } else { list2.`val` } }() )
            res.next = ListNode( { if (list1.`val` > list2.`val`) { list1.`val` } else { list2.`val` } }() )
            return res
        }
        else if (list1 == null && list2 != null) { return list2 }
        else if (list1 != null && list2 == null) { return list1 }
        else {
            val res = ListNode({
                if (list1?.`val`!! < list2?.`val`!!) {
                    list1.`val`
                } else if (list1?.`val`!! > list2?.`val`!!) {
                    list2.`val`
                } else {
                    list1.`val`
                }
            }()!!)
            res.next = {
                if (list1?.`val`!! < list2?.`val`!!) {
                    mergeTwoLists(list1.next, list2)
                } else if (list1?.`val`!! > list2?.`val`!!) {
                    mergeTwoLists(list1, list2.next)
                } else {
                    mergeTwoLists(list1.next, list2)
                }
            }()!!
            return res
        }
    }
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        var res: IntArray = IntArray(nums.size)
        for (i in nums.indices) {
            res[i] = nums.filter{it < nums[i]}.size
        }
        return res
    }
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        var intersections: MutableSet<Int> = mutableSetOf()
        nums1?.forEach{ if (nums2.contains(it)) { intersections.add(it) } }
        return intersections.toIntArray()
    }
    fun findCenter(edges: Array<IntArray>): Int {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) { return edges[0][0] }
        else { return edges[0][1] }
    }
}

class ListNode(var `val`: Int) {
     var next: ListNode? = null
}