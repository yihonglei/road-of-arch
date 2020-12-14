import pymysql
import datetime

# order库
order_db = pymysql.connect(
    host="10.7.103.103",
    port=3306,
    user="hqzc_office",
    passwd="hqzc@2018#",
    db="rentcar")
order_cursor = order_db.cursor()

# 风控库
safety_db = pymysql.connect(
    host="10.7.103.105",
    port=3307,
    user="hqzc_office",
    passwd="hqzc@2018#",
    db="safety")
safety_cursor = safety_db.cursor()

# 日期循环
start = "2019-11-18"
end = "2019-11-21"

date_start = datetime.datetime.strptime(start, '%Y-%m-%d')
date_end = datetime.datetime.strptime(end, '%Y-%m-%d')

while date_start < date_end:
    day_start_str = date_start.strftime('%Y-%m-%d') + " 00:00:00"
    day_end_str = date_start.strftime('%Y-%m-%d') + " 23:59:59"

    # 个人下单总量
    orderCountQuery = \
        " select count(1) orderCount " \
        " from car_fact_order " \
        " where city_id = 44 " \
        " and type = 1 " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " % (day_start_str, day_end_str)
    order_cursor.execute(orderCountQuery)
    orderCountData = order_cursor.fetchone()
    orderCount = orderCountData[0]

    # 包车业务
    charteredCountQuery = \
        " select count(1) charteredCount " \
        " from car_biz_chartered " \
        " where city_id = 44 " \
        " and type = 1 " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " % (day_start_str, day_end_str)
    order_cursor.execute(charteredCountQuery)
    charteredCountData = order_cursor.fetchone()
    charteredCount = charteredCountData[0]

    # 完单数量
    finishedCountQuery = \
        " select count(1) finishedCount " \
        " from car_fact_order " \
        " where city_id = 44 " \
        " and type = 1 " \
        " and status in (45, 50) " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " % (day_start_str, day_end_str)
    order_cursor.execute(finishedCountQuery)
    finishedCountData = order_cursor.fetchone()
    finishedCount = finishedCountData[0]

    # 取消数量
    cancelCountQuery = \
        " select count(1) cancelCount " \
        " from car_fact_order " \
        " where city_id = 44 " \
        " and type = 1 " \
        " and status = 60 " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " % (day_start_str, day_end_str)
    order_cursor.execute(cancelCountQuery)
    cancelCountData = order_cursor.fetchone()
    cancelCount = cancelCountData[0]

    # 未完单数量
    unfinishedCountQuery = \
        " select count(1) unfinishedCount " \
        " from car_fact_order " \
        " where city_id = 44 " \
        " and type = 1 " \
        " and status >= 15 and status < 45 " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " % (day_start_str, day_end_str)
    order_cursor.execute(unfinishedCountQuery)
    unfinishedCountData = order_cursor.fetchone()
    unfinishedCount = unfinishedCountData[0]

    # 风控拦截数量
    safetyCountQuery = \
        " select count(1) safetyCount " \
        " from risk_record " \
        " where city_id = 44 " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " % (day_start_str, day_end_str)
    safety_cursor.execute(safetyCountQuery)
    safetyCountData = safety_cursor.fetchone()
    safetyCount = safetyCountData[0]

    # 汇总数据打印
    print("【" + date_start.strftime('%Y-%m-%d') + "】")
    print("个人下单总量：", orderCount)
    print("完单数量：", finishedCount)
    print("取消单数量：", cancelCount)
    print("未完单数量：", unfinishedCount)
    print("风控拦截总量：", safetyCount - charteredCount)

    # 分控拦截子项原因
    safetyQuery = \
        " select count(1) safetyCount, risk_type, reason " \
        " from risk_record " \
        " where city_id = 44 " \
        " and create_date >= '%s' " \
        " and create_date <= '%s' " \
        " group by risk_type " % (day_start_str, day_end_str)
    safety_cursor.execute(safetyQuery)
    results = safety_cursor.fetchall()
    for safetyData in results:
        safetyCount = safetyData[0]
        risk_type = safetyData[1]
        reason = safetyData[2]
        if risk_type == 1000:
            continue
        if risk_type == 4001:
            print("       【纯C用户】先享后付风险分超标, 派假单", "(", safetyCount, ")")
            continue
        print("      ", reason, "(", safetyCount, ")")

    # 日期递增
    date_start += datetime.timedelta(days=1)

# 关闭数据库
order_cursor.close()
safety_cursor.close()
