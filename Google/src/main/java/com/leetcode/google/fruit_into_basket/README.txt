Fruit into Basket
---------------------------------------------- Task -----------------------------------------------------------------
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by
an integer array fruits where fruits[i] is the type of fruit the i-th tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of
fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Example 2:
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Example 3:
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].


Constraints:
1 <= fruits.length <= 10^5
0 <= fruits[i] < fruits.length

----------------------------------------------------- Solution ---------------------------------------------------------
Translation
Find out the longest length of subarrays with at most 2 different numbers?

Solution of sliding window will be easier to understand.
Here I share another solution wihtout hash map.
Hope it's not damn hard to understand.

Explanation:
Loop all fruit c in tree,
Note that a and b are the last two different types of fruit that we met,
c is the current fruit type,
so it's something like "....aaabbbc..."

- Case 1 (c == b):
fruit c already in the basket,
and it's same as the last type of fruit
cur += 1
count_b += 1

- Case 2 (c == a):
fruit c already in the basket,
but it's not same as the last type of fruit
cur += 1
count_b = 1
a = b, b = c

- Case 3 (c != b && c!= a):
fruit c not in the basket,
cur = count_b + 1
count_b = 1
a = b, b = c

Of course, in each turn we need to update res = max(res, cur)

Complexity:
Time: O(N)
Space: O(1)