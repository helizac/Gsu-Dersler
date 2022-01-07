import numpy as np
import matplotlib.pyplot as plt
import matplotlib
import random


class agent:
    def __init__(self, start_x=0, start_y=0, target_x=random.choice(
        [random.randint(-18, -11), random.randint(-8, -1), random.randint(1, 8), random.randint(11, 18)]),
                 target_y=random.choice(
                     [random.randint(-18, -11), random.randint(-8, -1), random.randint(1, 8), random.randint(11, 18)]),
                 possible_genes=['left', 'right', 'down', 'up']):
        self.start_x, self.start_y = start_x, start_y
        self.x, self.y = self.start_x, self.start_y
        self.target_x, self.target_y = target_x, target_y
        self.pathx, self.pathy = [self.start_x], [self.start_y]

        self.possible_genes = possible_genes
        self.take_action = {'left': self.go_left, 'right': self.go_right, 'down': self.go_down, 'up': self.go_up}

        self.m = abs(target_x) + abs(target_y)
        self.create_genotype()
        self.phenotype()

    obstacle1 = [(x, 9) for x in range(1, 11)] + [(x, 10) for x in range(1, 11)]
    obstacle2 = [(9, y) for y in range(10, 0, -1)] + [(10, y) for y in range(10, 0, -1)]

    obstacle3 = [(x, -9) for x in range(1, 11)] + [(x, -10) for x in range(1, 11)]
    obstacle4 = [(9, y) for y in range(-1, -11, -1)] + [(10, y) for y in range(-1, -11, -1)]

    obstacle5 = [(x, -9) for x in range(-1, -11, -1)] + [(x, -10) for x in range(-1, -11, -1)]
    obstacle6 = [(-9, y) for y in range(-1, -11, -1)] + [(-10, y) for y in range(-1, -11, -1)]

    obstacle7 = [(x, 9) for x in range(-1, -11, -1)] + [(x, 10) for x in range(-1, -11, -1)]
    obstacle8 = [(-9, y) for y in range(1, 11)] + [(-10, y) for y in range(1, 11)]

    obstacles = obstacle1 + obstacle2 + obstacle3 + obstacle4 + obstacle5 + obstacle6 + obstacle7 + obstacle8

    def go_left(self):
        self.x = self.x - 1
        if (self.x, self.y) in self.obstacles:
            self.x = self.x + 1
            self.take_action[random.choice(['right', 'down', 'up'])]()

    def go_right(self):
        self.x = self.x + 1
        if (self.x, self.y) in self.obstacles:
            self.x = self.x - 1
            self.take_action[random.choice(['left', 'down', 'up'])]()

    def go_down(self):
        self.y = self.y - 1
        if (self.x, self.y) in self.obstacles:
            self.y = self.y + 1
            self.take_action[random.choice(['right', 'left', 'up'])]()

    def go_up(self):
        self.y = self.y + 1
        if (self.x, self.y) in self.obstacles:
            self.y = self.y - 1
            self.take_action[random.choice(['right', 'down', 'left'])]()

    def create_genotype(self):
        self.genome = np.random.choice(self.possible_genes, size=self.m)

    def set_gene(self, new_gene):
        self.genome = new_gene.copy()
        self.phenotype()

    def phenotype(self):
        self.pathx, self.pathy = [self.start_x], [self.start_y]
        self.x, self.y = self.start_x, self.start_y
        for gene in self.genome:
            self.take_action[gene]()

            self.pathx.append(self.x)
            self.pathy.append(self.y)

    def fitness(self):
        error_x = (self.target_x - self.pathx[-1])
        error_y = (self.target_y - self.pathy[-1])
        return 1 / (1 + np.sqrt(error_x ** 2 + error_y ** 2))

    def draw(self, verbose=True):
        if verbose:
            print(self.genome)

        figure = plt.figure()
        ax = figure.add_subplot(1, 1, 1)

        ticks = np.arange(-25, 25, 1)

        ax.set_xticks(ticks)
        ax.set_yticks(ticks)

        ax.grid(alpha=1)

        ax.axis([-15, 15, -15, 15])
        #ax.axis([-2 if self.x > 0 else 2, self.x + 2 if self.x > 0 else self.x - 2, -2 if self.y > 0 else 2, self.y + 2 if self.y > 0 else self.y - 2])

        rect1 = matplotlib.patches.Rectangle((1, 9), 9, 1)
        rect2 = matplotlib.patches.Rectangle((9, 1), 1, 9)

        rect3 = matplotlib.patches.Rectangle((1, -10), 9, 1)
        rect4 = matplotlib.patches.Rectangle((9, -10), 1, 9)

        rect5 = matplotlib.patches.Rectangle((-10, -10), 9, 1)
        rect6 = matplotlib.patches.Rectangle((-10, -10), 1, 9)

        rect7 = matplotlib.patches.Rectangle((-10, 9), 9, 1)
        rect8 = matplotlib.patches.Rectangle((-10, 1), 1, 9)

        ax.add_patch(rect1)
        ax.add_patch(rect2)
        ax.add_patch(rect3)
        ax.add_patch(rect4)
        ax.add_patch(rect5)
        ax.add_patch(rect6)
        ax.add_patch(rect7)
        ax.add_patch(rect8)

        ax.plot(0, 0, 'o', markersize=10)
        ax.plot(self.target_x, self.target_y, 'g*', markersize=30)
        ax.plot(self.pathx[-1], self.pathy[-1], 'r^', markersize=25)
        ax.plot(self.pathx, self.pathy)

        ax.grid()


class evolution:
    def __init__(self, N=20, possible_genes=['left', 'right', 'down', 'up']):
        self.N = N
        self.possible_genes = possible_genes
        self.population = [agent() for i in range(N)]
        self.fitness_values = [self.population[i].fitness() for i in range(N)]

        total_fitness = sum(self.fitness_values)
        self.reproduction_probabiliy = [val / total_fitness for val in self.fitness_values]

        self.best_agent = self.population[np.argmax(self.fitness_values)]

    def selection(self):
        parents = np.random.choice(self.N, size=2, p=self.reproduction_probabiliy)
        return parents

    def crossover(self, parent0, parent1):
        cutoff = np.random.randint(len(parent0.genome))
        child = np.concatenate((parent0.genome[:cutoff], parent1.genome[cutoff:]))
        return child

    def mutation(self, child):
        mutation_point = np.random.randint(len(child.genome))
        child.genome[mutation_point] = np.random.choice(self.possible_genes)

    def create_offspring(self):
        parents = self.selection()
        P0, P1 = self.population[parents[0]], self.population[parents[1]]

        child_agent = agent()
        child_genome = self.crossover(parent0=P0, parent1=P1)
        child_agent.set_gene(child_genome)
        self.mutation(child_agent)
        child_agent.phenotype()

        return child_agent

    def create_new_population(self):
        new_population = [self.create_offspring() for i in range(self.N - 1)] + [self.best_agent]
        self.population = new_population

        self.fitness_values = [self.population[i].fitness() for i in range(self.N)]
        total_fitness = sum(self.fitness_values)
        self.reproduction_probabiliy = [val / total_fitness for val in self.fitness_values]
        self.best_agent = self.population[np.argmax(self.fitness_values)]

    def evolve(self, G=10):
        for i in range(G):
            self.create_new_population()
        return self.best_agent


world = evolution()
world.evolve(1000)

world.best_agent.draw()

plt.grid()
plt.show()