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

    
print(reverse("Hello there, how are you?"))
print(reverse_2("Hello there, how are you?"))
