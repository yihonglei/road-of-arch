from urllib import parse

"""
data参数拼接
"""
if __name__ == "__main__":
    data = {"name": "123456", "age": "18"}
    data = parse.urlencode(data)  # 将字典转为字符串
    url = "https://httpbin.org/get?" + data
    print(url)
