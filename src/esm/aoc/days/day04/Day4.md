# Problem description

See [Advent Of Code](https://adventofcode.com/2020/day/4) for full problem description.

Out input is a list of passport information with a number of fields such as birth year.

* Part 1: How many passports have all required fields
* Part 2: How many passports have valid values for all fields

# Data Model

A single passport can be split over multiple lines. A blank line signifiers the end of one
passport block.

A line is e.g.
```ecl:gry pid:860033327 eyr:2020 hcl:#fffffd```

Single spaces separate each key/value pair, so extract them using `line.split(" ")"`.
Then split each key/value pair on `:`.

# Solution - Part 1

Our data model is a list of [Passports](Passport.java), each of which contains values
for the given fields.

A passport is valid if it has a non-null value for every field. Add a method on the `Passport` 
class which returns its status, filter to all valid passports, and count the results.

# Solution - Part 2

For part 1, we only needed to know if a field existed. For part 2, we will need to do
some further parsing of the values. 

## Numeric fields

Fields `byt`, `iyr`, and `eyr` are all years. We can parse the string as a number
and check if it lies within two dates.

## Pattern fields

Fields `hcl`, `ecl`, and `pid` we want to check match a particular pattern. We can use
a [regular expression](https://www.w3schools.com/java/java_regex.asp).

> hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.

Pattern is `#[a-f,0-9]{6}`
* `#` is the single character
* `[a-f,0-9]` is a character group of characters from a to f or 0 to 9.
* `{6}` means exactly six of the previous character group.

> ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.

Pattern is `amb|blu|brn|gry|grn|hzl|oth`. The pipes `|` mean "or".

> pid (Passport ID) - a nine-digit number, including leading zeroes.

Pattern is `[0-9]{9}`
* `[0-9]` is a character group of characters from 0 to 9.
* `{6}` means exactly nine of the previous character group.

## Height

The `hgt` field we need to both match to a pattern (cm or in) and make an assertion about its value.

Pattern is `(\d+)(cm|in)`
* `(\d+)` 1 or more digits 0-9
* `(cm|in)` either `cm` or `in`

Then use the capturing groups to extract the values and perform the check.
