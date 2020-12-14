from urllib import request
import ssl

# 全局去掉ssl验证
ssl._create_default_https_context = ssl._create_unverified_context

if __name__ == "__main__":
    # get,默认请求方式
    url = "www.ebiddingtest.cecep.cn/jyxx/001001/001001001/20200119/0cac7331-8385-48b7-b252-f836f329aa65.html"
    res = request.urlopen(url)
    print(res)
    # 状态码
    print(res.code)
    # b bytes
    print(res.read().decode("GBK"))
    # 查看res有哪些方法
    print(dir(res))
