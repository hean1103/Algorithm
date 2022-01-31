package Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ6597_트리복구 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String[] temp;
		while(true) {
			try {
				str = bf.readLine();
				
				temp = str.split(" ");
			} catch (Exception e) {
				break;
			}
			
			String pre = temp[0];
			String inorder = temp[1];
			
			String abc = "ABC";

			postOrder(pre, inorder);
			System.out.println();
		}
		
	}
	
	static void postOrder(String pre, String in) {
		
		if(pre.length() == 0) return;
		
		char root = pre.charAt(0);
		
		int idx = in.indexOf(root);
		
		postOrder(pre.substring(1, idx+1),in.substring(0, idx));
		postOrder(pre.substring(idx+1), in.substring(idx+1));
		System.out.print(root);
		
	}

}
