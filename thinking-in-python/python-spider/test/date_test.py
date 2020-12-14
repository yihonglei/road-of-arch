import datetime

if __name__ == "__main__":
    dd = "2020-01-19 22:10:09"

    dd2 = int(datetime.datetime.strptime(dd, "%Y-%m-%d %H:%M:%S").strftime("%Y%m%d"))

    print(dd2)
