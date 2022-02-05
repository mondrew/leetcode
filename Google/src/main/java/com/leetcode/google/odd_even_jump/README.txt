Odd Even Jump
--------------------------------------------- Task ----------------------------------------------------------------
You are given an integer array arr. From some starting index, you can make a series of jumps.
The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the
series are called even-numbered jumps. Note that the jumps are numbered, not the indices.

You may jump forward from index i to index j (with i < j) in the following way:
- During odd-numbered jumps (i.e., jumps 1, 3, 5, ...),
    you jump to the index j such that arr[i] <= arr[j] and arr[j] is the smallest possible value.
    If there are multiple such indices j, you can only jump to the smallest such index j.

- During even-numbered jumps (i.e., jumps 2, 4, 6, ...),
    you jump to the index j such that arr[i] >= arr[j] and arr[j] is the largest possible value.
    If there are multiple such indices j, you can only jump to the smallest such index j.

It may be the case that for some index i, there are no legal jumps.
A starting index is good if, starting from that index, you can reach the end of the array (index arr.length - 1)
by jumping some number of times (possibly 0 or more than once).
Return the number of good starting indices.

Example 1:
Input: arr = [10,13,12,14,15]
Output: 2
Explanation:
From starting index i = 0, we can make our 1st jump to i = 2 (since arr[2] is the smallest among arr[1], arr[2], arr[3], arr[4] that is greater or equal to arr[0]), then we cannot jump any more.
From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
From starting index i = 4, we have reached the end already.
In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of
jumps.

Example 2:
Input: arr = [2,3,1,1,4]
Output: 3
Explanation:
From starting index i = 0, we make jumps to i = 1, i = 2, i = 3:
During our 1st jump (odd-numbered), we first jump to i = 1 because arr[1] is the smallest value in [arr[1], arr[2], arr[3], arr[4]] that is greater than or equal to arr[0].
During our 2nd jump (even-numbered), we jump from i = 1 to i = 2 because arr[2] is the largest value in [arr[2], arr[3], arr[4]] that is less than or equal to arr[1]. arr[3] is also the largest value, but 2 is a smaller index, so we can only jump to i = 2 and not i = 3
During our 3rd jump (odd-numbered), we jump from i = 2 to i = 3 because arr[3] is the smallest value in [arr[3], arr[4]] that is greater than or equal to arr[2].
We can't jump from i = 3 to i = 4, so the starting index i = 0 is not good.
In a similar manner, we can deduce that:
From starting index i = 1, we jump to i = 4, so we reach the end.
From starting index i = 2, we jump to i = 3, and then we can't jump anymore.
From starting index i = 3, we jump to i = 4, so we reach the end.
From starting index i = 4, we are already at the end.
In total, there are 3 different starting indices i = 1, i = 3, and i = 4, where we can reach the end with some
number of jumps.

Example 3:
Input: arr = [5,1,3,4,2]
Output: 3
Explanation: We can reach the end from starting indices 1, 2, and 4.

Constraints:
1 <= arr.length <= 2 * 10^4
0 <= arr[i] < 10^5

------------------------------------------- Solution explanation -----------------------------------------------
The goal is to find number of good indices. Good index is an index from which we can reach the end of the array.
We need to jump higher and lower alternately to the end.
For any index every first jump is ODD-HIGHER jump.

Let's start from the end of the array.

Example array:
Indices <0 1 2 3 4>
         | | | | |
Array   [5,1,3,4,2]
We will check the possibility of higher-jump (odd) AND lower jump (even) for EVERY index (because we will start from
the last index and will go to the beginning).
Syntax:
    'higher(2) = true' means that for element 2 (4th index) exists higher (odd) jump;
    'lower(2) = true' means that for element 2 (4th index) exists lower (even) jump;
Hence we need to search possibilities for higher(odd) or lower(even) jump only in the right part of array,
we will create TreeMap, where we will put elements from the array starting from the last one.
For the last element of the array we ALWAYS have higher(odd) and lower(even) jump.
In other words - the last index is always good. We don't need to jump anywhere,
because we're already at the last element.
Resume for all elements:
- If we start at 2:
    we can jump higher first,   higher(2) = true
    we can jump lower first,    lower(2) = true
- If we start at 4:
    we can't jump higher,       higher(4) = false
    we can jump lower to 2,     lower(4) = higher(2) = true (higher(2) because we're doing lower jump from 4 elem).
- If we start at 3:
    we can jump higher to 4,    higher(3) = lower(4) = true
    we can jump lower to 2,     lower(3) = higher(2) = true
- If we start at 1:
    we can jump higher to 2,    higher(1) = lower(2) = true
    we can't jump lower,        lower(1) = false
- If we start at 5:
    we can't jump higher,       higher(5) = false
    we can jump lower to 4,     lower(5) = higher(4) = false

Complexity
Time O(NlogN)
Space O(N)

/**
 * @param higher array with existence of higher(odd) jump for all elements of the initial array
 * @param lower array with existence of lower(even) jump for all elements of the initial array
 * @param map TreeMap with element-index Entries. The first element will be (2, 4): element 2, index 4.
*/
The last element in both 'higher' and 'lower' arrays is always 'true'.
In the loop we are moving from the second last to the first array element.

TreeMap.ceilingEntry(K Key) : Returns a key-value mapping associated with the least key greater than or equal to the
    given key, or null if there is no such key.
TreeMap.floorEntry(K Key) : Returns a key-value mapping associated with the greatest key less than or equal to the
    given key, or null if there is no such key.

We are searching in the map (where we store all elements for the end of initial array) hi-Entry and lo-Entry for
every element of the array.

if (hi != null) {
    higher[i] = lower[hi.getValue()];
}
If the higher(odd) jump (hi) from the current element exists -> then we add to the boolean-higher(odd)-jumps array 'higher'
the value from the lower(even) jump array at the index 'hi.getValue()' (because we just found it).
If the next jump after current higher jump exists (it will be definitely lower jump) -> then we just copy 'false' from
the 'lower' array, cause there is no way that these jumps (even if the current element is not the first) - has NO sense.
But if the lower(even) jump after current higher jump exists -> then we copy 'true' value for that index.

The same situation is with lower jumps: if the lower jump exists -> then we must check

After that we always check the higher jump array value at the current index. Because the very first jump is always odd(higher).
If it is true - then for that index exists the route to the end element. And we are sure that all other jumps (odds and evens)
will be true if we will start from that index, 'cause we are going from the end to the beginning of the initial array.

After last check - we put the current element and it's index to the map and go to the next loop iteration.