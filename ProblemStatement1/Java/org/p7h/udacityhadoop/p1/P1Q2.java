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
 * Find the monetary value for the highest individual sale for each separate store.
 * Format of each line is:
 * date\ttime\tstore name\titem description\tcost\tmethod of payment
 */

public final class P1Q2 {

	public final static void main(final String[] args) throws Exception {
		final Configuration conf = new Configuration();

		final Job job = new Job(conf, "P1Q2");
		job.setJarByClass(P1Q2.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);

		job.setMapperClass(P1Q2Map.class);
		job.setCombinerClass(P1Q2Reduce.class);
		job.setReducerClass(P1Q2Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

	public static final class P1Q2Map extends Mapper<LongWritable, Text, Text, DoubleWritable> {
		private final Text word = new Text();

		public final void map(final LongWritable key, final Text value, final Context context)
				throws IOException, InterruptedException {
			final String line = value.toString();
			final String[] data = line.trim().split("\t");
			if (data.length == 6) {
				final String product = data[2];
				final double sales = Double.parseDouble(data[4]);
				word.set(product);
				context.write(word, new DoubleWritable(sales));
			}
		}
	}

	public static final class P1Q2Reduce extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

		public final void reduce(final Text key, final Iterable<DoubleWritable> values, final Context context)
				throws IOException, InterruptedException {
			double highestSale = 0.0;
			double currentSale;
			for (DoubleWritable val : values) {
				currentSale = val.get();
				if (highestSale < currentSale) {
					highestSale = currentSale;
				}
			}
			context.write(key, new DoubleWritable(highestSale));
		}
	}
}