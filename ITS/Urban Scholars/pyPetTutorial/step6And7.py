# here is our new import statement to use the random module
import random

photo = "~<:<<<<<>"
name = "Jafar"
age = 62
weight = 3.5
hungry = True

# our new list variable for our pypet's phrases
phrases = ["SSSSssssSSSSSSssSSssS", "Hi, Friend!", "Mlem"]

# define new function to chat with your pypet
def chat_with_pypet():
    print("Your pypet says: ")
    print(random.choice(phrases))
    
def startup_pypet():
    print("Welcome to pypet")
    print(random.choice(phrases))

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

terminate = False

while not terminate:
    print("##############################################################")

    user_input = input("> ")

    if(user_input == "quit"):
        terminate = True

    elif(user_input == "feed"):
        print("Omnomnom, you feed your pypet!")
        weight = weight + 1
        hungry = False

    elif(user_input == "stats"):
        pypet_stats()

    #add your new function to your while loop to be used
    elif(user_input == "chat"):
        chat_with_pypet()

    else:
        print("Command not recognized, please try \"feed\", \"stats\", or \"quit\".")
print("Bye! See you next time!")














    
