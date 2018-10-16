## StampedLock
StampedLock控制锁有三种模式（写，读，乐观读），一个StampedLock状态是由版本
和模式两个部分组成，锁获取方法返回一个数字作为票据stamp，它用相应的锁状态表示
并控制访问，数字0表示没有写锁被授权访问。在读锁上分为悲观锁和乐观锁。

try系列获取锁的函数，当获取锁失败后会返回为0的stamp值。当调用释放锁和转换锁的方法时候需要传入获取锁时候返回的stamp值。

StampedLockd的内部实现是基于CLH锁的，CLH锁原理：锁维护着一个等待线程队列，
所有申请锁且失败的线程都记录在队列。一个节点代表一个线程，保存着一个标记位
locked,用以判断当前线程是否已经释放锁。当一个线程试图获取锁时，从队列尾节点
作为前序节点，循环判断所有的前序节点是否已经成功释放锁。


## 参考
- [Java Thread&Concurrency(9): 深入理解StampedLock及其实现原理](https://blog.csdn.net/luoyuyou/article/details/30259877)