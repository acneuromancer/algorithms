def max_sub_array_1(a):
    '''Function to find the maximum contiguous subarray.'''
    
    max_so_far = max_ending_here = a[0]
    
    for i in range(1, len(a)):
        max_ending_here = max_ending_here + a[i]
        
        if max_so_far < max_ending_here:
            max_so_far = max_ending_here
            
        if max_ending_here < 0:
            max_ending_here = 0
            
    return max_so_far


def max_sub_array_indexes(a):
    max_so_far = max_ending_here = a[0]
    start = end = s = 0
    
    for i in range(1, len(a)):
        max_ending_here = max_ending_here + a[i]
        
        if max_so_far < max_ending_here:
            max_so_far = max_ending_here
            start = s
            end = i
            
        if max_ending_here < 0:
            max_ending_here = 0
            s = i+1
    
    return (start, end)
                

a = [-2, -3, 4, -1, -2, 1, 5, -3]
print(a)
print(max_sub_array_indexes(a))

