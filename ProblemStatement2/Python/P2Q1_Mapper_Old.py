#!/usr/bin/python

# URL that generated this code:
# http://txt2re.com/index-python.php3?s=10.223.157.186%20-%20-%20[15/Jul/2009:15:50:35%20-0700]%20%22GET%20/assets/js/lowpro.js%20HTTP/1.1%22%20200%2010469&4&-56&-139&-57&-140&-58&2&60&-137&29&61&3&-63&-62&20&18&-138&24&64&13

import sys
import re

txt = ['10.190.174.142 - - [03/Dec/2011:13:28:06 -0800] "GET /images/filmpics/0000/2229/GOEMON-NUKI-000163.jpg HTTP/1.1" 200 184976', '10.190.174.142 - - [03/Dec/2011:13:28:08 -0800] "GET /assets/js/javascript_combined.js HTTP/1.1" 200 20404', '10.190.174.142 - - [03/Dec/2011:13:28:09 -0800] "GET /assets/img/home-logo.png HTTP/1.1" 200 3892', '10.190.174.142 - - [03/Dec/2011:13:28:09 -0800] "GET /images/filmmediablock/360/019.jpg HTTP/1.1" 200 74446', '10.190.174.142 - - [03/Dec/2011:13:28:10 -0800] "GET /images/filmmediablock/360/g_still_04.jpg HTTP/1.1" 200 761555', '10.190.174.142 - - [03/Dec/2011:13:28:09 -0800] "GET /images/filmmediablock/360/07082218.jpg HTTP/1.1" 200 154609', '10.190.174.142 - - [03/Dec/2011:13:28:10 -0800] "GET /images/filmpics/0000/2229/GOEMON-NUKI-000163.jpg HTTP/1.1" 200 184976', '10.190.174.142 - - [03/Dec/2011:13:28:11 -0800] "GET /images/filmmediablock/360/GOEMON-NUKI-000163.jpg HTTP/1.1" 200 60117', '10.190.174.142 - - [03/Dec/2011:13:28:10 -0800] "GET /images/filmmediablock/360/Chacha.jpg HTTP/1.1" 200 109379', '10.190.174.142 - - [03/Dec/2011:13:28:11 -0800] "GET /images/filmmediablock/360/GOEMON-NUKI-000159.jpg HTTP/1.1" 200 161657']
#txt='10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] "GET /assets/js/lowpro.js HTTP/1.1" 200 10469'

re1='((?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))(?![\\d])'	# IPv4 IP Address 1
re2='( )'	# White Space 1
re3='(-)'	# Any Single Character 1
re4='( )'	# White Space 2
re5='(-)'	# Any Single Character 2
re6='( )'	# White Space 3
re7='(\\[.*?\\])'	# Square Braces 1
re8='(\\s+)'	# White Space 4
re9='(")'	# Any Single Character 3
re10='((?:[a-z][a-z0-9_]*))'	# Variable Name 1
re11='(\\s+)'	# White Space 5
re12='((?:\\/[\\w\\.\\-]+)+)'	# Unix Path 1
re13='( )'	# White Space 6
re14='((?:[a-z][a-z0-9_]*))'	# Variable Name 2
re15='((?:\\/[\\w\\.\\-]+)+)'	# Unix Path 2
re16='(")'	# Any Single Character 4
re17='( )'	# White Space 7
re18='(\\d+)'	# Integer Number 1
re19='(\\s+)'	# White Space 8
re20='(\\d+)'	# Integer Number 2

rg = re.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13+re14+re15+re16+re17+re18+re19+re20,re.IGNORECASE|re.DOTALL)
for t in sys.stdin:
    m = rg.search(t)
    if m:
        ipaddress1=m.group(1)
        ws1=m.group(2)
        c1=m.group(3)
        ws2=m.group(4)
        c2=m.group(5)
        ws3=m.group(6)
        sbraces1=m.group(7)
        ws4=m.group(8)
        c3=m.group(9)
        var1=m.group(10)
        ws5=m.group(11)
        unixpath1=m.group(12)
        ws6=m.group(13)
        var2=m.group(14)
        unixpath2=m.group(15)
        c4=m.group(16)
        ws7=m.group(17)
        int1=m.group(18)
        ws8=m.group(19)
        int2=m.group(20)
        #print "("+ipaddress1+")"+"("+ws1+")"+"("+c1+")"+"("+ws2+")"+"("+c2+")"+"("+ws3+")"+"("+sbraces1+")"+"("+ws4+")"+"("+c3+")"+"("+var1+")"+"("+ws5+")"+"("+unixpath1+")"+"("+ws6+")"+"("+var2+")"+"("+unixpath2+")"+"("+c4+")"+"("+ws7+")"+"("+int1+")"+"("+ws8+")"+"("+int2+")"+"\n"
        #print unixpath1
        print "{0}\t{1}".format(unixpath1, 1)
