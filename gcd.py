def gcd(x, y):
    # find Greatest Common Divisor [euclidean method]
    a = max(x, y)
    b = min(x, y)
    while b != 0:
        temp = b
        b = a % b
        a = temp
    return a


assert gcd(13, 13) == 13
assert gcd(37, 600) == 1
assert gcd(20, 100) == 20
