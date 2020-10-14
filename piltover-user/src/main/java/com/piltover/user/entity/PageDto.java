package com.piltover.user.entity;


public class PageDto<T> {
		private T dto;
		
		private int pageSize=10;
		
		private int pageNum=1;

		public T getDto() {
			return dto;
		}

		public void setDto(T dto) {
			this.dto = dto;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		
		
}
