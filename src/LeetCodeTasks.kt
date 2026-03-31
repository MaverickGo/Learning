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


}