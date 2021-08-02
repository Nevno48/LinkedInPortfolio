#import sense hat library
from sense_hat import SenseHat

#create object
sense = SenseHat()


#get sensor data
acceleration = sense.get_accelerometer_raw()
#separate data into coordinate plane
x = round(acceleration[“x”], 1)
y = round(acceleration[“y”], 1)
z = round(acceleration[“z”], 1)

#printf data to be presentable
printf(“x: %d \n y: %d \n z: %d” % (x, y, z))
