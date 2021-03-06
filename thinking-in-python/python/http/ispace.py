# -*- coding: utf-8 -*-
import requests
import time
from bs4 import BeautifulSoup
import json
import datetime
from src.save import Save
from config.settings import *
from src.email import Email

"""
中国航天科工集团有限公司(https://www.ispacechina.com/)
@author yihonglei
"""
# 请求头配置
headers = {
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36",
    "Host": "bd.ispacechina.com",
    "Cookie": ""
}


class ISpaceChina:
    def __init__(self, list_url):
        # 文章列表url
        self.list_url = list_url
        # 文章内容详情url
        self.detail_url = ""
        # 文章标题
        self.title = ""
        # 文章列表内容
        self.list_info = ""
        # 详情html
        self.detail_html = ""

    """
    文章列表
    """

    def get_article_list(self):
        try:
            response = requests.get(self.list_url, headers=headers)
            self.list_info = response.text
        except:
            print("ispacechina-文章列表-EXCEPTION(" + time.strftime("%Y-%m-%d %H:%M:%S") + "):请求页面时发生异常")

    """
    文章详细内容html
    """

    def get_article_detail_html(self):
        try:
            detail_html = requests.get(self.detail_url, headers=headers)
            self.detail_html = detail_html.text
        except:
            print("ispacechina-文章详细内容-EXCEPTION(" + time.strftime("%Y-%m-%d %H:%M:%S") + "):请求页面时发生异常")

    """
    文章标题
    """

    def get_article_detail_title(self):
        try:
            bs = BeautifulSoup(self.detail_html, "lxml")
            self.title = bs.find("div", class_="zbztb_filetit").h3.text
        except:
            print("ispacechina-EXCEPTION(" + time.strftime("%Y-%m-%d %H:%M:%S") + "):请求页面时发生异常")


def fetch_ispacechina(pageNo):
    try:
        for i in range(pageNo):
            # 文章列表页码
            page = i + 1
            list_url = "https://bd.ispacechina.com/showZbggListAjax.do?ispage=1&pageSize=10&page=%s" % page
            i_space_china = ISpaceChina(list_url)
            i_space_china.get_article_list()
            # 文章列表循环处理
            json_data = json.loads(i_space_china.list_info)
            articles = json_data.get('data').get('zbgglist').get('result')
            for article in articles:
                publish_time = int(datetime.datetime.strptime(article.get("ptdate"), "%Y-%m-%d %H:%M:%S").strftime("%Y%m%d"))
                date_time = int(time.strftime("%Y%m%d"))
                if publish_time != date_time:
                    continue
                # 获取详情
                probid = article.get("probid")
                detail_url = "https://bd.ispacechina.com/exp/bidding/sell/signup/toZbggInfo.do?probid=%s" % probid
                i_space_china.detail_url = detail_url
                i_space_china.get_article_detail_html()
                i_space_china.get_article_detail_title()
                # 保存文件
                save_file = Save(I_SPACE_CHINA_WEBSITE[0], i_space_china.title, i_space_china.detail_html)
                response = save_file.save_html()
                file_path = response[1]
                file_name = response[2]
                if response[0]:
                    print("ispacechina_file_path=", file_path)
                    # 邮件发送
                    email = Email(I_SPACE_CHINA_WEBSITE[0], I_SPACE_CHINA_WEBSITE[1], file_path, file_name, detail_url)
                    email.send_email()
    except:
        print("ispacechina-EXCEPTION(" + time.strftime("%Y-%m-%d %H:%M:%S") + "):文件邮件发送异常")


# test
if __name__ == "__main__":
    fetch_ispacechina(1)
