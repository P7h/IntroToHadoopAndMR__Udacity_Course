#!/usr/bin/python

#  Write a MapReduce program which will display the number of hits for each different file on the Web site.

import sys
from urlparse import urlparse

# 10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] "GET /assets/js/lowpro.js HTTP/1.1" 200 10469
# Find the first index and last index of ", so that we can get the request line.
# And then from this, get the exact document requested by splitting this string on empty space.

for line in sys.stdin:
	line = line.strip()
	firstIndex = line.find("\"")
	lastIndex = line.rfind("\"")
	if(firstIndex > 1 and lastIndex > 2):
		requestString = line[firstIndex+1:lastIndex]
		actualUrl = requestString.split(" ")[1]
		docname = urlparse(actualUrl)
		print "{0}\t{1}".format(docname.path, 1)
