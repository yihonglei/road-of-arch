from urllib import parse
import requests

url = "https://www.baidu.com/s?wd=%E8%B1%86%E7%93%A3"
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"
}
if __name__ == "__main__":
    res = requests.get(url, headers=headers)
    print(res.encoding)
    wd = "豆瓣"
    print(parse.quote(wd))# %E8%B1%86%E7%93%A3
    url = "https://www.baidu.com/s?wd=%E8%B1%86%E7%93%A3" # url 编码 中文变成了%E8%B1%86%E7%93%A3
    t = parse.unquote(url)
    print(t)
