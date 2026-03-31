package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class  Member {
	private  int  mno;

	public Member(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}

	public int getMno() {
		return mno;
	}

	
	
}

public class TestClassArrayListSort {

	public static void main(String[] args) {
		
		// ArrayList 는 생성자를 통해 초기값을 설정 : Java 8 이하
		/*
		ArrayList<Member>  mList  = new ArrayList<> (
			Arrays.asList(
				new Member(13),new Member(15),new Member(15),
				new Member(5),new Member(1),new Member(7)
			)
		); */
		
		// ArrayList 는 생성자를 통해 초기값을 설정 : Java 9 이상
		List<Member>  mList  = new ArrayList<> (
			List.of(
				new Member(13),new Member(15),new Member(15),
				new Member(5),new Member(1),new Member(7)
			)
		);
		
		dispList(mList);
		// 오름차순 정렬
		
		Comparator<Member>  compAsc = new Comparator<Member>() {
			
			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno();
			}
		};
		
		Comparator<Member>  compDesc = new Comparator<Member>() {
			
			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}
		};
		
		Collections.sort(mList, compAsc);
		dispList(mList);
		
		Collections.sort(mList, compDesc);
		dispList(mList);
		
		/*
		Collections.sort(mList, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno();
			}
			
		});       */
		
		Collections.sort(mList, (a,b) -> {return b.getMno() - a.getMno();}); 
		dispList(mList);
		
		
		
		
		
	}

	private static void dispList(List<Member> mList) {
		for (Member member : mList) {
			System.out.print(member.getMno() + " ");
		}
		System.out.println();
	}

}
