package org.p7h.udacityhadoop.p2;

import java.io.IOException;

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

/**
 * Write a MapReduce program which will display the number of hits for each different file on the Web site.
 * a. How many hits were made to the page: /assets/js/the-associates.js
 */

public final class P2Q1 {
	private final static IntWritable ONE = new IntWritable(1);

	public final static void main(final String[] args) throws Exception {
		final Configuration conf = new Configuration();

		final Job job = new Job(conf, "P2Q1");
		job.setJarByClass(P2Q1.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(P2Q1Map.class);
		job.setCombinerClass(P2Q1Reduce.class);
		job.setReducerClass(P2Q1Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

	public static final class P2Q1Map extends Mapper<LongWritable, Text, Text, IntWritable> {
		private final Text word = new Text();

		public final void map(final LongWritable key, final Text value, final Context context)
				throws IOException, InterruptedException {
			final String line = value.toString();
			final String[] data = line.trim().split("GET ");
			if (data.length > 1) {
				final String docname = data[1].split(" ")[0];
				word.set(docname);
				context.write(word, ONE);
			}
		}
	}

	public static final class P2Q1Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

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