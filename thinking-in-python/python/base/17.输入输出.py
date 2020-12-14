"""
Python两种输出值的方式: 表达式语句和 print() 函数。

第三种方式是使用文件对象的 write() 方法，标准输出文件可以用 sys.stdout 引用。

如果你希望输出的形式更加多样，可以使用 str.format() 函数来格式化输出值。

如果你希望将输出的值转成字符串，可以使用 repr() 或 str() 函数来实现。

str()： 函数返回一个用户易读的表达形式。
repr()： 产生一个解释器易读的表达形式。
"""

# 输出操作
print(123)
print(456)

# 输入操作
while True:
    password = input("请输入密码:")

    if password == "123456":
        print("密码正确，登录成功")
        break
    else:
        print("密码错误，请重新输入密码")

print("end!")
