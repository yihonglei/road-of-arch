# -*- coding: utf-8 -*-
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.application import MIMEApplication
from config.settings import *

"""
邮件发送
@author yihonglei
"""


class Email:
    def __init__(self, title, file_path, file_name, article_url):
        self.title = title
        self.file_path = file_path
        self.file_name = file_name
        self.article_url = article_url

    def send_email(self):
        # MIMEMultipart对象代表邮件本身
        msg = MIMEMultipart()
        msg["Subject"] = self.title
        msg["From"] = EMAIL_USER
        msg["To"] = ';'.join(EMAIL_TO_LIST)

        # 正文内容
        part = MIMEText("您好，我好，大家好!")
        msg.attach(part)

        # 附件
        part = MIMEApplication(open(self.file_path, 'rb').read())
        part.add_header('Content-Disposition', 'attachment', filename=self.file_name)
        msg.attach(part)

        # 邮件服务
        email_server = smtplib.SMTP_SSL(EMAIL_HOST)
        # email_server = smtplib.SMTP(EMAIL_HOST, timeout=30)  # 连接smtp邮件服务器,端口默认是25
        email_server.connect(EMAIL_HOST, 465)
        email_server.login(EMAIL_USER, EMAIL_PASSWORD)  # 登陆服务器
        email_server.sendmail(EMAIL_USER, EMAIL_TO_LIST, msg.as_string())  # 发送邮件
        email_server.close()
