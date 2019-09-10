## SpringBoot中外部化参数的初始化顺序
![nUsCYq.png](https://s2.ax1x.com/2019/09/10/nUsCYq.png)

本图来自官方：从上往下优先级逐步降低，并且优先级高的会把优先级低的值进行覆盖。

## 案例测试:
本案例测试了devtools、内部application-dev.properties、 内部application.properties

## 测试结果
可以发现和官方提供的初始化顺序一样，devtools优先级最高  内部application.properties优先级最低。