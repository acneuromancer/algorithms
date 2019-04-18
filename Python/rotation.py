"""
Give 2 arrays (assume no duplicates).
Is one array a rotation of another? (Same size and elements but start index is different.) Return True or False.
"""

def rotation_1(arr1, arr2):
    
    def find_index(arr, num):
        i = 0
        while i < len(arr) and arr[i] != num:
            i += 1
            
        return i if i < len(arr) else -1
    
    if len(arr1) != len(arr2):
        return False
    
    start_index = find_index(arr2, arr1[0])
    
    if not start_index > 0:
        return False
    
    for i in range(len(arr1)):
        arr2_index = (start_index + i) % len(arr1)
        if arr1[i] != arr2[arr2_index]:
            return False
    
    return True


def rotation_2(arr1, arr2):
    
    if len(arr1) != len(arr2):
        return False
    
    start_index = 0
    
    for i in range(len(arr2)):
        if arr1[0] == arr2[i]:
            start_index = i
            break
            
    if start_index == 0:
        return False
        
    for i in range(len(arr1)):
        arr2_idx = (start_index + i) % len(arr1)
        if arr1[i] != arr2[arr2_idx]:
            return False
            
    return True
        

print(rotation_1([1, 2, 3, 4], [3, 4, 1, 2]))
print(rotation_1([1, 2, 3, 4], [1, 2, 3, 4]))
print(rotation_1([0, 1, 2, 3, 4], [3, 4, 1, 2]))
print(rotation_1([1, 2, 3, 4], [2, 3, 4, 1]))
print()    
print(rotation_2([1, 2, 3, 4], [3, 4, 1, 2]))
print(rotation_2([1, 2, 3, 4], [1, 2, 3, 4]))
print(rotation_2([0, 1, 2, 3, 4], [3, 4, 1, 2]))
print(rotation_2([1, 2, 3, 4], [2, 3, 4, 1]))

    

    
