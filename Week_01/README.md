HashTable
哈希表（Hash table），也叫散列表，是根据关键码值（key value）而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来保存访问记录，以加快查找的速度。这个映射函数叫做散列函数（Hash Function），存放记录的数组叫做哈希表（或散列表）。

哈希表的底层是数组+链表的形式存放数据的，任何一个数据或者对象都是通过哈希函数进行计算，得到一个下标，根据得到的下标找到数组的对应位置进行存放。在java中有一个hashcode()的方法，可以重写这个方法使用自己的计算方式。当不同的数据经过哈希函数计算得到的数值相同，即下标相同的话就会发生我们所说的哈希碰撞，发生哈希碰撞以后的数据会以链表的形式连接在同一个数组位置上。哈希表在不发生哈希碰撞的情况下,查找的时间复杂度是O(1)，但是如果发生哈希碰撞的数据很多，链表很长的话查找的效率就会退化，甚至可以到达O(n)级别，平均情况下我们可以认为哈希表的查找时间复杂度是O(1)的。

常见的哈希表有Map和Set：

Map：key-value对，key不重复

-new HashMap()/new TreeMap()

-map.put(key,value)

-map.get(key)

-map.has(key)

-map.size()

-map.clear()

Set：不重复元素的集合

-new HashSet()/new TreeSet()

-set.add(value)

-set.delete(value)

-set.hash(value)

HashMap
public class HashMap extends AbstractMap implements Map

HashMap 实现了接口 Map，以及接口中的方法。我们来看一下Map中的方法：


HashMap 中定义了一个静态内部类 Node，里面存放了hash值，key值，value，next指针。


计算hash值的方法：

static final int hash(Object key) {

int h;

    return (key ==null) ?0 : (h = key.hashCode()) ^ (h >>>16);

}

HashMap的构造方法有4个：不传参、传一个Map、传初始化容量值、传初始容量值和加载因子。

1.给定一个初始加载因子，默认为0.75；


2.


3.传入指定的初始容量，程序会指定默认的加载因子为0.75


4.先判断传入的初始容量是否合法，如果非法则抛出异常，合法则设置为阈值，将传入的加载因子覆盖默认的加载因子。


get()方法：


get方法传入key值，然后根据当前key值计算其hash值，当第一个table表中数据的key值和hash值都相同的时候返回第一个数据，如果不满足而且链表后面有数据则根据链表指向依次判断key值和hash值是否相等，直到找到相同的节点则返回该节点中的value值。


判断hash表中是否包含需要查找的key值，同样根据key值和key值对应的hash值进行判断，如果能够找到则返回true，否则返回false。

put(）方法：





remove()方法：







根据key值计算其hash值并返回对应的Node节点，并删除在hash表中的该节点，remove方法返回该节点对应的value值。


当remove方法中同时传入key和value值的时候通过计算需要删除节点的Node节点，进行删除并判断是否为null来返回是否删除成功。