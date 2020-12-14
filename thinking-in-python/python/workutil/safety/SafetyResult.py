# 导入请求包
import requests
# 导入json包
import json

# 设置要访问的地址
url = 'http://10.6.202.59:8081/risk/after/pay'

# 手机列表
mobileList = ""

# 循环收集列表查询
# TODO

# 定一个字典类型
param = {"mobile": ""}

# 这里得给设置一个请求格式，不然会返回415
# header_dict = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko',"Content-Type": "application/json"}
header_dict = {"Content-Type": "application/json; charset=utf8"}

print(param)

# 直接请求
r = requests.post(url, data=param, headers=header_dict)
# 这里是输出了一个字符串
print(r.content)

