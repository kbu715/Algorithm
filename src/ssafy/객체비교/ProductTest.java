package com.day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ProductTest {

	public static void main(String[] args) {
		Product[] array = new Product[5];
		array[0] = new Product(1, 10000, "Avante");
		array[1] = new Product(5, 30000, "Sonata");
		array[2] = new Product(3, 50000, "Tucson");
		array[3] = new Product(2, 50000, "Santafe");
		array[4] = new Product(7, 10000, "Ionic");

		Arrays.sort(array); // 정렬

		for (Product product : array) {
			System.out.println(product);
		}

		System.out.println("---------------------------------------");

		// 가격 기준으로 정렬
		Arrays.sort(array, new ProductPriceComparator());

		for (Product product : array) {
			System.out.println(product);
		}

		System.out.println("---------------------------------------");
		// 무명클래스 사용해서 많이 쓴다
		Arrays.sort(array, new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().compareTo(p2.getName()); // 이름으로 오름차순
			}
		});

		for (Product product : array) {
			System.out.println(product);
		}

		System.out.println("---------------------------------------");

		Arrays.sort(array, (p1, p2) -> {
			Product a = (Product) p1;
			Product b = (Product) p2;
			return b.getName().compareTo(a.getName());
		});

		for (Product product : array) {
			System.out.println(product);
		}

		// array 말고 ArrayList, LinkedList 같은 list 종류에 들어 있을 때는
		// Collections.sort(list);

	}

}
