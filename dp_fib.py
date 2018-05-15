computed = {}
n = int(input())

# up-bottom
def fast_fib(n):
    if n in computed:
        return computed[n]
    if n <= 2:
        rv = 1
    else:
        rv = fast_fib(n-1) + fast_fib(n-2)
    computed[n] = rv
    return rv


# bottom-up this is more effcient as we won't make calls and consume stack
# def fast_fib(n):
#     for i in range(1, n+1):
#         if i <= 2:
#             rv = 1
#         else:
#             rv = computed[i-1] + computed[i-2]

#         computed[i] = rv

#     return computed[i]

print(fast_fib(n))
