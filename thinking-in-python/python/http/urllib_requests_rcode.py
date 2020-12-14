# 导入请求包
import requests

if __name__ == "__main__":
    url = "http://www.jpeony.com/2015/07/07/%E5%8D%9A%E6%96%87%E6%A0%BC%E5%BC%8F%E5%8F%82%E8%80%83/"
    res = requests.get(url)
    res.encoding = "utf-8"
    print(res.text)
    # Content-Type: text/html
    # Content-Type: text/html;charset=utf-8
    # print(res.encoding) # ISO-8859-1
