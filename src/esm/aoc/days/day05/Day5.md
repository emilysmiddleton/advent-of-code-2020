# Problem description

See [Advent Of Code](https://adventofcode.com/2020/day/5) for full problem description.

The input is a list of boarding passes which encode the row and seat number on the plane.

# Data Model

An encoded seat position looks like `BBFFBFBRLL`.
We can split this into:
* The first 7 characters, `BBFFBFB`, describing the row
* The last 3 characters, `RLL`, describing the column.

The use of back/front versus left/right isn't a helpful distinction - for the
purposes of determining the position they mean the same thing, first half or second half.

Convert these to a list of booleans - true for front/left and false for back/right.

# Solution - Part 1

We need to convert each seat description into a row/column pair using **binary space partitioning**.
Binary - two - refers to reducing the number of possibilities in half each time.

A partition has a minimum value and a maximum value. The total size is the difference
between the two.
* If we want to keep the first half, reduce the max by half the total size.
* If we want to keep the second half, increase the min by half the total size.

The min starts at 0, the maximum is either 128 (7 instructions, 2^7) or 8
(3 instructions, 2^7). Apply the instructions in order, resulting in a partition of size 1 - our answer.

Perform a binary space partition for both the row and column, then calculate the ID 
```row * 8 + column```

Part 1 requires us to find the maximum ID - apply this function to all inputs and return the max.

# Solution - Part 2

Part 1 enabled us to calculate the ID of every boarding pass in the input.
We are trying to find the missing ID that is somewhere in the middle.

Create a set of all IDs, then loop through all possible ID values. Our answer
is the value `n` where the set doesn't contain `n`, but does contain `n-1` and `n+1`. 
