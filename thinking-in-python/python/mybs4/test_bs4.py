from bs4 import BeautifulSoup
import requests
from w3lib.html import remove_tags

if __name__ == "__main__":
    url = "https://blog.csdn.net/yhl_jxy/article/details/103968635"
    html = requests.get(url).text
    # print(remove_tags(html))
    soup = BeautifulSoup(html, "lxml")  # html.parser lxml
    print(soup.body.text)  # 去除html 标签
    # # articles = soup.find() # 查找一个
    # # articles = soup.find_all("div",class_="post floated-thumb")
    # # print(len(articles))
    # articles = soup.find_all("div",attrs={"class":"post floated-thumb"})
    # for article in articles:
    #     title_a = article.find("a",class_="archive-title1")
    #     detail_url = title_a.get("href") if title_a else "detail_url没有获取成功"
    #     title = title_a.text if title_a else "title没有获取成功"
    #     print(detail_url)
    #     print(title)
