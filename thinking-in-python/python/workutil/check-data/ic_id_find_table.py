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
start = '2018-05-01'
end = '2019-06-13'

date_start = datetime.datetime.strptime(start, '%Y-%m-%d')
date_end = datetime.datetime.strptime(end, '%Y-%m-%d')

# ic_id
ic_id_all = ""

# 循环处理数据
while date_start <= date_end:
    day_date = date_start.strftime('%Y%m%d')
    date_start += datetime.timedelta(1)

    # 业务sql
    sql = "select ic_id, ic_money from `jd-java`.invest_credit_%s " \
          "where ic_id in('821403326175522826', '821403326175522827','821403326175522828','821403326175522829')" % day_date

    dataShare_cursor.execute(sql)

    results = dataShare_cursor.fetchall()

    for row in results:
        print("ic_id:", row[0], ", ic_money:", row[1], ", time:", day_date)
        name = row[0]
        ic_id_all += (row[0] + ",")

# 打印所有的ic_id
print("all_ic_id:", ic_id_all)

# 事务提交
db_dataShare.commit()

# 关闭游标
dataShare_cursor.close()

# 关闭连接
db_dataShare.close()
