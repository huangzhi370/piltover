package com.piltover.report.dto;

public class PageDto {
		private Integer pageSize=10;
		
		private Integer pageNum=1;

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

		public Integer getPageNum() {
			return pageNum;
		}

		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
}
