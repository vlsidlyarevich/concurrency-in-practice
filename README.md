# concurrency-in-practice
Java concurrency exercises

## Producer-consumer (or shared buffer) problem
Create an application which represents producer-consumer problem and meets following:
* threads run in parallel
* there should be only one thread in each critical section
* threads should end their work in measurable amount of time 
* performance should me measurable

#### Solutions
* Basic solution with blocking non fair algorithm (write until buffer is full, consume until buffer is empty) with
native java tools (object monitor: wait/notify/syncronized) - [link](https://github.com/vlsidlyarevich/concurrency-in-practice/blob/master/src/com/github/vlsidlyarevich/concurrency_practice/producer_consumer/basic/Main.java)
* Advanced (and i would say more correct) solution built on usage of Reentrant locks and
atomic booleans. Supports multiple consumers with fair poll (first in, first out), producer tries to put same value 
if buffer is full. Consumer tries to poll until buffer has at least one item - [link](https://github.com/vlsidlyarevich/concurrency-in-practice/blob/master/src/com/github/vlsidlyarevich/concurrency_practice/producer_consumer/advanced/Main.java)

## Dining philosophers problem 
Five silent philosophers sit at a round table with bowls of spaghetti. A single chopstick is placed between each pair of adjacent philosophers.
Each philosopher must alternately think and eat. However, a philosopher can eat spaghetti only when they have both left as well as right pair of chopsticks. 
Each of chopsticks can be held by one and only one philosopher and so a philosopher can use them only if it is not being used by another philosopher. 
After an individual philosopher finishes eating, they need to put down both the chopsticks in their original positions so that the chopsticks become available to the others at the table. 
A philosopher can only take the chopsticks on their right and the one on their left as they become available and they cannot start eating before getting both the chopsticks.
Eating is not limited by the remaining amounts of spaghetti or stomach space; an infinite supply and an infinite demand are assumed.
The problem is how to design a discipline of behavior (a concurrent algorithm) such that no philosopher will starve; i.e., 
each can forever continue to alternate between eating and thinking, assuming that no philosopher can know when others may want to eat or think.

<img src="https://github.com/vlsidlyarevich/concurrency-in-practice/blob/master/docs/images/Dining_philosophers.png" width=50% height=50% alt="Dining philosophers">
