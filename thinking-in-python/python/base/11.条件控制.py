"""
Python条件语句是通过一条或多条语句的执行结果（True或者False）来决定执行的代码块。
"""
"""
if 语句，一般语法格式:
if c_1:
    b_1
elif c_2:
    b_2
else:
    b_3
    
关于语法分析:
如果 "c_1" 为 True 将执行 "b_1" 块语句
如果 "c_1" 为False，将判断 "c_2"是True还是False
如果"c_2" 为 True 将执行 "b_2" 块语句
如果 "c_2" 为False，将执行"b_3"块语句
一般语言中看到的是else if，Python中用 elif 代替了 else if，所以if语句的关键字为：if – elif – else;

注意事项:
1、每个条件后面要使用冒号 :，表示接下来是满足条件后要执行的语句块;
2、使用缩进来划分语句块，相同缩进数的语句在一起组成一个语句块;
3、在Python中没有像Java语法哪样的switch–case语句;
"""
# eg1
people_age = int(input("请输入你的年龄:"))
if people_age >= 18:
    print("成年人")
else:
    print("未成年")

"""
if 嵌套:
if c_1:
    if c_2:
        b_2
    elif c_3:
        b_3
    else:
        b_4
elif c_4:
    b_5
else:
    b_6
    
任何一个地方都可以进行if嵌套，可以进行多次嵌套；
"""
# eg2
people_age = int(input("请输入你的年龄:"))
if people_age >= 18:
    print("成年人")
    if people_age%2 == 0:
        print("幸运指数0")
    else:
        print("幸运指数1")
else:
    print("未成年")

