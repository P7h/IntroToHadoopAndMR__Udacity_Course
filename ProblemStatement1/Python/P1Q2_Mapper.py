#!/usr/bin/python

# Find the monetary value for the highest individual sale for each separate store.

# Format of each line is:
# date\ttime\tstore name\titem description\tcost\tmethod of payment

import sys

for line in sys.stdin:
    data = line.strip().split("\t")
    if len(data) == 6:
        date, time, store, item, cost, payment = data
        print "{0}\t{1}".format(store, cost)

