# 예제 1 거스름돈
# 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정
# 거슬러 줘야 할 돈이 N원일 때 거슬러 줘야 할 동전의 최소 개수

# n = int(input()) # n은 거스름돈
# # n에서 제일 먼저 500원을 계산하자
# count500 = 0
# count100 = 0
# count50 = 0
# count10 = 0
# while(n >= 500) :
#     n -= 500
#     count500 += 1
# while(n >= 100):
#     n -= 100
#     count100 += 1
# while(n >= 50):
#     n -= 50
#     count50 += 1
# while(n >= 10) :
#     n -= 10
#     count10 += 1
# print(count500, count100, count50, count10)

n = 1260
count = 0
# 큰 단위의 화폐부터 차례대로 확인
coin_types = [500, 100, 50, 10]

for coin in coin_types:
    count += n // coin # 해당 화폐로 거슬러 줄 수 있는 동전의 개수 세기
    n %= coin
print(count)

