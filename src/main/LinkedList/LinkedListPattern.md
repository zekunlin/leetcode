# LinkedList summary

## stop condition for iterating the list:

if want to stop at null after tail node (last node):

```java
ListNode cur = head;
while(cur != null){
    cur = cur.next;
}
```

if want to stop at the tail node:

```java
ListNode cur = head;
while(cur.next != null){
    cur = cur.next;
}
```

## insert a node

```java
Node prev;
Node cur;
cur.next = prev.next;
prev.next = cur;
```

## delete a node

```java
Node prev;
prev.next = prev.next.next;
```

## summary two pointers for LinkedList: 

```java
// Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
```

you should pay attention:

1. Always examine if the node is null before you call the next field.

    Getting the next node of a null node will cause the null-pointer error. For example, before we run fast = fast.next.next, we need to examine both fast and fast.next is not null.

2. Carefully define the end conditions of your loop.

    Run several examples to make sure your end conditions will not result in an endless loop. And you have to take our first tip into consideration when you define your end conditions.
