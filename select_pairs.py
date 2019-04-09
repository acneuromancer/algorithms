'''
Given an integer array, output all the unique pairs that sum up to a specific value k.
'''

def pair_sum(array, k):
    
    if len(array) < 2:
        return print("Too small")
        
    result = []
           
    for i in range(len(array)):
        for j in range(i+1, len(array)):
            counter += 1
            if array[i] + array[j] == k:
                result.append((array[i], array[j]))
    
    return result


def pair_sum_2(array, k):
    
    if len(array) < 2:
        return print("Too small")
    
    seen = set()
    output = set()
    
    for num in array:
        target = k - num
        
        if target not in seen:
            seen.add(num)
        else:
            output.add((min(num, target), max(num, target)))
    
    return output
    
    
array = [2, 6, -1, 10, 5, 4, 3]
print(pair_sum(array, 8))
print(pair_sum_2(array, 8))
