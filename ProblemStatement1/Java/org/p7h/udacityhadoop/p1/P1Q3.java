package org.p7h.udacityhadoop.p1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
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
 * Find the total sales value across all the stores, and the total number of sales. Assume there is only one reducer.
 */
//4138476       1034457953.26

public final class P1Q3 {

	public final static void main(final String[] args) throws Exception {
		final Configuration conf = new Configuration();

		final Job job = new Job(conf, "P1Q3");
		job.setJarByClass(P1Q3.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DoubleWritable.class);

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(DoubleWritable.class);

		job.setMapperClass(P1Q3Map.class);
		//job.setCombinerClass(P1Q3Reduce.class);
		job.setReducerClass(P1Q3Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

	public static final class P1Q3Map extends Mapper<LongWritable, Text, Text, DoubleWritable> {
		private final Text word = new Text();

		public final void map(final LongWritable key, final Text value, final Context context)
				throws IOException, InterruptedException {
			final String line = value.toString();
			final String[] data = line.trim().split("\t");
			if (data.length == 6) {
				final String product = "JustADummyKey";
				final Double sales = Double.parseDouble(data[4]);
				word.set(product);
				context.write(word, new DoubleWritable(sales));
			}
		}
	}

	public static final class P1Q3Reduce extends Reducer<Text, DoubleWritable, IntWritable, DoubleWritable> {

		public final void reduce(final Text key, final Iterable<DoubleWritable> values, final Context context)
				throws IOException, InterruptedException {
			double sum = 0.0;
			int i = 0;
			for (final DoubleWritable val : values) {
				i++;
				sum += val.get();
			}
			context.write(new IntWritable(i), new DoubleWritable(sum));
		}
	}
}