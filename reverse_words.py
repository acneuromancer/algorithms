"""
Given a string of words, reverse all the words.
start = "This is the best."
finish = "best the is This."
"""

def reverse(s):
    word_list = s.split()
    word_list.reverse()
    
    return word_list
    
    
def reverse_2(s):
    return " ".join(reversed(s.split()))


def reverse_3(s):
    length = len(s)
    words = []
    chars_to_skip = [",", ";", "-", "?", "!", ".", " "]
    i = 0
    
    while i < length:
        if s[i] not in chars_to_skip:
            j = i
            word = ""
            while j < length and s[j] not in chars_to_skip:
                word += s[j]
                j += 1
            
            words.insert(0, word)
            i = j+1
        else:
            i += 1
            
    return words


def reverse_4(s):
    return " ".join(s.split()[::-1])
    
    
print(reverse("Hello there, how are you?"))
print(reverse_2("Hello there, how are you?"))
print(reverse_3("Hello  there ! ; ;;, how are you ?"))
print(reverse_4("Hello there, how are you?"))
