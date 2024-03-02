//
// Created by yihonglei on 2024/3/2.
//

#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <assert.h>
#include <stdbool.h>

#define BOOL_TRUE 1  // 定义用到的宏常量与宏函数；
#define BOOL_FALSE 0
#define typename(x) _Generic((x), \
  unsigned short: "unsigned short int", \
  unsigned long: "unsigned long int", \
  default: "unknown")

typedef enum {
    Host, IP
} IP_ADDR_TYPE;  // 定义枚举类型 IP_ADDR_TYPE，用于表示联合中生效的字段；
typedef struct {  // 定义结构 CONN；
    size_t id;
    uint16_t port;
    bool closed;
    IP_ADDR_TYPE addr_type;
    union {
        char host_name[256];
        char ip[24];
    };
} CONN;

inline static const char *findAddr(const CONN *pip) {  // 定义函数 findAddr，用于打印 CONN 对象的信息；
    assert(pip != NULL);  // 运行时断言，判断传入的 CONN 指针是否有效；
    return pip->addr_type == Host ? pip->host_name : pip->ip;
}

int main(int argc, char *argv[]) {  // 入口函数；
    static_assert(sizeof(CONN) <= 0x400, "the size of CONN object exceeds limit.");  // 静态断言，判断 CONN 对象的大小是否符合要求；
    const CONN conns[] = {  // 构造一个数组，包含三个 CONN 对象；
            [2] = {1, 80, BOOL_TRUE, IP, {.ip = "127.0.0.1"}},
            [0] = {2, 8080, BOOL_FALSE, IP, {.ip = "192.168.1.1"}},
            {3, 8088, BOOL_FALSE, Host, {.host_name = "http://localhost/"}}
    };

    for (size_t i = 0; i < (sizeof(conns) / sizeof(CONN)); ++i) {  // 遍历上述 CONN 数组，并打印其中的内容；
        printf(
                "Port: %d\n"
                "Host/Addr: %s\n"
                "Internal type of `id` is: %s\n\n",
                conns[i].port,
                findAddr(&conns[i]),
                typename(conns[i].id)
        );
    }
    return EXIT_SUCCESS;
}