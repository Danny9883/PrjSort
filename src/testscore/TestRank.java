package testscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
	// Field
	private  int  num;
	private  int  score;
	private  int  rank;
	
	// Constructor
	public Student(int num, int score) {
		this.num = num;
		this.score = score;
	}

	
	// Getter / Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}


	// toString
	@Override
	public String toString() {
		return "Student [num=" + num + ", score=" + score + ", rank=" + rank + "]";
	}
	
	
	
	
}

public class TestRank {

	public static void main(String[] args) {
		
		List<Student>  sList  = new ArrayList<>();
		sList.add(new Student(1, 100));
		sList.add(new Student(3, 76));
		sList.add(new Student(5, 63));
		sList.add(new Student(4, 88));
		sList.add(new Student(9, 95));
		sList.add(new Student(2, 0));
		sList.add(new Student(11, 45));
		sList.add(new Student(8, 87));
		sList.add(new Student(6, 100));
		sList.add(new Student(7, 76));
		sList.add(new Student(12, 76));
		
		dispList(sList);
		
		// 석차구하기
		// 1. 점수를 기준, 내림차순으로
		Collections.sort(sList, (a,b) -> {return b.getScore()-a.getScore();});
		// 2. 석차부여
		calcRank(sList);
		
		
		
		// 결과
		dispList(sList);
		
	}

	private static void calcRank(List<Student> sList) {
		int i = 1;  
		int beforeSc = -1; 
		int samerank = 1;
		for (Student student : sList) {
			int score = student.getScore();
			if (score==beforeSc) {
				student.setRank(i-samerank);
				samerank++; 
			} else {
				student.setRank(i);
				samerank=1;
			}	
			beforeSc = score;
			i++;
		}
	}

	private static void dispList(List<Student> sList) {
		System.out.println("--------------------------------");
		for (Student student : sList) {
			System.out.println(student);
		}
		System.out.println("--------------------------------");
	}

}
