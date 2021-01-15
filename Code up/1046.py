# 1046 : [기초-산술연산] 정수 3개 입력받아 합과 평균 출력하기
a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)

sum = a + b + c
avg = sum / 3
print("%d\n%.1f" %(sum, avg))