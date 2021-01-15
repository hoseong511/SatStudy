# 실전예제 2 큰 수의 법칙
# 5 8 3
# 2 4 5 4 6
# 6 6 6 5 6 6 6 5 = 46
import time

n, m, k = map(int, input().split())
data = list(map(int, input().split()))
# 현재 이 리스트 안에서 가장 큰 수를 찾아내는 것이 먼저!
start = time.time()
data.sort()
print(data)
n1 = data[n-1] # 1번째로 큰 수
n2 = data[n-2] # 2번째로 큰 수
# 조건 1: 큰 수를 m 번 더하기
sum = 0
count = 0
for _ in range(m): # 조건 2: k번이 연속되도록 숫자가 나오면 안됨.

    if (count < k) :
        sum += n1
        count += 1
    else:
        sum += n2
        count = 0
print(sum)
# 가장 큰 수가 더해지는 횟수 계산
# count = int( m / (k+1)) * k
# count += m % (k+1)
# result = 0
# result += (count) * n1
# result += (m-count) * n2
# print( result )

print(start)
print(time.time())
print(time.time()-start)
# for num in data :

