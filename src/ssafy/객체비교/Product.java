package com.day8;

public class Product implements Comparable<Product> {

	private int num;
	private int price;
	private String name;

	public Product(int num, int price, String name) {
		this.num = num;
		this.price = price;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 정렬기준이 되는 내용을 가지고 있는 메소드
	@Override
	public int compareTo(Product other) {
		// 1. 번호 기준으로 오름차순
		return this.num - other.num;
		// 2. 가격 기준으로 내림차순
//		return other.price - this.price == 0 ? this.num - other.num : other.price - this.price;
		// 3. 이름 기준으로 오름차순 정렬
//		return this.getName().compareTo(other.getName());
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", price=" + price + ", name=" + name + "]";
	}

}
