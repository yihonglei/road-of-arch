import pymysql
import datetime

# data-share
db_dataShare = pymysql.connect(
    host="",
    port=8072,
    user="",
    passwd="",
    db="",
    charset='utf8')

# 获取游标
dataShare_cursor = db_dataShare.cursor()

# 循环日期
start = '2018-05-28'
end = '2019-6-14'

date_start = datetime.datetime.strptime(start, '%Y-%m-%d')
date_end = datetime.datetime.strptime(end, '%Y-%m-%d')

# ic_id
ic_id_sum = 0

# 循环处理数据
while date_start <= date_end:
    day_date = date_start.strftime('%Y%m%d')
    date_start += datetime.timedelta(1)

    # 业务sql
    sql = "select sum(ic_money) from `jd-java`.invest_credit_%s where u_id = '1604007'" % day_date

    dataShare_cursor.execute(sql)

    results = dataShare_cursor.fetchall()

    # result = list(results)

    for row in results:
        if row[0] is not None:
            print("ic_money:", row[0], ", time:", day_date)
            ic_id_sum += int(row[0])

# 打印sum金额
print("money_sum:", ic_id_sum)

# 事务提交
db_dataShare.commit()

# 关闭游标
dataShare_cursor.close()

# 关闭连接
db_dataShare.close()
