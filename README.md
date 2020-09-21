# concurrency-in-practice
Java concurrency exercises

## Producer-consumer (or shared buffer) problem
Create an application which represents producer-consumer problem and meets following:
* threads run in parallel
* there should be only one thread in each critical section
* threads should end their work in measurable amount of time 
* performance should me measurable

#### Solutions
* Basic solution with blocking non fair algorithm (write untill buffer is full, consume until buffer is empty) with
native java tools (object monitor: wait/notify/syncronized)


