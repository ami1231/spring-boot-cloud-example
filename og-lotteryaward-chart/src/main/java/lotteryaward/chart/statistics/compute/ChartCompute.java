package lotteryaward.chart.statistics.compute;

public interface ChartCompute<T,V> {
	
	public V compute(T value);
	
}
