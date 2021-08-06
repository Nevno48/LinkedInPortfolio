import random

# here is our new dictionary to hold all of our variables
py_thon = {
    "photo" : "~<:<<<<<>",
    "name" : "Jafar",
    "age" : 62,
    "weight" : 3.5,
    "hungry" : True,
    "phrases" : ["SSSSssssSSSSSSssSSssS", "Hi, Friend!", "Mlem"]
}

# from here down you will need to change any variable that you added to the
# dictionary to py_thon["variableName"]
def chat_with_pypet():
    print("Your pypet says: ")
    print(random.choice(py_thon["phrases"]))
    
def startup_pypet():
    print("Welcome to pypet")
    print(random.choice(py_thon["phrases"]))

def pypet_stats():
    print("Hello, I'm " + py_thon["name"] + "!")
    print(py_thon["photo"])
    print(py_thon["name"] + "weighs " + str(py_thon["weight"]) + " pounds.")

    if(py_thon["hungry"]):
        print("Your pypet is hungry.")
    else:
        print("Your pypet *BURPS* loudly!")

    if(py_thon["weight"] > 5):
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
        py_thon["weight"] = py_thon["weight"] + 1
        hungry = False

    elif(user_input == "stats"):
        pypet_stats()

    #add your new function to your while loop to be used
    elif(user_input == "chat"):
        chat_with_pypet()

    else:
        print("Command not recognized, please try \"feed\", \"stats\", or \"quit\".")
print("Bye! See you next time!")














    
