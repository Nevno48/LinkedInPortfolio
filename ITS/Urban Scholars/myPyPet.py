#!/bin/python3
import os
import signal
from time import sleep
"""
This object is a pet that is interacted through
a custom command line. Based on the input, the
pet grows or dies.
"""
#Choose a pet
"""
Snake     ~<:<<<<<>
Mouse     <:3)~~~
Cat       =(^O.O^)=
Baby Owl  ~(OvO)~
Fish      ><(((*>
Tarantula ///\oo/\\\
Snail     _@/
Worm      _/\_,
"""
#increases age per action
ageCounter = 0

#pets to choose from
pets = [
    ["snake" , "~<:<<<<<>"],
    ["mouse" , "<:3)~~~"],
    ["cat" , "=(^O.O^)="],
    ["baby owl" , "~(OvO)~"],
    ["fish" , "><(((*>"],
    ["tarantula" , "///\oo/\\\\\\"],
    ["snail" , "_@/"],
    ["worm"  , "_/\_,"]
    ]

#Dictionary
petProperties = {
    "photo": "",
    "name" : "",
    "age" : 12,
    "weight" : 15,
    "hungry" : True,
    "life" : "living"
}


"""
This method initiates the start of the program.
"""
def startupPypet():
    print("Welcome To Pypet!")
    sleep(0.5)
    print("Pet Shop Keeper: Welcome to My pet Store!!")
    sleep(0.5)
    print("Pet Shop Keeper: This is where you get to start and own a pet.")
    sleep(0.5)
    while(petProperties["photo"] == ""):
        print("Pet Shop Keeper: Choose what type of pet you want to own.")
        for x in range(len(pets)):
            print(pets[x][0] + "    " + pets[x][1])
        petForm = input("Enter the name of the type of pet:")
        for x in range(len(pets)):
            if(petForm == pets[x][0]):
                petProperties["photo"] = pets[x][1]
                break
    sleep(0.5)
    petProperties["name"] = input("Enter the pet's name:")

"""
This prints the stats and attributes of the pet.
"""
def pypetStats():
    print("Hello, my name is " + petProperties["name"] + "!")
    print(petProperties["photo"])
    print(petProperties["name"] + " weighs " + str(petProperties["weight"]) + " pounds.")
    print("I am %1.0d" % (petProperties["age"]))
    #is your pet like Nick G?
    if(petProperties["hungry"]):
        print("Your pet thing is hungry")
    else:
        print("Your pet thing is !hungry")

    #depends if pet if huge
    if(petProperties["weight"] > 15):
        print("Your pet is Thiccc")

"""
This shows all the commands the user can enter.
"""
def help():
    print("""
feed-increase weight
walk-decrease weight
stats-see name, photo, weight,and hunger
redbull-gives your pet wings to restart
move-see pet animal animation
""")

"""
This increases weight
"""
def feed():
    print("Pet is fed")
    petProperties["weight"] += 1
    hungry = False

"""
This decreases weight
"""
def walk():
    print("Pet had exercise")
    petProperties["weight"] -= 1
    hungry = True

"""
This kills the pet and restarts the game.
"""
def redbull():
    petProperties["photo"] = ""
    startupPypet()

"""
This makes an animation for the pet depending on the pet
"""
def move():
    
    #snake animation
    if(petProperties["photo"] == "~<:<<<<<>"):
        stage1 = "~<:<<<<<>"
        stage2 = "~<:<<<<<>>>>"
        stage3 = "~<;<<<<<>"
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #mouse animation
    elif(petProperties["photo"] == "<:3)~~~"):
        stage1 = """
<:3)~~~
        """
        stage2 =  """
 | |
<:3)~~~
 | |
        """
        stage3 =   """
<;3)~~~
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #cat animation
    elif(petProperties["photo"] == "=(^O.O^)="):
        stage1 = """
=(^O.O^)=
        """
        stage2 =  """
   ^ ^
=(^O.O^)=
  ^^^^^
        """
        stage3 =   """
=(^|.|^)=
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #owl animation
    elif(petProperties["photo"] == "~(OvO)~"):
        stage1 = """
~(OvO)~
        """
        stage2 =  """
  ^ ^
~(OvO)~
   ^
        """
        stage3 =   """
~(|v|)~
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #fish animation
    elif(petProperties["photo"] == "><(((*>"):
        stage1 = """
><(((*>
        """
        stage2 =  """
)<(((*>
        """
        stage3 =   """
><(((°>
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #tarantula animation
    elif(petProperties["photo"] == "///\oo/\\\\\\"):
        stage1 = """
///\oo/\\\\\\
        """
        stage2 =  """
\\\\\\\oo////
        """
        stage3 =   """
///\../\\\\\\
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #snail animation
    elif(petProperties["photo"] == "_@/"):
        stage1 = """
_@/
        """
        stage2 =  """
_@_
        """
        stage3 =   """
_@/°
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)
    #worm animation
    elif(petProperties["photo"] == "_/\_,"):
        stage1 = """
_/\_,
        """
        stage2 =  """
____,
        """
        stage3 =   """
_/\_.
        """
        print(stage1)
        sleep(.5)
        print(stage2)
        sleep(.5)
        print(stage1)
        sleep(.5)
        print(stage3)
        sleep(.5)
        print(stage1)
        sleep(.5)

        
    
            
#Starts pypet
startupPypet()

#boolean to start custom Terminal
terminate = False

#while loop to initiate terminal
while(not terminate):
    #divider for terminal
    print("#############################################")
    #cmd prompt
    userInput = input("adellGlados@adellglados:~$")
    #custom cmds
    petProperties["age"] += (1 / 8)
    if(userInput == ("quit")):
        terminate = True
    elif(userInput == ("help")):
        help()
    elif(userInput == ("feed")):
        feed()
    elif(userInput == ("walk")):
         walk()
    elif(userInput == ("stats")):
        pypetStats()
    elif(userInput == ("redbull")):
        redbull()
    elif(userInput == ("move")):
        move()
    else:
        print("Command not recognized, type help for more commands")
    
        

        
