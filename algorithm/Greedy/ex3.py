# 실전예제 3 숫자 카드 게임
n, m = map(int, input().split())
result = 0
for _ in range(n):
    data = list(map(int, input().split()))
    data.sort()
    min = data[0]
    if result < min:
        result = min
print(result)
