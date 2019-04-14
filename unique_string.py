"""
Given a string, are all characters unique?
Should give a True or False return.
Use Python built in structures.
"""

def unique(string):
    count = {}
    
    for letter in string:
        count[letter] = 1 if letter not in count else count[letter]+1
        
    for key in count:
        if count[key] != 1:
            return False
            
    return True


def unique_2(string):
    return len(set(string)) == len(string)    

    
print(unique("Hello there, how are you?"))
print(unique("Who"))
print(unique("Howdy!"))

print(unique_2("Hello there, how are you?"))
print(unique_2("Who"))
print(unique_2("Howdy!"))



    
    
