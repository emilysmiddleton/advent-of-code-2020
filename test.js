 'use strict';

const fs = require("fs");
const path = require('path');

// Please forgive me, that's all I can do when I don't feel like googling regex
const explodeFuckingBrackets = (line) => {
    return line.split(' ').reduce((acc, v) => {
        if (v !== ' ') {
            const num = v.match(/\d+/);
            const hasFuckingBrackets = num && (num[0].length < num.input.length);
            if (hasFuckingBrackets) {
                const location = num.input[0] === '(' ? 1 : 0;
                const diff = num.input.length - num[0].length;
                const brackets = location === 1 ? num.input.substring(0, diff) : num.input.substring(num[0].length, num.input.length)
                acc = location === 0 ? [...acc, num[0], ...brackets.split('')] : [...acc, ...brackets.split(''), num[0]]
            } else {
                acc = [...acc, v];
            }
        }
        return acc;
    }, []);
};

const getNewLine = (testLine, value) => {
    const firstArr = testLine.slice(0, value.splitIndexes[0]);
    const secondArr = testLine.slice(value.splitIndexes[1] + 1, testLine.length);
    return [...firstArr, value.value, ...secondArr];
};

// find lowest level bracket
const calcBracket = (testLine) => {
    const brackets = ['(', ')']

    const findNotNested = (test) => {
        let state = 'closed';
        let temp = [];

        test.forEach((v, i) => {
            if (state === 'finish') {
                return;
            }

            if (state === 'closed' && v === '(') {
                state = 'open';
            }

            if (state === 'open' && !brackets.includes(v)) {
                temp = [...temp, {i, v}];
            }

            if (state === 'open' && v === '(') {
                // reset array;
                temp = [];
            }

            if (state === 'open' && v === ')') {
                state = 'finish';
                return;
            }
        });

        return temp;
    }

    return findNotNested(testLine);
}

const calcLevel = (level) => {
    let opMemo = '+';
    const value = level.reduce((acc, item, ind) => {
        const { i, v } = item;

        if (ind === 0) {
            return acc;
        }

        switch (v) {
            case '+':
                opMemo = '+';
                return acc;
            case '*':
                opMemo = '*';
                return acc;
            default:
                acc = opMemo === '+' ? acc + Number(v) : acc * Number(v);
        }

        return acc;
    }, Number(level[0].v));

    const splitIndexes = [level[0].i - 1,  level[level.length - 1].i + 1]
    return { value, splitIndexes }
}

const calcAllBrackets = (testLine) => {
    const bracket = calcBracket(testLine);

    while (bracket.length > 0) {
        const nestedValue = calcLevel(bracket);
        const newLine = getNewLine(testLine, nestedValue)
        return calcAllBrackets(newLine);
    }

    return testLine.map((v, i) => {
        return { i, v }
    })
}

// part 2
const doOperation = (level, op) => {
    let temp = [];
    let shifter = [...level];
    let lastValueToOp = null;

    for (let j = 0; j < level.length; j++) {
        const { i, v } = shifter[j];

        if (v === op) {
            const value = op === '+' ? Number(lastValueToOp) + Number(shifter[j + 1].v)
                : Number(lastValueToOp.v) * Number(shifter[j + 1].v);
            lastValueToOp = value;
            j++;
            temp.pop();
            temp = [...temp, value];
        } else {
            lastValueToOp = shifter[j].v;
            temp = [...temp, shifter[j].v];
        }
    }
    return [...temp];
}

const calcLevelWithDiffPrecedence = (level) => {
    const additionResult = doOperation(level, '+');
    const multiplicationResult = additionResult.reduce((acc, v) => {
        if (v !== '*') {
            acc *= Number(v);
        }
        return acc;
    }, 1);

    const splitIndexes = [level[0].i - 1,  level[level.length - 1].i + 1]
    return { value: multiplicationResult, splitIndexes }
}

const calcAllBracketsWithDiffPrecedence = (testLine) => {
    const bracket = calcBracket(testLine);

    while (bracket.length > 0) {
        const nestedValue = calcLevelWithDiffPrecedence(bracket);
        const newLine = getNewLine(testLine, nestedValue)
        return calcAllBracketsWithDiffPrecedence(newLine);
    }

    return testLine.map((v, i) => {
        return { i, v }
    })
}


// Part 1
const calcAllLines = (rawLines) => {
    const calc = rawLines.reduce((acc, line) => {
        const explodedLine = explodeFuckingBrackets(line);
        const finalLine = calcAllBrackets(explodedLine);
        const finalCalc = calcLevel(finalLine);
        acc += finalCalc.value;
        return acc;
    }, 0)

    return calc;
}

// Part 2
const calcAllLinesPt2 = (rawLines) => {
    const calc = rawLines.reduce((acc, line) => {
        const explodedLine = explodeFuckingBrackets(line);
        const finalLine = calcAllBracketsWithDiffPrecedence(explodedLine);
        const finalCalc = calcLevelWithDiffPrecedence(finalLine);
        acc += finalCalc.value;
        return acc;
    }, 0)

    return calc;
}


const day18Solution = () => {
    const raw = fs.readFileSync(path.join(__dirname + '/input.txt'), 'utf8').split(/\n/);

    const resPt1 = calcAllLines(raw);
    const resPt2 = calcAllLinesPt2(raw);


    return {
        part1: resPt1,
        part2: resPt2
    }
}

module.exports = {
    day18Solution
}