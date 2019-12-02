## 继承
- 在Java中，所有的继承都是共有继承，不能私有继承和保护继承
- super关键字的用途：1、调用父类的方法；2、调用父类的构造器。

## 异常
### 异常层次结构
![](https://hexo-1252893039.cos.ap-shanghai.myqcloud.com/20190628101829.png)

Error 类层次结构描述了Java运行时系统内部错误和资源耗尽错误。在开发中，更应该关注Exception
层次的异常。

## 断言
Java 语言引入了关键字 assert。这个关键字有两种形式：
- assert 条件;
- assert 条件: 表达式;

