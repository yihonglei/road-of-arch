//
// Created by yihonglei on 2023/5/20.
//

#include "stdio.h"

#include "hello.h"

#define NUM1 10

int main() {
    printf("NUM1: %d", NUM1);

    int nums[] = {1, 2, 2};

    int left = removeDuplicates(nums, 3);
    printf("left: %d", left);
    return 0;
}