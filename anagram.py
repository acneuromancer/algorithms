def anagram(s1, s2):
    
    s1 = s1.replace(' ','').lower()
    s2 = s2.replace(' ','').lower()
    
    return sorted(s1) == sorted(s2)


def anagram_2(s1, s2):
    
    s1 = s1.replace(' ','').lower()
    s2 = s2.replace(' ','').lower()
    
    # check if same number of letters
    if len(s1) != len(s2):
        return False
    
    # count frequency of each letter
    count = {}
    
    for letter in s1:
        if letter in count:
            count[letter] += 1
        else:
            count[letter] =1
    
    for letter in s2:
        if letter not in count:
            return False
        
        count[letter] -= 1
        
    for key in count:
        if count[key] != 0:
            return False
    
    return True


def anagram_3(s1, s2):
    
    s1 = s1.replace(' ','').lower()
    s2 = s2.replace(' ','').lower()
    
    str_list = list(s1)
    
    for letter in s2:
        if letter not in str_list:
            return False
        
        str_list.remove(letter)
    
    return str_list == []


def anagram_4(s1, s2):
    
    s1 = s1.replace(" ", "").lower()
    s2 = s2.replace(" ", "").lower()
    
    if len(s1) != len(s2):
        return False
    
    str_list = list(s2)
    still_ok = True
    pos1 = 0
    
    while pos1 < len(s1) and still_ok:
        pos2 = 0
        found = False
        
        while pos2 < len(str_list) and not found:
            if s1[pos1] == str_list[pos2]:
                found = True
            else:
                pos2 += 1
        if found:
            str_list[pos2] = None            
        else:
            still_ok = False
        
        pos1 += 1
        
    return still_ok

    
print(anagram_4("dog", "God"))
print(anagram_4("Clint Eastwood", "old West action"))
print(anagram_4("dog", "dodge"))
