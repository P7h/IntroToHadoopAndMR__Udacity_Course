package org.p7h.udacityhadoop.p1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
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
 * Instead of breaking the sales down by store, instead give us a sales breakdown by product category across all of our stores.
 */

public final class P1Q1 {

	public final static void main(final String[] args) throws Exception {
		final Configuration conf = new Configuration();

		final Job job = new Job(conf, "P1Q1");
		job.setJarByClass(P1Q1.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);

		job.setMapperClass(P1Q1Map.class);
		job.setCombinerClass(P1Q1Reduce.class);
		job.setReducerClass(P1Q1Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

	public static final class P1Q1Map extends Mapper<LongWritable, Text, Text, DoubleWritable> {
		private final Text word = new Text();

		public final void map(final LongWritable key, final Text value, final Context context)
				throws IOException, InterruptedException {
			final String line = value.toString();
			final String[] data = line.trim().split("\t");
			if (data.length == 6) {
				final String product = data[3];
				final double sales = Double.parseDouble(data[4]);
				word.set(product);
				context.write(word, new DoubleWritable(sales));
			}
		}
	}

	public static final class P1Q1Reduce extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

		public final void reduce(final Text key, final Iterable<DoubleWritable> values, final Context context)
				throws IOException, InterruptedException {
			double sum = 0.0;
			for (final DoubleWritable val : values) {
				sum += val.get();
			}
			context.write(key, new DoubleWritable(sum));
		}
	}
}