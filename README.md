# Advent of Code 2020

[Advent of Code 2020](https://adventofcode.com/) coming soon!

Some years I have more time than others, but I usually like to include an explanation of the code / algorithms as well as the code itself.
This year I'm about to start using Java professionally again, so using this as a way to ease myself back into it.

## General Approach

Each puzzle follows the same pattern:

- **Extract** the puzzle input
- **Transform** the puzzle input into a data model
- **Solve** the puzzle

An interface is provided for each step, and [a utility class](src/esm/aoc/etl/DaySolver.java) pulls
the three together to read the input from file and return the answer.

## Example

* [Day 0](src/esm/aoc/days/day00/Day0.md) - Day 1 of 2019 as an example of the framework.

## Solutions

* [Day 1](src/esm/aoc/days/day01/Day1.md) - Report Repair
* [Day 2](src/esm/aoc/days/day02/Day2.md) - Password Philosophy
* [Day 3](src/esm/aoc/days/day03/Day3.md) - Toboggan Trajectory
* [Day 4](src/esm/aoc/days/day04/Day4.md) - Passport Processing
* [Day 5](src/esm/aoc/days/day05/Day5.md) - Binary Boarding
