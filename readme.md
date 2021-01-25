## 排序测试
单位毫秒

|  排序   | 80000  | 800000|8000000|8000000|
|  ----  | ----  | ----  |----|----|
| 冒泡demo3  | 11757 | ||
| 快速排序（冒泡改进）  | 20 |120 |1180|
| 简单插入（位移）  | 650 |64495 ||
| 选择排序  | 2320 | ||
| 希尔排序（插入法）  | 15 | 180|2493|
| 基数排序  | 10 | 70|465|lang.OutOfMemoryError: Java heap space|

### 相关术语
- 稳定：如果a = b 且a 在b前面 排序后 a任然 在b前面
- 不稳定： 如果a = b 且a 在b前面 排序后 a可能 在b后面
- 内排序：所有排序在内存中完成
- 外排序：数据大 把数据放在磁盘中 ，排序内存和磁盘数据传输完成
- 时间复杂度：一个算法 执行耗费的时间
- 空间复杂度： 运行一个程序 所需内存的大小