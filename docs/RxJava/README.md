# RxJava 函数式反应编程
[RxJava教程](https://blog.csdn.net/gaolh89/article/details/81386252)

## 函数式编特点
- 函数是第一等公民
- 闭包和高阶函数
- 递归
- 惰性求职
- 没有副作用

## RxJava
使用观察者模式

### RxJav 基础知识
#### Observable
RxJava的使用需要三部
- 创建Observable：Observable是被观察者，使用RxJava时需要创建一个被观察者，它决定
什么时候触发事件一级触发怎样的事件、
- 创建Observer：创建观察者，它可以在不同线程中执行任务
- 使用subscribe()进行订阅：创建了Observable和Observer后，使用subscribe()
方法将它们连接起来

#### do操作符
do 操作符可以给Observable的生命周期的各个阶段加上一系列的回调监听，当
Observable执行到这个阶段时，这些回调会被触发，