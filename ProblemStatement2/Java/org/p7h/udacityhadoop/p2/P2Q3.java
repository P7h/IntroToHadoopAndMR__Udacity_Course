package org.p7h.udacityhadoop.p2;

import java.io.IOException;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableComparable;
import java.nio.ByteBuffer;

/**
 * Find the most popular file on the Web site. In other words, the file which had the most hits.
 * Your Reducer should just write out the name of the file and number of hits into HDFS.
 * a. Full path to the most popular file: --------
 * b. Number of hits to that file: --------
 */

public final class P2Q3 {
	private final static IntWritable ONE = new IntWritable(1);

	public final static void main(final String[] args) throws Exception {
		final Configuration conf = new Configuration();

		final Job job = new Job(conf, "P2Q3");
		job.setJarByClass(P2Q3.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(P2Q3Map.class);
		job.setCombinerClass(P2Q3Reduce.class);
		job.setReducerClass(P2Q3Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

	public static final class P2Q3Map extends Mapper<LongWritable, Text, Text, IntWritable> {
		private final Text word = new Text();

		public final void map(final LongWritable key, final Text value, final Context context)
				throws IOException, InterruptedException {
			final String line = value.toString().trim();
			final int firstIndex = line.indexOf("\"");
			final int lastIndex = line.lastIndexOf("\"");
			if (firstIndex > 1 && lastIndex > 2) {
				final String requestString = line.substring(firstIndex + 1, lastIndex);
				final String actualURL = requestString.split(" ")[1];
				if(actualURL.startsWith("http")) {
					final URL url = new URL(actualURL);
					word.set(url.getPath());
				} else {
					word.set(actualURL);
				}
				context.write(word, ONE);
			}
		}
	}

	public static final class P2Q3Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

		public final void reduce(final Text key, final Iterable<IntWritable> values, final Context context)
				throws IOException, InterruptedException {
			int sum = 0;
			for (final IntWritable val : values) {
				sum += val.get();
			}
			context.write(key, new IntWritable(sum));
		}
	}
}