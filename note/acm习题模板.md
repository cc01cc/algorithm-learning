## acm习题模板

### 头文件和预编译指令

```c++
#include <bits/stdc++.h>
#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
#ifndef ONLINE_JUDGE
    freopen("input.in", "r", stdin);
    freopen("output.out", "w", stdout);
    int startTime = clock();
#endif

#ifndef ONLINE_JUDGE
    printf("Time = %dms\n", clock() - startTime);
#endif
    return 0;
}
```

### 基础操作

* `input/output` : 输入/输出
* `n, m` : 变量

1. 输入输出

   * `cin` 速度慢于 `scanf` ，当数据大于 `1e5` 请使用 `scanf` 。
   * 输出小数使用 `printf` 更为便捷。

   ```c++
   #include <iostream>
   cout << "Hello World" << endl; //endl类似于“\n”
   cin >> input;
   cin.getline(input, 1000); //input为指针类型，1000定义字符上限
   cin >> n >> m; //判断EOF; n, m 为变量
   
   ```

2. 特性

   ```c++
   bool n = true;
   bool m = false;
   
   int* n = new int[100]; //使用new动态开辟内存
   //int* n = (int*)malloc(100*sizeof(int));
   ```
   

   

<div style="page-break-after: always;"></div>

---

### 标准库

#### `cstring`

```c++
size_t strlen(const char *str); //size_t: long long unsigned int

int strcmp(const char *str1, const char *str2);
int strncmp(const char *str1, const char *str2, size_t n); 
//字符串比较；（前n个字符）；str1<str2: <0

char *strcpy(char *dest, const char *src);
char *strncpy(char *dest, const char *src, size_t n); //src复制到dest

void *memset(void *str, int c, size_t n); 
//复制字符c到str所指向的字符串的前n个字符。
memset(arr1, INF, sizeof(arr1)); 
//将arr1中所有数据初始化为INF（const int INF = 0x3f3f3f3f）
memset(arr1, 0, sizeof(arr1));
//将arr1中所有数据初始化为0
void *memcpy(void *str1, const void *str2, size_t n); //强制复制
```



#### `cmath`

```c++
double acos(double x); //返回以弧度表示的 x 的反余弦。
double cos(double x); //返回弧度角 x 的余弦。
double exp(double x); //返回 e 的 x 次幂的值。
double frexp(double x, int *exponent); //把浮点数 x 分解成尾数和指数。返回值是尾数，并将指数存入 exponent 中。
double modf(double x, double *integer); //返回值为小数部分（小数点后的部分），并设置 integer 为整数部分。
double ldexp(double x, int exponent); //返回 x 乘以 2 的 exponent 次幂。
double log(double x); //返回 x 的自然对数（基数为 e 的对数）。
double log10(double x); //返回 x 的常用对数（基数为 10 的对数）
```

```c++
double pow(double x, double y); //返回 x 的 y 次幂。
double sqrt(double x); //返回 x 的平方根。
double ceil(double x); //返回大于或等于 x 的最小的整数值。
double fabs(double x); //返回 x 的绝对值。
double floor(double x); //返回小于或等于 x 的最大的整数值。
double fmod(double x, double y); //返回 x 除以 y 的余数。
```

<div style="page-break-after: always;"></div>

#### `cstdlib`

```c++
double atof(const char *str); //把参数 str 所指向的字符串转换为一个浮点数
int atoi(const char *str); //把参数 str 所指向的字符串转换为一个整数
long int atol(const char *str);
double strtod(const char *str, char **endptr);
//把参数 str 所指向的字符串转换为一个浮点数（类型为 double 型）。
//如果 endptr 不为空，则指向转换中最后一个字符后的字符的指针会存储在 endptr 引用的位置。(拆分数字和字母)
long int strtol(const char *str, char **endptr, int base);
//把参数 str 所指向的字符串根据给定的进制 base 转换为一个长整数（类型为 long int 型），
//base 必须介于 2 和 36（包含）之间，或者是特殊值 0。
unsigned long int strtoul(const char *str, char **endptr, int base) 

itoa();ltoa();ultoa();
gcvt(); //四舍五入浮点转字符串
ecvt(); //双精度浮点转字符串
```

```c++
void *calloc(size_t nitems, size_t size); 
//分配所需的内存空间，并返回一个指向它的指针。nitems: 要被分配的元素个数。
void *malloc(size_t size); //分配所需的内存空间，并返回一个指向它的指针。
//malloc不会设置内存为零，calloc会设置分配的内存为零。
void *realloc(void *ptr, size_t size); 
//尝试重新调整之前调用 malloc 或 calloc 所分配的 ptr 所指向的内存块的大小。
void free(void *ptr)
```

```c++
void *bsearch(const void *key, const void *base, size_t nitems, size_t size, int (*compar)(const void *, const void *)); 
//对 nitems 对象的数组执行二分查找，base 指向进行查找的数组，key 指向要查找的元素，size 指定数组中每个元素的大小。数组的内容应根据 compar 所对应的比较函数升序排序。
void qsort(void *base, size_t nitems, size_t size, int (*compar)(const void *, const void*)); 
//对数组进行排序。
```

```c++
int abs(int x)
long int labs(long int x)

div_t div(int numer, int denom); 
//把 numer（分子）除以 denom（分母）。div_t: int quot(商); int rem(余数)
ldiv_t div(long int numer, long int denom); //ldiv_t: long quot(商); long rem(余数)
```

```c++
void srand(unsigned int seed); //播种由函数 rand 使用的随机数发生器。
int rand(void); //返回一个范围在 0 到 RAND_MAX 之间的伪随机数.RAND_MAX为常量，大于32767。

int mblen(const char *str, size_t n); //返回参数 str 所指向的多字节字符的长度。n -- 要检查的字符长度的最大字节数。
```

<div style="page-break-after: always;"></div>

#### `ctime`

```c++
struct tm {
   int tm_sec; //秒，0~59
   int tm_min; //分，0~59
   int tm_hour; //小时，0~23
   int tm_mday; //一月中的第几天，1~31
   int tm_mon; //月，0~11
   int tm_year; //自 1900 年起的年数
   int tm_wday; //一周中的第几天，0~6
   int tm_yday; //一年中的第几天，0~365
   int tm_isdst; //夏令时
};

clock_t clock(void); //返回程序执行起，处理器时钟所使用的时间。为了获取 CPU 所使用的秒数，您需要除以 CLOCKS_PER_SEC。clock_t: 长整型
time_t time(time_t *seconds); //返回自纪元 Epoch（1970-01-01 00:00:00 UTC）起经过的时间，以秒为单位。如果 seconds 不为空，则返回值也存储在变量 seconds 中。
```



#### `cctype`

```c++
void isalnum(int c); //检查所传的字符是否是字母和数字。
void isalpha(int c); //检查所传的字符是否是字母。
int isdigit(int c); //检查所传的字符是否是十进制数字字符。
int isxdigit(int c); //检查所传的字符是否是十六进制数字。
int isgraph(int c); //检查所传的字符是否有图形表示法(除了空白字符以外的所有可打印的字符)
int islower(int c); //检查所传的字符是否是小写字母。
int isupper(int c); //检查所传的字符是否是大写字母。
int isspace(int c); //检查所传的字符是否是空白字符(' ', '\t', '\n', '\v', '\f', '\r')
    
int tolower(int c); //把给定的字母转换为小写字母。
int toupper(int c); //把小写字母转换为大写字母。
```

<div style="page-break-after: always;"></div>

### C++STL

#### `<vector>` 数组

```c++
vector<int> list;
list.size(); //数组元素个数O(1)
list.clear(); //清空数组O(n)
list.empty(); //数组是否为空O(1)
list.begin(); //数组的首元素迭代器O(1)
list.end(); //数组最后一个元素的下一个元素的迭代器O(1)
list.erase(p1); //删除数组某个迭代器所在位置的数字O(n)
list.push_back(1); //往数组最后添加元素O(1)
list.pop_back(); //弹出数组最后一个元素O(1)
```

##### 定义与遍历

```c++
vector<int> arr1(100);
// int arr1[100];

vector<int> list; //可像链表更改长度
list.push_back(1);
list.push_back(2);

for(int i = 0; i < 100; i++){
    scanf("%d", &arr1[i]);
    cout << arr1[i] << endl;
}
for(int i = 0; i < 100; i++){
    int a; cin >> a;
    list.push_back(a);
    printf("%d\n", list[i]);
}
```

##### 迭代器与指针

```c++
vector<int> arr1(100);
int arr2[100];

vector<int>::iterator p1;
int* p2;

for(p1 = arr1.begin(); p1 != arr1.end(); p1++){
    cout << *p1 <<endl;
}
for(int i = 0, p2 = arr2; i < 100; i++, p2++){
    cout << *p2 << endl;
}
```



#### `<string>` 字符串

* `string` **类似**于特殊的 `vector` (size的时间复杂度有差异)

```c++
string str = "hello world!";
str.length(); str.size(); //O(n)
str.insert(1,"abc"); str.insert(str.begin(), 'a'); //O(n)
str.c_str(); //返回c语言字符串，用于printf O(n)
str.append(str2); //把str2拼接到str后 O(n)
str.compare(str2); //strcmp(str, str2)
str == str2; //strcmp(str, str2) == 0
str += str2; //str.append(str2);
str += 'a'; //str.push_back('a');
```

#### `<algorithm>` 算法函数

##### `sort` 快速排序

```c++
vector<int> arr;
sort(arr.begin(), arr.end());//默认升序排列

//定义排序方式
bool cmpInt(int a, int b) return a > b;
sort(arr.begin(), arr.end(), cmpInt);//改为降序
//同样适用于自定义的结构体
```

##### 其他

```c++
min(a, b); max(a, b); //O(1)
min_element(arr.begin(), arr.end());
max_element(arr.begin(), arr.end()); //范围内的最小/大者的迭代器。O(n)

nth_element(arr.begin(), arr.begin()+n, arr.end());
// 把数组中第n小(从0开始)的数放到第n位置，并保证左边数比它小，右边数比它大。O(n)

swap(arr[0], arr[1]); //蒋欢任意两个同类型变量O(n)
reverse(arr.begin(), arr.end()); //反转数组O(n)

unique(arr.begin(), arr.end()); //去除已排序arr中重复的数字，并返回去重后数组的结束指针O(n)

binary_search(arr.begin, arr.end(), 1); //查找对应元素是否存在，返回bool O(logn)

lower_bound(arr.begin(), arr.end(), 2);
upper_bound(arr.begin(), arr.end(), 2);//将2插入有序数组第一/最后位置。
```

#### `<stack>` 栈

```c++
stack<int> sta;
sta.push(1);
int topElement = sta.top();
sta.pop();
sta.empty();
sta.size();
```

#### `<queue>` 队列

```c++
queue<int> que;
que.push(1);
int frontElement = que.front();
que.pop();
que.empty();
que.size();

priority_queue<int> que2; //优先队列
que2.push(1);
int minElement = que2.top();
que2.pop();
que2.empty();
que.size();
```

#### `<set>` 集合

```c++
set<int> st;
st.insert(1);
st.find(1);
st.erase(1);

multiset<int> mst; //允许元素重复
mst.insert(1);
mst.count(1); //获取元素1的数量
```

#### `<map>` 映射

```c++
pair<int, int> origin;
origin = make_pair(0, 0);
origin.first == origin.second;
origin.swap; //返回swap的新pair

map<int, int> mp;
mp.insert(origin);
mp.erase(0);
```

#### `<bitset>` 位集合

```c++
bitset<1000> bst;
bst[0] = 1; bst.set(0);
bst[0] = 0; bst.reset(0);
bst << 1; bst >> 1; bst ^= 1; bst &= 1;
bst.count(); //求1的个数
bst.to_string();
bst.to_ullong();
```

#### 其他库

`<functional>` , `<complex>` , `<unordered_set>` , `<unordered_map>` 

<div style="page-break-after: always;"></div>

### c++ 11特性

```c++
auto a = 1; //auto编译器自动判断类型

for(auto a: arr) cout << a << endl; //for遍历
//prev(), next()改变迭代器
//lambda表达式
```



##### Dijkstra算法

[2387 -- Til the Cows Come Home (poj.org)](http://poj.org/problem?id=2387)

###### Input

\* Line 1: Two integers: T and N

\* Lines 2: Each line describes a trail as three space-separated integers. The first two integers are the landmarks between which the trail travels. The third integer is the length of the trail, range 1..100.

###### Output

\* Line 1: A single integer, the minimum distance that Bessie must travel to get from landmark N to landmark 1.

###### Sample Input

```
5 5
1 2 20
2 3 30
3 4 20
4 5 20
1 5 100
```

###### Sample Output

```
90
```

###### Solution

```c++
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int n, t, i, j;
    int a[2001], b[2001], c[2001];
    vector<int> d;
    cin >> t >> n;
    for (i = 0; i < t; i++) scanf("%d %d %d", a + i, b + i, c + i);
    d.push_back(0);
    for (i = 1; i < n; i++) d.push_back(0x3f3f3f3f);
    //!!!!!!
    while (i--)//n个数，循环n次。
    {
        for (j = 0; j < t; j++)//每次循环，遍历所有数。
        {
            d[a[j]-1] = min(d[a[j]-1], d[b[j]-1] + c[j]);
            d[b[j]-1] = min(d[b[j]-1], d[a[j]-1] + c[j]);
            //每个值与自身进行比较，选取最小值。
        }
    }
	//!!!!!!
    cout << d[n - 1] << endl;
    return 0;
}
```



1. 使用什么数据结构存储数据（数组，堆栈）