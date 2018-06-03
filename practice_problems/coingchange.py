# problem: https://www.hackerrank.com/challenges/coin-change/problem

def getWays(amount, coins):
    compination = [0]*(amount+1)
    compination[0] = 1

    for c in coins:
        for i in range(amount+1):
            if i >= c:
                compination[i] += compination[i-c]
    return compination[-1]

print(getWays(4, [1, 2, 3]))
