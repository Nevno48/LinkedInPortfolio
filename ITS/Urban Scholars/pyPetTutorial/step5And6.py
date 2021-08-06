# run me in your terminal
# by typing "python3 pypet.py"
# and pressing enter

# variables
photo = "~<:<<<<<>"
name = "Jafar"
age = 62
weight = 3.5
hungry = True

# use three spaces to indent
def startup_pypet():
    print("Welcome to pypet")

def pypet_stats():
    print("Hello, I'm " + name + "!")
    print(photo)
    print(name + "weighs " + str(weight) + " pounds.")

    if(hungry):
        print("Your pypet is hungry.")
    else:
        print("Your pypet *BURPS* loudly!")

    if(weight > 5):
        print("Thats a BIG pypet!!")

startup_pypet()

# a new boolean for checking when to end the program
terminate = False

# while terminate is NOT true - keep running the program
while not terminate:
    # prints a line
    print("##############################################################")

    #asks user for input
    user_input = input("> ")

    #allows user to quit
    if(user_input == "quit"):
        terminate = True

    #allows user to feed pypet
    #elif is another type of if statement
        elif(user_input == "feed"):
            print("Omnomnom, you feed your pypet!")
            #increase weight when fed
            weight = weight + 1
            # since your pypet is no longer hungry, set hungry to False after fed
            hungry = False

        elif(user_input == "stats"):
            pypet_stats()

        else:
            print("Command not recognized, please try \"feed\", \"stats\", or \"quit\".")
#add a quitting statement outside of the loop
print("Bye! See you next time!")














    
