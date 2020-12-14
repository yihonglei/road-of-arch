import redis

r = redis.Redis(host='10.6.202.104', port=6381, password='qBa39fA&?@-o')
r.set('key:test', 'test-hello')
print(r.get('key:test'))
