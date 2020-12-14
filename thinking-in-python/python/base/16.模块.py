"""
Python 模块(Module)，是一个 Python 文件，以 .py 结尾，包含了 Python 对象定义和Python语句。

模块让你能够有逻辑地组织你的 Python 代码段。

把相关的代码分配到一个模块里能让你的代码更好用，更易懂。

模块能定义函数，类和变量，模块里也能包含可执行的代码。

"""

# =================import 与 from...import=================
""""
在 python 用 import 或者 from...import 来导入相应的模块。
1. 将整个模块导入，格式为： import somemodule
2. 从某个模块中导入某个函数,格式为： from somemodule import somefunction
3. 从某个模块中导入多个函数,格式为： from somemodule import firstfunc, secondfunc, thirdfunc
4. 将某个模块中的全部函数导入，格式为： from somemodule import *
"""
# eg1: 导入 sys 模块
import sys
print('===python import mode===')
print('命令行参数为:')
for i in sys.argv:
    print(i)
print('\n python 路径为',sys.path)

# eg2: 导入 sys 模块的 argv,path 成员(导入特定成员)
from sys import argv, path
print('===python from import===')
print('path:', path) # 因为已经导入path成员，所以此处引用时不需要加sys.path


"""
搜索路径
当你导入一个模块，Python 解析器对模块位置的搜索顺序是：

1、当前目录
2、如果不在当前目录，Python 则搜索在 shell 变量 PYTHONPATH 下的每个目录。
3、如果都找不到，Python会察看默认路径。UNIX下，默认路径一般为/usr/local/lib/python/。
模块搜索路径存储在 system 模块的 sys.path 变量中。变量里包含当前目录，PYTHONPATH和由安装过程决定的默认目录。
"""




