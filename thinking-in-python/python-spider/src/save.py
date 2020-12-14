# -*- coding: utf-8 -*-
import time
from src.util.file_util import *

"""
文件保存
@author yihonglei
"""


class Save:
    def __init__(self, website, title, data):
        self.website = website
        self.title = title
        self.data = data

    def save_csv(self):
        pass

    def save_word(self):
        pass

    def save_html(self):
        try:
            # 基础路径
            date_time = time.strftime("%Y-%m-%d")
            base_path = "/u01/spider/data/" + date_time
            # 创建目录
            create_dir_by_date(base_path)
            file_name = self.website + "-" + self.title + ".html"
            file_path = base_path + "/" + file_name
            # 判断文件是否存在，存在则直接返回False
            is_exists = file_exists(file_path)
            if is_exists:
                return [False, file_path, file_name]
            # 创建文件
            create_file_by_title(file_path)
            # 文件写入
            io = open(file_path, "w")
            io.write(self.data)
            io.close()
        except:
            print("EXCEPTION(" + time.strftime("%Y-%m-%d %H:%M:%S") + ")", "website:" + self.website)

        return [True, file_path, file_name]
