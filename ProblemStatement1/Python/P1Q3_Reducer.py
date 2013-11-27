#!/usr/bin/python

# Find the total sales value across all the stores, and the total number of sales. Assume there is only one reducer.

import sys

salesTotal = 0
transactions = 0

for line in sys.stdin:
    data_mapped = line.strip().split("\t")
    if len(data_mapped) != 2:
        # Something has gone wrong. Skip this line.
        continue

    salesTotal += float(data_mapped[1])
    transactions += 1

print transactions, "\t", salesTotal

