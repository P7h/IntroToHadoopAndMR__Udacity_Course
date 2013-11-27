cd /home/training/udacity_training/code/P2

hadoop fs -rm -r acc_p2q1
hadoop fs -rm -r acc_p2q2
hadoop fs -rm -r acc_p2q3

export CLASSPATH="/usr/lib/hadoop/*":"/usr/lib/hadoop/lib/*":"/usr/lib/hadoop-0.20-mapreduce/*":"/usr/lib/hadoop-0.20-mapreduce/lib/*":"/usr/lib/hadoop-hdfs/*":"/usr/lib/hadoop-hdfs/lib/*":"/usr/lib/hadoop-mapreduce/*":"/usr/lib/hadoop-mapreduce/lib/*":"/usr/lib/hadoop-yarn/*":"/usr/lib/hadoop-yarn/lib/*":.

hadoop fs -rm -r acc_p2q1
mv _org org
rm -rf /home/training/udacity_training/code/P2/org/p7h/udacityhadoop/p2/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p2/*.java
jar cvf acc.jar org
mv org _org
time hadoop jar acc.jar org.p7h.udacityhadoop.p2.P2Q1 acc acc_p2q1
hadoop fs -get acc_p2q1/part-r-00000 acc_p2q1.tsv

hadoop fs -rm -r acc_p2q2
mv _org org
rm -rf /home/training/udacity_training/code/P2/org/p7h/udacityhadoop/p2/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p2/*.java
jar cvf acc.jar org
mv org _org
time hadoop jar acc.jar org.p7h.udacityhadoop.p2.P2Q2 acc acc_p2q2
hadoop fs -get acc_p2q2/part-r-00000 acc_p2q2.tsv

hadoop fs -rm -r acc_p2q3
mv _org org
rm -rf /home/training/udacity_training/code/P2/org/p7h/udacityhadoop/p2/*.class
javac -classpath $CLASSPATH org/p7h/udacityhadoop/p2/*.java
jar cvf acc.jar org
mv org _org
time hadoop jar acc.jar org.p7h.udacityhadoop.p2.P2Q3 acc acc_p2q3
hadoop fs -get acc_p2q3/part-r-00000 acc_p2q3.tsv

