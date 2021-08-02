# run me in your terminal
# by typing "python3 pypet.py"
# and pressing enter

# strings
photo = "~<:<<<<<>"
name = "Jafar"

# integer
age = 62

# float(decimal)
weight = 3.5

#booleans(can only be either True or False)
hungry = True

# The variables used here are already strings
# meaning they don't need to be converted
print("Hello, I'm " + name + "!")
print(photo)

#since weight is an integer
# you need to convert to a string
print(name + "weighs " + str(weight) + " pounds.")

if(hungry):
    print("Your pypet is hungry.")
else:
    print("Your pypet *BURPS* loudly!")

if(weight > 5):
    print("Thats a BIG pypet!!")
