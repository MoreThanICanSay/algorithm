
##树
>树是n个节点的有限集合，有且仅有一个特定的称为根的节点。
>当n>1时，其余节点可以互分为m个不相交的有限集，每一个集合本身又是一个树，并称为根的节点

###二叉树
>二叉树是树的一种特殊形式，每一个节点最多有两个孩子节点。
>二叉树包含完全二叉树和满二叉树两种特殊形式

###二叉树的遍历方式有几种
>根据遍历节点之间的关系，可以分为前序遍历、中序遍历、后序遍历、层序遍历这四种方式；
>从宏观角度划分，可以划分为说深度遍历和广度优先遍历两大类

###二叉堆
>二叉堆是一种特殊的完全二叉树，分为最大堆和最小堆
>在最大堆中，任何一个父节点的值，都大于或等于它左右孩子节点的值
>在最小堆中，任何一个父节点的值，都小于或等于它左右孩子节点的值

###优先队列
>优先队列分为最大优先队列和最小优先队列
>在最大优先队列中，无论入队顺序如何，最大元素都会优先出队列，基于最大堆实现的。
>在最小优先队列中，无论入队顺序如何，最小元素都会优先出队列，基于最小堆实现的。

##排序
>时间复杂度为o(n^2)的排序算法
>
1. 冒泡排序
2. 选择排序
3. 插入排序
4. 希尔排序（特殊，性能略优于o(n^2)，但有比不上o(nlogn））
>时间复杂度为o(nlogn）
1. 快速排序
2. 归并排序
3. 堆排序
>时间复杂度为线性的排序算法
1. 计数排序
2. 桶排序
3. 基数排序