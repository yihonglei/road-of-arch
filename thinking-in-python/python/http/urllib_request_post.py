from urllib import request
import ssl
from urllib import parse

# 全局去掉ssl验证
ssl._create_default_https_context = ssl._create_unverified_context

if __name__ == "__main__":
    # post(有data就是post，否则就是get)
    url = "https://bd.ispacechina.com/showZbggListAjax.do?ispage=1&pageSize=10&page=1"
    # 字符串转bytes(二进制) 默认是utf8
    data = parse.urlencode({"name": "dog"}).encode()
    req = request.Request(url=url, headers={"1111": "222"}, data=data)
    # 添加 headers user-agent
    # req.add_header("User-Agent",
    #                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36")
    # req.add_header("Host", "bd.ispacechina.com")
    # req.add_header("Cookie",
    #                "__jsluid_h=e9b41048e2a40facd7808899d6d4dfd9; Hm_lvt_93352b09c212b481a8db685016fa5723=1579424895; Hm_lpvt_93352b09c212b481a8db685016fa5723=1579425128; __jsl_clearance=1579428716.09|0|yXxF6B%2F8hCNY7A%2BTszOI9zbbMok%3D")
    res = request.urlopen(req)
    print(res.read().decode())
