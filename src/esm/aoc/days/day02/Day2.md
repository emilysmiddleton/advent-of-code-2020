# Problem description

See [Advent Of Code](https://adventofcode.com/2020/day/2) for full problem description.

Each line is a description of a password policy and a password, e.g.
```1-3 a: abcde```

In each part the password policy should be interpreted differently.

- Part 1: How many passwords are valid according to their policies?
- Part 2: How many passwords are valid according to the new interpretation of the policies?

# Data Model

Each line gives the password policy and then the password. 
There are four fields to extract, the first three making up the policy, and the fourth is the password itself.
- First number
- Second number
- A character
- The password

These can be extracted from the line using a [regular expression](https://www.w3schools.com/java/java_regex.asp).

```(\d+)-(\d+) ([a-z]): (.+)```

Parts of the string are 'grouped' by brackets. Each group corresponds to one of the parts above.
- The first group, `\d+`. `\d` means "any digit", and `+` means "at least one".
- The second group, `\d+`, as above
- The third group, `[a-z]`, means "a single character from a to z".
- The fourth group, `.+`, means "at least one of any character".

A `Pattern` is constructed from this regex string. This can be reused.
 
```PATTERN = Pattern.compile("(\\d+)-(\\d+) ([a-z]): (.+)");```

This is applied to each line with a `Matcher`.

```Matcher matcher = PATTERN.matcher(input);```

The `Matcher` allows each group to be referenced separately.

```int first = Integer.parseInt(matcher.group(1));```
            
# Solution - Part 1

In part 1, the policy to apply is:
> The password policy indicates the lowest and highest number of times 
> a given letter must appear for the password to be valid.

So for each line, we count the number of times that the given character appears in the password,
then check it is within the allowed range.

# Solution - Part 2

In part 2, the policy to apply is:
> Each policy actually describes two positions in the password, where 1 means the first character, 
> 2 means the second character, and so on.
> Exactly one of these positions must contain the given letter.

For the policy `1-3 a: abcde`, we can get the characters to compare using
[substring](https://www.w3schools.com/java/java_strings.asp)

We want exactly one to match: this can be written succinctly with exclusive or - 
[XOR](https://www.w3schools.com/java/java_operators.asp) - "a or b but not both".
This is the `^` symbol in Java.

