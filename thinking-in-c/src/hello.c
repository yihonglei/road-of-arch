//
// Created by yihonglei on 2024/2/29.
//

#include "hello.h"

int removeDuplicates(int* nums, int numsSize) {
    int left = 1;
    for (int right = 1; right < numsSize; right++) {
        if (nums[right] != nums[right - 1]) {
            nums[left++] = nums[right];
        }
    }

    return left;
}