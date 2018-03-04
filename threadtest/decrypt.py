import sys
import os

st = input('enter string: ')
n = int(input('enter number of iterations: '))

s = st
print('encrypting')
for i in range(n):
        s = s[::2] + s[1::2]
        print(i, s)

print('decrypting')
for i in range(n):
        breakpoint = len(s)//2
        if len(s) % 2 == 1:
                breakpoint += 1
        temp = zip(s[:breakpoint], s[breakpoint:])
        temp = ''.join([item for sublist in temp for item in sublist])
        if len(s) % 2 == 1:
                print(s, breakpoint)
                temp = temp + s[breakpoint - 1]
        s = temp
        print(i, s)
