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



