# Problem description

* [Part 1](./Part1.md)
* [Part 2](./Part2.md)

# Data Model

Each input line is an integer representing the mass of a module. 
Wrap this in a class [Module](Module.java);

# Solution - Part 1

For each module, calculate the fuel required:
 - fuel required = mass / 3 (rounded down) - 2
 
Rounding down is achieved with `Math.floor`

Add up all modules for the puzzle answer.

# Solution - Part 2

Similar to part 1, but calculation is more involved.
 - calculate fuel required as before
 - then calculate the fuel required for that fuel
 - repeat until you start getting negative answers
 - add them up
 
`Math.max` is used to return 0 in place of a negative number.

Add up all modules as before for the puzzle answer.
