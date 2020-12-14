"""
os 模块提供了非常丰富的方法用来处理文件和目录。
"""

f = open("/Users/yihonglei/Documents/tmp/hello.txt", "w")

# 关闭流
try:
    length = f.write("hello, world!")
    print(length)
finally:
    f.close()

# 关闭流优雅写法，程序执行完，流自动关闭
with open("/Users/yihonglei/Documents/tmp/hello.txt", "w") as file:
    length = file.write("hello, world, with close")
    print(length)
