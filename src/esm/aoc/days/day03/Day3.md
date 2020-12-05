# Problem description

See [Advent Of Code](https://adventofcode.com/2020/day/3) for full problem description.

The input creates a grid, where some squares have trees, and some are empty.

If we start at the top left-hand corner and follow a slope down to the end of
the grid, how many trees does the toboggan encounter?

* Part 1: How many trees does the toboggan encounter on the slope right 3, down 1?
* Part 2: How many trees does the toboggan encounter on the slopees
  * right 1, down 1
  * right 3, down 1
  * right 5, down 1
  * right 7, down 1
  * right 1, down 2  

# Data Model

The input forms a grid, so we can use the common
[Grid data structure](../../models/grid/Grid.java).

There are no separators between the grid items. A space with a `#` signified a tree; 
a `.` is a clear space.

The additional complication is that the grid repeats:
>These aren't the only trees, though; ...the same pattern repeats to the right many times:

For a grid of width 10 that infinitely repeats to the right, 
* (10, y) is equivalent to (0, y)
* (11, y) is equivalent to (1, y)
* (12, y) is equivalent to (2, y)
* (20, y) is equivalent to (0, y)
* etc

We have introduced a new [infinite width grid](../../models/grid/InfiniteWidthGrid.java).
This takes the [modulo](https://en.wikipedia.org/wiki/Modulo_operation) of the x coordinate before performing look-up.

# Solution - Part 1

The bulk of the work in this task is the parsing of the grid.
We have a grid, and we have a [coordinate](../../models/grid/Coordinate2D.java)
reference that has `right` and `down` methods.

Keep applying `right 3 left 1` to the coordinate and adding 1 to the total if that
square contains a tree. We know we are finished when the `getItem` method returns `null`,
meaning we've dropped off the bottom of the grid.

# Solution - Part 2

Part two drops out from part 1 - reuse the method we've already created to
traverse a slope, with different parameters. Multiply the results.
