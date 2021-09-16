package Sep;
/*******************************************************************************
 * BaekJoon 1918 번 
 * 
 * 예시 input 
 * A*(B+C)
 * 결과 값 
 * ABC+*
 */
import java.util.Scanner;
import java.util.Stack;

public class BJ1918_후위표기식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < str.length ; i++) {
			if( str[i] == '+' || str[i] == '-' || str[i] == '*' ||str[i] == '/' ) { // 연산자 라면 
				while(!st.isEmpty() && order(st.peek()) <= order(str[i])) { // 우선순위가 전의 연산자보다 낮을때 까지 
					sb.append(st.pop()); // 그 전의 연산자들을 입력 
				}
				st.add(str[i]); // stack에 현재 연산자 삽입 
				
			} else if(str[i] == '(') { // 괄호가 열리면 
				st.add(str[i]); // stack에 넣어두고 
			}
			else if (str[i] == ')') { // 괄호가 닫히면 
				while (!st.isEmpty() && st.peek() != '(') { // 열린 괄호가 나올 때 까지 
					sb.append(st.pop()); // 연산자 입력 
				}
				if (st.peek() == '(') st.pop(); // 열린 괄호 소거 
			}  else {
				sb.append(str[i]); // 피연산자일 경우 입력 
			}
			
		}
		
		while(!st.isEmpty()) { // stack에 남아있는 연산자들 처리 
			sb.append(st.pop());
		}
		System.out.println(sb);
		sc.close();
	}
	
	static int order(char c) { // 우선순위가 높은 연산자일 수록 낮은 숫자 반환 
		if(c == '*' || c == '/') return 1;
		else if (c == '+' || c == '-') return 2;
		else return 3;
	}

}
