from rediscluster import RedisCluster

try:
    # 构建所有的节点，Redis会使⽤CRC16算法，将键和值写到某个节点上
    nodes = [
        {"host": "10.6.202.104", "port": 6381, },
        {"host": "10.6.202.105", "port": 6381},
        {"host": "10.6.202.106", "port": 6381},
        {"host": "10.6.202.104", "port": 6380},
        {"host": "10.6.202.105", "port": 6380},
        {"host": "10.6.202.106", "port": 6380}
    ]
    # 构建RedisCluster对象
    redis_conn = RedisCluster(startup_nodes=nodes, password='qBa39fA&?@-o', decode_responses=True)

    # 设置键为key1、值为test-hello-world的数据
    result = redis_conn.set('key1', 'test-hello-world')
    print(result)
    # 获取键为name
    name = redis_conn.get('key1')
    print(name)
except Exception as e:
    print(e)
