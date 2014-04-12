hadoop fs -rm -r pur_p1
hadoop fs -rm -r pur_p1q1
hadoop fs -rm -r pur_p1q2
hadoop fs -rm -r pur_p1q3

cd /home/training/udacity_training/code/P1/

export CLASSPATH="/usr/lib/hadoop/*":"/usr/lib/hadoop/lib/*":"/usr/lib/hadoop-0.20-mapreduce/*":"/usr/lib/hadoop-0.20-mapreduce/lib/*":"/usr/lib/hadoop-hdfs/*":"/usr/lib/hadoop-hdfs/lib/*":"/usr/lib/hadoop-mapreduce/*":"/usr/lib/hadoop-mapreduce/lib/*":"/usr/lib/hadoop-yarn/*":"/usr/lib/hadoop-yarn/lib/*":.

hadoop fs -rm -r pur_p1
mv _org org
rm -rf /home/training/udacity_training/code/P1/org/p7h/udacityhadoop/p1/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p1/*.java
jar cvf pur.jar org
mv org _org
time hadoop jar pur.jar org.p7h.udacityhadoop.p1.P1 pur pur_p1
hadoop fs -get pur_p1/part-r-00000 pur_p1.tsv

hadoop fs -rm -r pur_p1q1
mv _org org
rm -rf /home/training/udacity_training/code/P1/org/p7h/udacityhadoop/p1/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p1/*.java
jar cvf pur.jar org
mv org _org
time hadoop jar pur.jar org.p7h.udacityhadoop.p1.P1Q1 pur pur_p1q1
hadoop fs -get pur_p1q1/part-r-00000 pur_p1q1.tsv

hadoop fs -rm -r pur_p1q2
mv _org org
rm -rf /home/training/udacity_training/code/P1/org/p7h/udacityhadoop/p1/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p1/*.java
jar cvf pur.jar org
mv org _org
time hadoop jar pur.jar org.p7h.udacityhadoop.p1.P1Q2 pur pur_p1q2
hadoop fs -get pur_p1q2/part-r-00000 pur_p1q2.tsv

hadoop fs -rm -r pur_p1q3
mv _org org
rm -rf /home/training/udacity_training/code/P1/org/p7h/udacityhadoop/p1/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p1/*.java
jar cvf pur.jar org
mv org _org
time hadoop jar pur.jar org.p7h.udacityhadoop.p1.P1Q3 pur pur_p1q3
hadoop fs -get pur_p1q3/part-r-00000 pur_p1q3.tsv

#Primes
cd /home/training/udacity_training/code/P1/

export CLASSPATH="/usr/lib/hadoop/*":"/usr/lib/hadoop/lib/*":"/usr/lib/hadoop-0.20-mapreduce/*":"/usr/lib/hadoop-0.20-mapreduce/lib/*":"/usr/lib/hadoop-hdfs/*":"/usr/lib/hadoop-hdfs/lib/*":"/usr/lib/hadoop-mapreduce/*":"/usr/lib/hadoop-mapreduce/lib/*":"/usr/lib/hadoop-yarn/*":"/usr/lib/hadoop-yarn/lib/*":.

hadoop fs -rm -r primes
mv _org org
rm -rf /home/training/udacity_training/code/P1/org/p7h/udacityhadoop/p1/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p1/*.java
jar cvf pur.jar org
mv org _org
time hadoop jar pur.jar org.p7h.udacityhadoop.p1.Primes numbers primes

hadoop fs -cat primes/part-r-*
hadoop fs -get primes/part-r-* .
wc -l part*
tailf part*
