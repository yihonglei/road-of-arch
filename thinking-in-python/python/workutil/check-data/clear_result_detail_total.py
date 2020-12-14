import pymysql
import datetime

# jd-java
db_jd_java = pymysql.connect(
    host="",
    port=8072,
    user="",
    passwd="",
    db="",
    charset='utf8')

# data-share
db_dataShare = pymysql.connect(
    host="",
    port=3306,
    user="",
    passwd="",
    db="",
    charset='utf8')

# 获取游标
jdJava_cursor = db_jd_java.cursor()
dataShare_cursor = db_dataShare.cursor()

# 循环日期
start = '2017-08-10'
end = '2017-08-10'

date_start = datetime.datetime.strptime(start, '%Y-%m-%d')
date_end = datetime.datetime.strptime(end, '%Y-%m-%d')

# ic_id
ic_id_all = ""

# 循环处理数据
while date_start <= date_end:
    day_date = date_start.strftime('%Y%m%d')
    date_start += datetime.timedelta(1)

    # 分页
    offset = 0
    limit = 1000
    pageSize = offset

    while True:
        # jd-java获取
        sql = "select crd_id,if(uid_id is null or uid_id = '', '9999', uid_id) uid_id " \
              "from `jd-java`.clear_result_detail_%s " \
              "limit %s, %s" % (day_date, pageSize, limit)

        jdJava_cursor.execute(sql)

        # 如果没有查到数据，则退出
        if jdJava_cursor.rowcount == 0:
            break

        # 数据插入到data-share
        results = jdJava_cursor.fetchall()

        dataShare_sql = "insert into data_share.clear_result_detail_total(crd_id, uid_id) values"
        values = ""
        for row in results:
            values += "(%s, %s)," % (row[0], row[1])

        values = values[0:len(values) - 1]

        dataShare_sql += (values + ";")

        dataShare_cursor.execute(dataShare_sql)

        print("============")

        print("offset:", offset, "pageSize:", pageSize, "effectiveCount:", dataShare_cursor.rowcount)

        # 分页计算
        offset = offset + 1
        pageSize = offset * limit

        # 事务提交
        db_jd_java.commit()
        db_dataShare.commit()

# 关闭游标
jdJava_cursor.close()
dataShare_cursor.close()

# 关闭连接
db_jd_java.close()
db_dataShare.close()
