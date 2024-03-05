//
// Created by yihonglei on 2023/5/20.
//

#include "stdio.h"

#include "hello.h"

#define NUM1 10 // 定义宏常量

typedef struct { // 结构
    int ip;
    int port;
} CONN;

int main() {
    // 宏常量
    printf("NUM1: %d\n", NUM1);
    // 多文件函数调用
    int nums[] = {1, 2, 2};
    int left = removeDuplicates(nums, 3);
    printf("left: %d\n", left);
    // typedef
    const CONN conns[] = {{1, 2},
                          {3, 4}};
    for (int i = 0; i < (sizeof(conns) / sizeof(CONN)); i++) {
        printf("ip:%d, port:%d\n", conns[i].ip, conns[i].port);
    }

    return 0;
}