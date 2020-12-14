# 导入请求包
import requests
# 导入json包
import json

if __name__ == "__main__":
    # 设置要访问的地址
    url = 'https://octdzzc.chinaoct.com/tender/pub_noticeListAction.do?noticeType=2&pageSize=18&pageNo=1&pageSize=18'

    # 手机列表
    mobileList = ['18610538793']

    # 循环收集列表查询
    for mobile in mobileList:
        # 定一个字典类型
        param = {"mobile": mobile}

        # 这里得给设置一个请求格式，不然会返回415
        # header_dict = {"Content-Type": "application/json; charset=utf8"}

        # print(param)

        # 直接请求
        r = requests.post(url)
        # 这里是输出了一个字符串
        # print(r.text)

        # json处理
        json_data = json.loads(r.text)

        print("手机号:", mobile, "分数:", json_data.get('data').get('score'))
