list = ['one'] * 5

list2 = ['five', 'six']

list_all = list + list2

print(list_all)

# list的下标从0开始计算
for i in range(len(list_all)):
    if i == 5:
        print(list_all[i])
        break
