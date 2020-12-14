from urllib import parse

"""
url参数解析和获取
"""
if __name__ == "__main__":
    url = "https://www.douban.com/misc/captcha?id=QsKJwIpGVy8DVryiE5SLU3ow:en&size=s"
    url_parse = parse.urlparse(url)
    query = url_parse.query
    captcha_id_one = parse.parse_qs(query).get("id")[0]
    print(captcha_id_one)

    captcha_id_two = parse.parse_qs(parse.urlparse(url).query).get("id")[0]
    print(captcha_id_two)
