# Introduction to Hadoop and MapReduce
----------

## Introduction
This repository contains source code for the assignments of Udacity's course, [Introduction to Hadoop and MapReduce](https://www.udacity.com/course/ud617), which was unveiled on 15th November, 2013.<br>
This is a short course by [Cloudera](http://www.cloudera.com) guys in association with [Udacity](https://www.udacity.com). Instructors for this course are Sarah Sproehnle and Ian Wrigley, both from Cloudera and Gundega Dekena, Course Developer is from Udacity.<br>

Course does not mandate any programming language for writing Hadoop MapReduce jobs; but they have mainly used / taught Hadoop MapReduce jobs using `Python` [i.e. with Hadoop Streaming approach for running jobs] during the course.<br>

I have developed Hadoop MapReduce code for the 2 problem statements [3 questions each] in 2 programming languages; `Python` as well as `Java`.<br>

## Instructions for Virtual Machine download and setup
Please refer [instructions document](IntroductiontoHadoopandMapreduce-VMsetup.doc) provided by Course Instructors for details on the Hadoop Virtual Machine [VM henceforth] setup required for running these examples.<br>
As mentioned in the above document, VM image with Hadoop installed and preconfigured, can be downloaded from [Udacity CDN](http://content.udacity-data.com/courses/ud617/Cloudera-Udacity-Training-VM-4.1.1.c.zip). 

Please be forewarned, the size of this compressed VM archive is 1.7 GB. Also it does not uncompress with either 7-Zip or Windows default Zip utility. You might have to use WinRAR or WinZip or even Cygwin unzip to uncompress the same, if you are on a Windows platform. On other Operating Systems, probably `unzip` command might work just fine. Uncompressed size of this VM is 4.2 GB.

Credentials to login to this Virtual Machine are: `training` / `training`. You will not need `root` access for any of the assignments of this Course. But just in case if you need, the password for `root` is `training`.

Please ensure that you configure the VM to at least 1.5 GB of RAM in [VMware Player](https://my.vmware.com/web/vmware/free#desktop_end_user_computing/vmware_player/6_0). It might run much better with 2 GB though. I have used VMware Player v5.0.2, the current latest version as of this writing [i.e. 28th November, 2013] is v6.0.1.

## Data
### Input Files
~~Input files for the problem statements [ProblemStatement#1](ProblemStatement1/0_Input) and [ProblemStatement#2](ProblemStatement2/0_Input) have also been uploaded to GitHub.~~<br> 

> *Update at 11/27/2013 10:00:26 PM IST*: Had to remove these input files from the repo as the GitHub Windows client is not able to sync the repo [or rather getting badly stuck with illegitimate alphabets] with these compressed archives.<br>

These input compressed archives can also be downloaded from Udacity servers. Please check [here](http://content.udacity-data.com/courses/ud617/purchases.txt.gz) for input file for Problem Statement 1 and [here](http://content.udacity-data.com/courses/ud617/access_log.gz) for Problem Statement 2.<br>
These links are also mentioned in the instructions document provided by Udacity Course Instructors.

### Output Files
Output for the problem statements [ProblemStatement#1](ProblemStatement1/1_Output) and [ProblemStatement#2](ProblemStatement2/1_Output) have also been uploaded to this GitHub repo for quick reference and validation of the output.<br>
This output is the Hadoop MR Job output which is obtained after processing and analyzing the specific question.

## [Problem Statement1](ProblemStatement1)
Execution steps are also documented for running the following in either [Python](ProblemStatement1/Python/0_P1_Exec_Steps_Py.sh) or [Java](ProblemStatement1/Java/0_P1_Exec_Steps_Java.sh).

### Question#1
Instead of breaking the sales down by store, instead give us a sales breakdown by product category across all of our stores.

1. What is the value of total sales for the following categories?
	- Toys
	- Consumer Electronics

#### Code
##### Java variant
[`P1Q1.java`](ProblemStatement1/Java/org/p7h/udacityhadoop/p1/P1Q1.java)

##### Python variant
[`P1Q1_Mapper.py`](ProblemStatement1/Python/P1Q1_Mapper.py) and [`P1Q1_Reducer.py`](ProblemStatement1/Python/P1Q1_Reducer.py)

#### Solution
Please check [`pur_p1q1.tsv`](ProblemStatement1/1_Output/pur_p1q1.tsv) for the output of this problem statement.

#### Execution Log files
Please check [`pur_p1q1.txt`](ProblemStatement1/2_ExecLogs/Java/pur_p1q1.txt) and [`pur_p1q1.txt`](ProblemStatement1/2_ExecLogs/Python/pur_p1q1.txt) for command line execution log files of Java and Python respectively.

### Question#2
Find the monetary value for the highest individual sale for each separate store.

1. What are the values for the following stores?
	- Reno
	- Toledo
	- Chandler

#### Code
##### Java variant
[`P1Q2.java`](ProblemStatement1/Java/org/p7h/udacityhadoop/p1/P1Q2.java)

##### Python variant
[`P1Q2_Mapper.py`](ProblemStatement1/Python/P1Q2_Mapper.py) and [`P1Q2_Reducer.py`](ProblemStatement1/Python/P1Q2_Reducer.py)

#### Solution
Please check [`pur_p1q2.tsv`](ProblemStatement1/1_Output/pur_p1q2.tsv) for the output of this problem statement.

#### Execution Log files
Please check [`pur_p1q2.txt`](ProblemStatement1/2_ExecLogs/Java/pur_p1q2.txt) and [`pur_p1q2.txt`](ProblemStatement1/2_ExecLogs/Python/pur_p1q2.txt) for command line execution log files of Java and Python respectively.

### Question#3
Find the total sales value across all the stores, and the total number of sales. Assume there is only one reducer.

1. Find
	- Total sales value across all the stores
	- Total number of sales

#### Code
##### Java variant
[`P1Q3.java`](ProblemStatement1/Java/org/p7h/udacityhadoop/p1/P1Q3.java)

##### Python variant
[`P1Q3_Mapper.py`](ProblemStatement1/Python/P1Q3_Mapper.py) and [`P1Q3_Reducer.py`](ProblemStatement1/Python/P1Q3_Reducer.py)

#### Solution
Please check [`pur_p1q3.tsv`](ProblemStatement1/1_Output/pur_p1q3.tsv) for the output of this problem statement.

#### Execution Log files
Please check [`pur_p1q3.txt`](ProblemStatement1/2_ExecLogs/Java/pur_p1q3.txt) and [`pur_p1q3.txt`](ProblemStatement1/2_ExecLogs/Python/pur_p1q3.txt) for command line execution log files of Java and Python respectively.

## [Problem Statement2](ProblemStatement2):
Execution steps are also documented for running the following in either [Python](ProblemStatement2/Python/0_P2_Exec_Steps_Py.sh) or [Java](ProblemStatement2/Java/0_P2_Exec_Steps_Java.sh).

### Question#1
Write a MapReduce program which will display the number of hits for each different file on the Web site.

1. Find
	- How many hits were made to the page: /assets/js/the-associates.js?

#### Code
##### Java variant
[`P2Q1.java`](ProblemStatement2/Java/org/p7h/udacityhadoop/p2/P2Q1.java)

##### Python variant
[`P2Q1_Mapper.py`](ProblemStatement2/Python/P2Q1_Mapper.py) and [`P2Q1_Reducer.py`](ProblemStatement2/Python/P2Q1_Reducer.py)

#### Solution
Please check [`acc_p2q1.tsv`](ProblemStatement2/1_Output/acc_p2q1.tsv) for the output of this problem statement.

#### Execution Log files
Please check [`acc_p2q1.txt`](ProblemStatement2/2_ExecLogs/Java/acc_p2q1.txt) and [`acc_p2q1.txt`](ProblemStatement2/2_ExecLogs/Python/acc_p2q1.txt) for command line execution log files of Java and Python respectively.

### Question#2
Write a MapReduce program which determines the number of hits to the site made by each different IP Address.
	
1. Find
	- How many hits were made by the IP address: 10.99.99.186?

#### Code
##### Java variant
[`P2Q2.java`](ProblemStatement2/Java/org/p7h/udacityhadoop/p2/P2Q2.java)

##### Python variant
[`P2Q2_Mapper.py`](ProblemStatement2/Python/P2Q2_Mapper.py) and [`P2Q2_Reducer.py`](ProblemStatement2/Python/P2Q2_Reducer.py)

#### Solution
Please check [`acc_p2q2.tsv`](ProblemStatement2/1_Output/acc_p2q2.tsv) for the output of this problem statement.

#### Execution Log files
Please check [`acc_p2q2.txt`](ProblemStatement2/2_ExecLogs/Java/acc_p2q2.txt) and [`acc_p2q2.txt`](ProblemStatement2/2_ExecLogs/Python/acc_p2q2.txt) for command line execution log files of Java and Python respectively.

### Question#3
Find the most popular file on the Web site. In other words, the file which had the most hits. Your Reducer should just write out the name of the file and number of hits into HDFS.

1. Find
	- Full path to the most popular file?
	- Number of hits to that file?

#### Code
##### Java variant
[`P2Q3.java`](ProblemStatement2/Java/org/p7h/udacityhadoop/p2/P2Q3.java)

##### Python variant
[`P2Q3_Mapper.py`](ProblemStatement2/Python/P2Q3_Mapper.py) and [`P2Q3_Reducer.py`](ProblemStatement2/Python/P2Q3_Reducer.py)

#### Solution
Please check [`acc_p2q3.tsv`](ProblemStatement2/1_Output/acc_p2q3.tsv) for the output of this problem statement.

#### Execution Log files
Please check [`acc_p2q3.txt`](ProblemStatement2/2_ExecLogs/Java/acc_p2q3.txt) and [`acc_p2q3.txt`](ProblemStatement2/2_ExecLogs/Python/acc_p2q3.log) for command line execution log files of Java and Python respectively.

## License
Copyright &copy; 2013 Prashanth Babu.<br>
Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
