
1.Queue源码的分析
public interface Queue extends Collection，Queue是一个继承了Collection的接口，里面只有简单的几个方法待实现它的类去实现：

boolean add(E e);

boolean offer(E e);

E remove();

E poll();

E element();

E peek();

里面的方法add()和offer()都是添加元素到队列中; remove()和poll()方法是移除最头部的元素，区别是如果队列为空，remove方法会抛出NoSuchElementException，poll()方法则返回null；element() 和peek()方法返回队列头部的方法但不删除，区别是如果队列为空，element方法会抛出NoSuchElementException，peek()方法则返回null。
2.和Priority Queue源码的分析
public class PriorityQueue extends AbstractQueue implements java.io.Serializable

public abstract class AbstractQueue extends AbstractCollection implements Queue

PriorityQueue  继承 AbstractQueue   实现  Queue ，因此也实现 Queue 的6个方法。确切地说是5个方法，element()方法在 AbstractQueue  中进行了实现，在 PriorityQueue  没有实现。

但我们首先来看PriorityQueue 的构造方法：
1.public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);

}

private static final int DEFAULT_INITIAL_CAPACITY = 11;

无参构造函数，默认调用一个传入初始容量为11的构造函数。

2.public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);

}

传入初始队列容量值，则队列的初始容量大小为传入的值大小。

3.public PriorityQueue(Comparator comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);

}

传参为一个比较器，调用默认容量值为11，带比较器的构造函数。

4.public PriorityQueue(int initialCapacity,  Comparator comparator) {

    if (initialCapacity <1)   throw new IllegalArgumentException();

    this.queue =new Object[initialCapacity];

    this.comparator = comparator;

}

传参为指定容量，和比较器，创建一个传入容量大小的Object数组队列，将比较器赋值给本地比较器。

5.public PriorityQueue(Collection c) {
if (cinstanceof SortedSet) {

SortedSet ss = (SortedSet) c;

        this.comparator = (Comparator) ss.comparator();

        initElementsFromCollection(ss);

    }

else if (cinstanceof PriorityQueue) {

PriorityQueue pq = (PriorityQueue) c;

        this.comparator = (Comparator) pq.comparator();

        initFromPriorityQueue(pq);

    }

else {

this.comparator =null;

        initFromCollection(c);

    }

}

传参为一个集合，则根据集合类型进行处理，获取集合的比较器，并将其根据不同类型转换为数组队列。
6.public PriorityQueue(PriorityQueue c) {
this.comparator = (Comparator) c.comparator();

    initFromPriorityQueue(c);

}

传参为PriorityQueue ，获取其比较器，并转换为数组队列。
7.public PriorityQueue(SortedSet c) {
this.comparator = (Comparator) c.comparator();

    initElementsFromCollection(c);

}

传参为SortedSet ，获取其比较器，并转换为数组队列。

接下来看它的5个队列的实现方法：

1.add()方法：

public boolean add(E e) {

        return offer(e);

}

这里调用了offer()方法。

2.offer()方法：

public boolean offer(E e) {

if (e ==null)

throw new NullPointerException();

    modCount++;

    int i =size;

    if (i >=queue.length)

grow(i +1);

    size = i +1;

    if (i ==0)

queue[0] = e;

else

        siftUp(i, e);

return true;

}

首先判断要添加的方法是否为空，若为空则抛出NullPointerException异常，若队列长度不够则进行扩容，当队列中原来没有数据时把传入的数据放在第一个元素处，当队列中原来有数据时将其和原来的元素根据Compator进行比较放在比较后所在的位置。
3.peek()

@SuppressWarnings("unchecked")

public E peek() {

return (size ==0) ?null : (E)queue[0];

}

判断队列的长度，若为空则返回null，不为空则获取下标为0的队列中的元素。但是并没有对队列进行操作。

4.poll()
public E poll() {

if (size ==0)

return null;

    int s = --size;

    modCount++;

    E result = (E)queue[0];

    E x = (E)queue[s];

    queue[s] =null;

    if (s !=0)

siftDown(0, x);

    return result;

}

获取队列中下标为0的元素，将最后位的元素取出，并将最后一位元素位置上的值置为null，然后将取出的最后一位的元素经过比较放在下标为0的位置。（这里具体怎么比较原谅我没特别明白，后续再补充）

5.remove()

public boolean remove(Object o) {

int i = indexOf(o);

    if (i == -1)

return false;

    else {

removeAt(i);

return true;

    }

}

找到想要删除元素的下标，如果下标不存在则返回false，如果存在则将其删除，返回true。

6.在PriorityQueue中还有一个方法comparator()是Queue中没有的，这个方法返回的是作为参数传递进来的Comparator，而Comparator中的comparator()方法是PriorityQueue中决定优先级的方法。
public Comparatorcomparator() {

return comparator;

}


注：https://www.jianshu.com/writer#/notebooks/47551432/notes/76522013
该链接是整理的除上述作业外还有对栈、队列、双向队列、优先级队列视频所做的笔记，格式可能比上面的格式清晰一些，若老师有时间希望可以看一下，不吝赐教。