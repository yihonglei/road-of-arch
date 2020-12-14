import pymysql
import re

# 打开数据库连接
db = pymysql.connect("10.7.103.103", "hqzc_office", "hqzc@2018#", "rentcar")
# 使用 cursor() 方法创建一个游标对象 cursor
cursor = db.cursor()

# 文件
file_name = "/Users/hongqi/Documents/tmp/risklog/20191027.txt"

f = open(file_name, "r")
line = f.readline()
orders = []

while line:
    line = f.readline()
    arr = line.split("orderNo:")
    if len(arr) == 2:
        if arr[1] not in orders:
            orders.append(arr[1])
# 关闭文件流
f.close()

print("日期===================城市====订单号===================用户手机号=======订单类型==预估金额")
# 订单循环处理
for orderNo in orders:
    orderNoNew = orderNo.replace("\n", "")

    if orderNoNew.startswith("C"):
        continue

    # sql
    querySql = "select create_date create_date," \
               "case when city_id = 44 then '北京'" \
               "when city_id = 88 then '长春'" \
               "when city_id = 66 then '杭州'" \
               "when city_id = 107 then '天津'" \
               "when city_id = 78 then '成都'" \
               " else city_id end cityName," \
               "order_no," \
               "booking_user_phone," \
               "case when service_type_id = 1 then '即时'" \
               "when service_type_id = 2 then '预约'" \
               "when service_type_id = 3 then '接机'" \
               "when service_type_id = 5 then '送机'" \
               "when service_type_id = 6 then '日租'" \
               "when service_type_id = 7 then '半日租'" \
               "else '其他' end order_type," \
               "estimated_Amount " \
               "from car_fact_order where order_no = '%s'" % orderNoNew

    # 使用 execute()  方法执行 SQL 查询
    cursor.execute(querySql)
    # 使用 fetchone() 方法获取单条数据
    data = cursor.fetchone()

    create_date = data[0]
    city_name = data[1]
    order_no = data[2]
    booking_user_phone = data[3]
    order_type = data[4]
    estimated_Amount = data[5]

    print("%s   %s   %s   %s   %s   %s"
          %
          (create_date, city_name, order_no, booking_user_phone, order_type, estimated_Amount))
# 关闭数据库
cursor.close()
