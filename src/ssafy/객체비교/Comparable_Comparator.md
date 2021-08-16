## Comparable\<T>

![image](https://user-images.githubusercontent.com/63832678/129515155-c3ecc2fe-8d2b-42cb-9ea9-e993e32d9f7e.png)


---

## Comparator\<T>

![image](https://user-images.githubusercontent.com/63832678/129515329-67b50183-b0f0-416b-9590-14a72c774d38.png)

---

- 둘 다 객체를 비교해서 정렬을 하기 위한 역할
- `Comparable` : 클래스를 설계하면서 클래스 내부에 정렬기준을 정할 때 사용한다.
- `Comparator` : 추가 정렬 기준, 다른 기준으로 정렬 기준을 정할 때 사용한다.

---

![image](https://user-images.githubusercontent.com/63832678/129515493-5b6e2dee-6ac1-4b77-8dcf-36032302f065.png)

---

- 참고사항
		array 말고 ArrayList, LinkedList 같은 list 종류에 들어 있을 때는
	    **Collections.sort(list);**