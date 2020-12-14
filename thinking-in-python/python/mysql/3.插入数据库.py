import pymysql

# 打开数据库连接
db = pymysql.connect("localhost", "root", "lanhuigu", "lanhuigu_web")

# 使用cursor()方法创建一个游标对象cursor
cursor = db.cursor()

# SQL 插入语句
sql = """INSERT INTO EMPLOYEE(FIRST_NAME,
         LAST_NAME, AGE, SEX, INCOME)
         VALUES ('Mac', 'Mohan', 20, 'M', 2000)"""

try:
    # 执行SQL
    cursor.execute(sql)
    # 提交事务
    db.commit()
except:
    # 如果执行过程发生异常，回滚
    db.rollback()

# 关闭数据库连接
db.close()
