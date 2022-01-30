package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9659_돌게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine());
		
		String ans = (n % 2 == 0) ? "CY" : "SK";
		System.out.println(ans);

	}

}
