package cn.itcast.usermanage.domain;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class DatagridResult<T> {

	private long total;
	private List<T> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public DatagridResult(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public DatagridResult() {
		super();
	}
	
	
}
