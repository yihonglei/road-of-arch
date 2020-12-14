# -*- coding: utf-8 -*-
from src.websites.ispacechina import *
import time

"""
程序运行主体
@author yihonglei
"""


def main():
    while True:
        # 中国航天科工集团有限公司(https://www.ispacechina.com/)
        fetch_ispacechina(1)
        time.sleep(5)
