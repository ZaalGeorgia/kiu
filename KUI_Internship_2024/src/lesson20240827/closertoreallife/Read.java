package lesson20240827.closertoreallife;

import java.util.Random;

public class Read extends Workload {
	
	private static final int DATA_SIZE = 100_000;
	static final byte[] nucleotides = {'A', 'T', 'C', 'G'};
	static final Random r = new Random();

	public Read(int duration) {
		super(duration);
	}

	@Override
	protected String getData() {
		byte[] data = new byte[DATA_SIZE];
		for (int i = 0; i < data.length; i++) {
			data[i] = nucleotides[r.nextInt(nucleotides.length)];
		}
		return new String(data);
	}

}
