"""
自定义函数规则:
1、函数代码块以 def 关键词开头，后接函数标识符名称和圆括号 ()。
2、任何传入参数和自变量必须放在圆括号中间，圆括号之间可以用于定义参数。
3、函数的第一行语句可以选择性地使用文档字符串—用于存放函数说明。
4、函数内容以冒号起始，并且缩进。
5、return [表达式] 结束函数，选择性地返回一个值给调用方。不带表达式的return相当于返回 None。
"""

"""
自定义函数语法:
def 函数名(参数列表):
    函数体
"""


# eg
# 定义
def hello(name):
    print("hello", name)


# 调用
hello("您好!")

"""
函数调用:
定义一个函数：给了函数一个名称，指定了函数里包含的参数，和代码块结构。
这个函数的基本结构完成以后，你可以通过另一个函数调用执行，也可以直接从 Python 命令提示符执行。
"""


# eg
# 定义
def invokeFun(name):
    print("调用我啊!", name)


# 调用
invokeFun("悟空!")

"""
参数传递:


"""


def talk(name):
    print("{},您好啊!".format(name))


talk("tom")
talk("lucy")


# 加法函数
def fn(x, y):
    print("x:{}，y:{}".format(x, y))
    return x + y


a = 10
b = 20
c = fn(a, b)
print("c:", c)
