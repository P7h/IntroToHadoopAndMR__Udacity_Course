gunzip ../../Input_Data/purchases.txt.gz

hadoop fs -rm -r pur_p1
hadoop fs -rm -r pur_p1q1
hadoop fs -rm -r pur_p1q2
hadoop fs -rm -r pur_p1q3

cd /home/training/udacity_training/code/P1/

hadoop fs -mkdir pur
hadoop fs -put ../../Input_Data/purchases.txt pur/

hadoop fs -rm -r pur_p1
time hs P1_Mapper.py P1_Reducer.py pur pur_p1
hadoop fs -get pur_p1/part* pur_p1.tsv

hadoop fs -rm -r pur_p1q1
time hs P1Q1_Mapper.py P1Q1_Reducer.py pur pur_p1q1
hadoop fs -get pur_p1q1/part* pur_p1q1.tsv

hadoop fs -rm -r pur_p1q2
time hs P1Q2_Mapper.py P1Q2_Reducer.py pur pur_p1q2
hadoop fs -get pur_p1q2/part* pur_p1q2.tsv

hadoop fs -rm -r pur_p1q3
time hs P1Q3_Mapper.py P1Q3_Reducer.py pur pur_p1q3
hadoop fs -get pur_p1q3/part* pur_p1q3.tsv
