# Advent of Code 2020

[Advent of Code 2020](https://adventofcode.com/) coming soon!

Some years I have more time than others, but I usually like to include an explanation of the code / algorithms as well as the code itself.
This year I'm about to start using Java professionally again, so using this as a way to ease myself back into it.

## General Approach

Each puzzle follows the same pattern:

- **Extract** the puzzle input
- **Transform** the puzzle input into a data model
- **Solve** the puzzle

An interface is provided for each step, and [a utility class](esm/aoc/etl/DaySolver.java) pulls
the three together to read the input from file and return the answer.

## Days

* [Day 0](src/esm/aoc/days/day00/Day0.md) - Day 1 of 2019 as an example of the framework.

