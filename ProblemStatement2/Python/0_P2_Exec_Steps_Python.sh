cd /home/training/udacity_training/code/P2

gunzip ../../Input_Data/access_log.gz

hadoop fs -rm -r acc_p2q1
hadoop fs -rm -r acc_p2q2
hadoop fs -rm -r acc_p2q3

hadoop fs -mkdir acc
hadoop fs -put ../../Input_Data/access_log acc/

hadoop fs -rm -r acc_p2q1
head -n 10  ../../data/access_log | ./P2Q1_Mapper.py | ./P2Q1_Reducer.py 
time hs P2Q1_Mapper.py P2Q1_Reducer.py acc acc_p2q1
hadoop fs -get acc_p2q1/part* acc_p2q1.tsv

hadoop fs -rm -r acc_p2q2
head -n 10  ../../data/access_log | ./P2Q2_Mapper.py | ./P2Q2_Reducer.py 
time hs P2Q2_Mapper.py P2Q2_Reducer.py acc acc_p2q2
hadoop fs -get acc_p2q2/part* acc_p2q2.tsv

hadoop fs -rm -r acc_p2q3
head -n 10  ../../data/access_log | ./P2Q3_Mapper.py | ./P2Q3_Reducer.py 
time hs P2Q3_Mapper.py P2Q3_Reducer.py acc acc_p2q3
hadoop fs -get acc_p2q3/part* acc_p2q3.tsv
