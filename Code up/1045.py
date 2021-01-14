# 1045 : [기초-산술연산] 정수 2개 입력받아 자동 계산하기
a, b = input().split()
a = int(a)
b = int(b)
sum = a + b
diff = a - b
mul = a * b
m = a // b
d = a % b
div = a / b

print("%d\n%d\n%d\n%d\n%d\n%f" %(sum, diff, mul, m, d, div))