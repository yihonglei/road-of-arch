import pymysql
import datetime

# data-share
db_dataShare = pymysql.connect("127.0.0.1", "root", "123456")

# 获取游标
dataShare_cursor = db_dataShare.cursor()

# 循环日期
start = '2018-12-25'
end = '2019-05-17'

date_start = datetime.datetime.strptime(start, '%Y-%m-%d')
date_end = datetime.datetime.strptime(end, '%Y-%m-%d')

# 循环处理数据
while date_start <= date_end:
    day_date = date_start.strftime('%Y%m%d')
    date_start += datetime.timedelta(1)

    # 业务sql
    sql = "INSERT INTO data_share.message_check_result (" \
          "  business_type, " \
          "  business_id, " \
          "  expanded, " \
          "  send_status, " \
          "  modify_time, " \
          "  create_time " \
          " ) " \
          " SELECT " \
          "  19," \
          "  crd.crd_id," \
          "  '%s'," \
          "  0," \
          "  NOW()," \
          "  NOW()" \
          " FROM " \
          "  `jd-java`.clear_result_detail_%s crd" \
          "  LEFT JOIN data_share.message_record mr" \
          "    ON mr.business_id = crd.crd_id" \
          "    AND mr.business_type = 19" \
          " WHERE mr.business_id IS NULL and" \
          " crd.crd_clear_pay_status = 2 and crd.crd_red_pay_status = 2 " % (day_date, day_date)

    # test sql
    # sql = "insert into mybatis.user(userName, age) " \
    #       "select business_id, %s from lanhuigu.message_record"

    dataShare_cursor.execute(sql)

    effective_count = dataShare_cursor.rowcount

    print("dayDate:", day_date, "effectiveCount:", effective_count)

    # 每跑一天数据提交一次事务
    db_dataShare.commit()

# 关闭游标
dataShare_cursor.close()

# 关闭连接
db_dataShare.close()
