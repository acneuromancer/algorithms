"""
Common Elements in Two Sorted Arrays
Return the common elements (as an array) between two sorted arrays of integers (ascending order).
Example: the common elements between [1, 3, 4, 6, 7, 9] and [1, 2, 4, 5, 9, 10] are [1, 4, 9]  
"""

def common_elements_1(a, b):
    result = []
    
    for num_a in a:
        for num_b in b:
            if num_a == num_b:
                result.append(num_a)
                break
                
    return result
    

def common_elements_2(a, b):
    result = []
    
    for num in a:
        i = 0
        while i < len(b) and num >= b[i]:
            if num == b[i]:
                result.append(num)
            i += 1
            
    return result
    

def common_elements_3(a, b):
    p1 = 0
    p2 = 0
    result = []
    
    while p1 < len(a) and p2 < len(b):
        if a[p1] == b[p2]:
            result.append(a[p1])
            p1 += 1
            p2 += 1
        elif a[p1] < b[p2]:
            p1 += 1
        else:
            p2 += 1
    
    return result         
    

a = [1, 3, 4, 6, 7, 9]
b = [1, 2, 4, 5, 9, 10]
print(common_elements_1(a, b))
print(common_elements_2(a, b))
print(common_elements_3(a, b))



    
