# Birthday Paradox
The Birthday Paradox, also called the Birthday Problem, is the surprisingly high probability that two people will have the same birthday even in a small group of people. In a group of 70 people, there’s a 99.9 percent chance of two people having a matching birthday. But even in a group as small as 23 people, there’s a 50 percent chance of a matching birthday. This program performs several probability experiments to determine the percentages for groups of different sizes. We call these types of experiments, in which we conduct multiple random trials to understand the likely outcomes, Monte Carlo experiments.

More information 👉 [Birthday Paradox](https://en.wikipedia.org/wiki/Birthday_problem)

## How it works
You will be asked to input a number at the beginning of the program. This number will generate a group of dates based on the input and check to see if there is a matching date within this group. 

After, you will have the option to run a simulation. If you choose to do so, then the simulation will generate groups of dates of size **input**, 100,000 times, where, in each group of dates, there will be a check to see if there are any matching dates.

You will then be presented with the data, which will show the percentage of groups that had matching dates out of 100,000 groups.

## Example
```plaintext
How many birthdays shall I generate? (Max 100) 23

Here are 23 birthdays:
Oct 9, Sep 1, May 28, Jul 29, Feb 17, Jan 8, Aug 18, Feb 19, Dec 1, Jan 22,
May 16, Sep 25, Oct 6, May 6, May 26, Oct 11, Dec 19, Jun 28, Jul 29, Dec 6,
Nov 26, Aug 18, Mar 18
In this simulation, multiple people have a birthday on Jul 29

Generating 23 random birthdays 100,000 times.
Press ENTER to begin... (Or type in QUIT to exit simulation)
0 simulations run...
10000 simulations run...
20000 simulations run...
30000 simulations run...
40000 simulations run...
50000 simulations run...
60000 simulations run...
70000 simulations run...
80000 simulations run...
90000 simulations run...

Out of 100,000 simulations of 23 people, there was a matching birthday in that group 50691 times.
This means that 23 people have a 50.690999999999995% chance of having a matching birthday in their group.
```