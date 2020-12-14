package com.jpeony.algorithm.lru;

/**
 * 【算法实现】
 * 基于单链表LRU算法实现。
 * 【算法思想】
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的，当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 1、如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2、如果此数据没有在缓存链表中，又可以分为两种情况：
 * .如果此时缓存未满，则将此结点直接插入到链表的头部；
 * .如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部；
 *
 * @author yihonglei
 */
public class LRULinkedList<T> {
    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node<T> head;

    /**
     * 链表长度
     */
    private Integer size;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRULinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public LRULinkedList(Integer capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 添加元素
     */
    public void add(T data) {
        // 判断缓存是否存在
        Node preNode = findPreNode(data);
        // 缓存不存在，并且缓存已满，删除尾部数据
        if (preNode == null) {
            if (size >= capacity) {
                removeLast();
            }
        } else {
            // 缓存存在，删除缓存数据
            removeNextNode(preNode);
        }
        // 头部添加数据
        addFirst(data);
    }

    /**
     * 头部添加数据
     */
    public void addFirst(T data) {
        // 如果头结点为空，则当前新增加结点作为头结点
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            // 新节点的next结点为头结点，头结点换为新结点
            Node newNode = new Node(data, head);
            head = newNode;
        }
        // 缓存个数加1
        size++;
    }

    /**
     * 尾部删除数据
     */
    public void removeLast() {
        Node node = head;
        // 头结点为空，无需进行删除处理
        if (node == null) {
            return;
        }
        // 如果头结点的下一个结点为空，只有头结点
        if (node.getNext() == null) {
            head = null;
            return;
        }
        // 头结点不为空，删除尾结点，需要首先获取倒数第二个结点
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        // gc help
        Node tmp = node.getNext();
        tmp = null;
        // 删除尾结点，即倒数第二个节点的尾节点的下一个结点置为空
        node.setNext(null);
        // 缓存个数减1
        size--;
    }

    /**
     * 删除preNode的下一个结点，用来清除缓存数据的，因为我们findPreNode返回的是缓存数据所在结点的上一个结点，
     * 清除preNode的下一个结点，即时缓存所在结点，即清除缓存数据
     */
    public void removeNextNode(Node preNode) {
        // 缓存所在结点
        Node cacheNode = preNode.getNext();
        // 缓存所在结点的下一个结点
        Node cacheAfterNode = cacheNode.getNext();
        // 缓存所在结点的上一个结点preNode的下一个结点为cacheAfterNode，即把缓存所在结点删除
        preNode.setNext(cacheAfterNode);
        // gc help
        cacheNode = null;
        size--;
    }

    /**
     * 查找缓存所在结点的前驱结点，并返回缓存数据所在节点的前驱节点，为删除缓存使用，链表的删除要找到前驱或后继节点
     */
    public Node findPreNode(T data) {
        Node node = head;
        // 如果头结点为空，缓存为空，返回null
        if (node == null) {
            return null;
        }
        // 查找缓存数据是否存在
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            // 如果没找到缓存所在节点，继续往下找
            node = node.getNext();
        }

        return null;
    }

    /**
     * 打印缓存
     */
    private void printAll() {
        Node node = head;
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println("");
    }

    public class Node<T> {
        private T element;

        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRULinkedList lruLinkedList = new LRULinkedList(10);

        for (int i = 1; i <= 11; i++) {
            lruLinkedList.add(i);
            System.out.print("===第" + i + "次打印===");
            lruLinkedList.printAll();
        }
    }
}
