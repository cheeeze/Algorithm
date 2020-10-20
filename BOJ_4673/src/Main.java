/*
 * BOJ #4673 셀프 넘버
 * 시작일 : 2020-10-20
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		boolean[] num = new boolean[10001];
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10000;i++){
			if(!num[i]){
				sb.append(i+"\n");
			}

			int sum = i;
			int temp = i;
			int ten = 10;
			while(temp>0){
				sum += temp%ten;
				temp /= ten;
			}

			if(sum>10000){
				continue;
			}
			num[sum] = true;
		}
		System.out.println(sb.toString());
		
	}

}
