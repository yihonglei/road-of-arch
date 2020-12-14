from pyquery import PyQuery as pq

if __name__ == "__main__":
    url = "http://blog.jobbole.com/all-posts/"
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"}
    doc = pq(url, headers=headers)  # html/url 返回 pyquery
    articles = doc("div.post.floated-thumb")
    for article in articles.items():
        title = article("a.archive-title")
        img = article("div.post-thumb a img[src$='.jpg']")
        print(img.attr("src"))
        print(title.text())
        print(title.attr("href"))
