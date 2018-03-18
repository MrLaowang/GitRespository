package cn.itcast.usermanage.domain;

import java.util.List;

public class EasyUIResult {

	private Integer status;
	private Integer total;
	private List<?> rows ;// 相当于 rows 每页显示的记录数
	
	public EasyUIResult(Integer status) {
		super();
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public EasyUIResult() {
		super();
	}
	public EasyUIResult(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
}
