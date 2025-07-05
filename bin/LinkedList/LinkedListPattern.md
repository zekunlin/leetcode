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