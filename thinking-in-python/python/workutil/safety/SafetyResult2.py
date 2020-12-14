# 导入请求包
import requests
# 导入json包
import json

# 设置要访问的地址
url = 'http://10.6.202.59:8081/risk/after/pay'

# 手机列表
mobileList = ['13910220826']

# 循环收集列表查询
for mobile in mobileList:
    # 定一个字典类型
    param = {"mobile": mobile}

    # 这里得给设置一个请求格式，不然会返回415
    # header_dict = {"Content-Type": "application/json; charset=utf8"}

    # print(param)

    # 直接请求
    r = requests.post(url, data=param)
    # 这里是输出了一个字符串
    # print(r.text)

    # json处理
    json_data = json.loads(r.text)

    if json_data['data']['score'] > 70:

        print("手机号:", mobile, "分数:", json_data['data']['score'])
