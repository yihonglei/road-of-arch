import pymysql

# jd-java
db_business = pymysql.connect("127.0.0.1", "root", "123456", "lanhuigu")

# data-share
db_dataShare = pymysql.connect("127.0.0.1", "root", "123456", "lanhuigu")

# 获取游标
business_cursor = db_business.cursor()
dataShare_cursor = db_dataShare.cursor()

# 从业务库获取数据
business_sql = "select * from message_record"

# 查询业务库
business_cursor.execute(business_sql)

# 获取所有业务记录列表
results = dataShare_cursor.fetchall()

# 循环插入数据推送中心
for i in results:
    data_sql = "insert into ic_new (ic_id) values (%s)"

    dataShare_cursor.execute(data_sql, i[0])

# 统一提交事务
db_dataShare.commit()

# 关闭游标
business_cursor.close()
dataShare_cursor.close()

# 关闭连接
db_business.close()
db_dataShare.close()





