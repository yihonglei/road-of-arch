from lxml import etree
import requests

if __name__ == "__main__":
    url = "https://blog.csdn.net/yhl_jxy"
    html = requests.get(url).text
    parser = etree.HTML(html)
    # title = parser.xpath("//*[@id='archive']/div[1]/div[2]/p[1]/a[1]/text()")
    # titles = parser.xpath("//a[@class='archive-title']/@href")
    # print(titles)
    articles = parser.xpath("//div[@class='post floated-thumb']")
    for article in articles:
        t = article.xpath("div[@class='post-meta']//a[@class='archive-title']")
        if t:
            href = t[0].attrib.get("href")
            title = t[0].text
            print(href, title)
        img = article.xpath("div[@class='post-thumb']//img//@src")
        if img:
            img = img[0]
            print(img)
