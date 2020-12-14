import re

import requests
from bs4 import BeautifulSoup

# 请求字典
req_header = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
    'Accept-Encoding': 'gzip, deflate, sdch, br',
    'Accept-Language': 'zh-CN,zh;q=0.8',
    'Cache-Control': 'max-age=0',
    'Connection': 'keep-alive',
    'Cookie': 'UM_distinctid=165c0eb51a95a7-0c5f1e30c8c4cd-323f5c0f-144000-165c0eb51aa7c8; bcolor=; font=; size=; fontcolor=; width=; CNZZDATA1260821856=941700315-1536539302-https%253A%252F%252Fwww.baidu.com%252F%7C1536648034',
    'Host': 'www.biqugex.com',
    'If-Modified-Since': 'Mon, 25 Jun 2018 00:09:02 GMT',
    'If-None-Match': '"1529885342"',
    'Referer': 'https://www.biqugex.com/s.php?ie=gbk&s=9157106854577873494&q=%C6%DF%BD%E7%CE%E4%C9%F1',
    'Upgrade-Insecure-Requests': '1',
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36'
}

# 小说下载函数
# id：小说编号
# txt字典项介绍
# title：小说题目
# first_page：第一章页面
# txt_section：章节地址
# section_name：章节名称
# section_text：章节正文
# section_ct：章节页数
req_url_base = 'https://www.biqugex.com'  # 小说主页


def get_txt(txt_id):
    txt = {}
    txt['title'] = ''
    txt['id'] = str(txt_id)

    try:
        print("输入要下载的小说编号")
        txt['id'] = input()
        req_url = req_url_base + '/book_' + txt['id'] + '/'  # 获取小说url
        # print('小说路径：'+ req_url)
        res = requests.get(req_url, params=req_header)  # 获取小说目录界面
        soups = BeautifulSoup(res.text, "html.parser")  # soups 转换
        txt['title'] = soups.select('.book .info h2')[0].text  # 获取小说题目
        txt['author'] = soups.select('.book .info .small span')  # 获取小说详细信息
        txt['intro'] = soups.select('.book .info .intro ')  # 获取小说简介
        txt['author'][0].text  # 作者
        txt['author'][1].text  # 分类
        txt['author'][2].text  # 是否连载
        txt['author'][3].text  # 字数
        txt['author'][4].text  # 最后更新时间
        txt['author'][5].text  # 最新章节
        first_page = soups.select('.listmain dl dd a')  # 获取章节地址
        #   first_page = first_page[6]['href']  # 截取小说第一章
        #   section_next = first_page
        list = []
        # 循环截取每章地址存入list
        for i in range(len(first_page)):
            list.append(first_page[i]['href'])
        io = open('{0:0>8}-{1}.txt'.format(txt['id'], txt['title']), "ab+")
        io.write(txt['title'].encode('UTF-8'))  # 写入小说名字
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['author'][0].text.encode('UTF-8'))  # 写入作者
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['author'][1].text.encode('UTF-8'))  # 写入分类
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['author'][2].text.encode('UTF-8'))  # 写入是否连载
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['author'][3].text.encode('UTF-8'))  # 写入字数
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['author'][4].text.encode('UTF-8'))  # 写入最后更新时间
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['author'][5].text.encode('UTF-8'))  # 写入最近章节
        io.write('\r\n'.encode('UTF-8'))
        io.write(txt['intro'][0].text.encode('UTF-8'))  # 写入小说简介
        io.write('\r\n'.encode('UTF-8'))
        # 进入循环 下载每章内容
        # 循环每章内容写入txt
        for i, val in enumerate(list[6:]):
            # print(req_url_base + val)
            # r = requests.get(str(req_url_base + str(first_page)), params=req_header)
            r = requests.get(str(req_url_base + val), params=req_header)
            soup = BeautifulSoup(r.text, "html.parser")  # soup转换
            section_name = soup.select('#wrapper .book.reader .content h1')[0]  # 获取章节名称
            section_text = soup.select('#wrapper .content .showtxt')[0]  # 获取章节文本
            # 删除无用项
            for ss in section_text.select("script"):
                ss.decompose()
            section_text = re.sub('\s+', '\r\n\t', section_text.text).strip('\r\n')  # 格式化
            #   section_next = soup.select('#wrapper .book.reader .content .page_chapter ul li a')[2]  # 获取分页
            #   section_next = section_next['href']  # 截取下一章地址
            #   print(section_next)
            # 开始写入内容
            io.write('\n'.encode('UTF-8'))
            io.write(section_name.text.encode('UTF-8'))  # 写入标题
            io.write('\n'.encode('UTF-8'))
            io.write(section_text.encode('UTF-8'))  # 写入小说内容
            io.write('\n'.encode('UTF-8'))
            print('下载 ', section_name, '完成')  # 提示

    finally:
        print('{0:0>8}-{1}.txt'.format(txt['id'], txt['title']), '下载完成')
        io.close()


get_txt(99999)

