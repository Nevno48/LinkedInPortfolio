#!/bin/python3
import os
import time

counter = -1
ForC = "M"

def Fahrenheit(num):
        num = num.replace("temp=","")
        num= num.replace("'C","")
        num= (float(num) * 9/5) + 32
        return num

def Celsius(num):
        num = os.popen("vcgencmd measure_temp").readline()
        num = num.replace("temp=","")
        num = num.replace("'C","")
        num = float(num)
        return num

while not(ForC == "C" or ForC == "F"):
    print("Do you want to measure in 'F or 'C?")
    ForC = input("Enter F for Fahrenheit, or C for Celsius:")
    ForC = str(ForC)

while (counter <= 0):
    print("How many seconds do you want to read the temperature?")
    counter = input("Enter the number of seconds:")
    counter = int(counter)

if ForC == "F":
    while counter > 0:
        cmd = os.popen("vcgencmd measure_temp").readline()
        temp = Fahrenheit(cmd)
        print("Temperature is " + str(temp) + "'F")
        time.sleep(1)
        counter = counter - 1
        
elif ForC == "C":
    
    while counter > 0:
        cmd = os.popen("vcgencmd measure_temp").readline()
        temp = Celsius(cmd)
        print("Temperature is " + str(temp) + "'C")
        time.sleep(1)
        counter = counter - 1

