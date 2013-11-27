#!/usr/bin/python

# Find the monetary value for the highest individual sale for each separate store.

import sys

highestSale = 0
oldKey = None

# It will be in the format key\tval
# Where key is the store name, val is the sale amount

for line in sys.stdin:
    data_mapped = line.strip().split("\t")
    if len(data_mapped) != 2:
        # Something has gone wrong. Skip this line.
        continue

    thisKey, thisSale = data_mapped
    thisSale = float(thisSale)
    if thisSale > highestSale:
        highestSale = thisSale

    if oldKey and oldKey != thisKey:
        print oldKey, "\t", highestSale
        oldKey = thisKey;
        highestSale = 0

    oldKey = thisKey

if oldKey != None:
    print oldKey, "\t", highestSale

