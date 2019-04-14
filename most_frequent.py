"""
Given an array find out what the most frequent element is.
"""

def most_frequent(a_list):
    
    count = {}
    max_val = 0
    max_key = None
        
    for key in a_list:
        count[key] = 1 if key not in count else count[key] + 1
        if count[key] > max_val:
            max_key = key
            max_val = count[key]
    
    return max_key


print(most_frequent([5, 0, 5, 1, 1, 5, -1, 5, 2, 3, 4]));
