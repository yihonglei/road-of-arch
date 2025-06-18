#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 5
int main(void) {
    int arr[] = {1, 2, 3, 4, 5};
    int* p = (int*) malloc(sizeof(int) * N);
    memcpy(p, arr, sizeof(int) * N);
    for (int i = 0; i < N; ++i) {
       printf("%d\n", *(p + i));
    }

    free(p);
    return 0;
}