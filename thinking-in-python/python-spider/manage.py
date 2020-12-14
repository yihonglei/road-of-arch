# -*- coding: utf-8 -*-
from bin.main import main

if __name__ == '__main__':
    main()

"""
python-spider/
|-- bin/
|   |-- __init__.py
|   |-- main.py         程序运行主体程序
|-- config/
|   |-- __init__.py
|   |-- settings.py     程序配置
|-- src/                程序主体模块
|   |-- __init__.py
|   |-- util.py         工具包
|   |-- websites.py     网站文章爬取
|   |-- cookie.py       网站cookie模拟
|   |-- email.py        邮件发送
|   |-- save.py         文件存储
|-- manage.py           程序启动文件
|-- README.md           程序使用说明
"""
