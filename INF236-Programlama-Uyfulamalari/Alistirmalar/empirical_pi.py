import random

INTERVAL = 10000

circle_points = 0

# Total Random numbers generated= possible x
# values* possible y values
for i in range(INTERVAL):

    #point(x,y)
    point = (random.uniform(-1, 1), random.uniform(-1, 1))

    distance = point[0] ** 2 + point[1] ** 2

    if distance <= 1:
        circle_points += 1

pi = 4 * circle_points / INTERVAL

print("Final Estimation of Pi=", pi)