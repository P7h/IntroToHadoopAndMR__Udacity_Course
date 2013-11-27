#!/usr/bin/python

#  Write a MapReduce program which will display the number of hits for each different file on the Web site.

import sys

countTotal = 0
oldKey = None

# Loop around the data
# It will be in the format key\tval
#

for line in sys.stdin:
    data_mapped = line.strip().split("\t")
    if len(data_mapped) != 2:
        # Something has gone wrong. Skip this line.
        continue

    thisKey, thisCount = data_mapped

    if oldKey and oldKey != thisKey:
        print oldKey, "\t", countTotal
        oldKey = thisKey;
        countTotal = 0

    oldKey = thisKey
    countTotal += int(thisCount)

if oldKey != None:
    print oldKey, "\t", countTotal

