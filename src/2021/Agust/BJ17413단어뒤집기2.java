package Agust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ17413단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = in.readLine();
		Stack<Character> st = new Stack<>();
		boolean tag = false;
		for (int i = 0; i < str.length(); i++) {
			if(tag) {
				bw.write(str.charAt(i));
				if(str.charAt(i) == '>') tag = false;
				
			} else {
				if(str.charAt(i) == '<') {
					if(!st.isEmpty()) {
						while(!st.isEmpty()) {
							bw.write(st.pop());
						}
					}
					bw.write(str.charAt(i));
					tag = true;
					continue;
				}else if(str.charAt(i) == ' ') {
					while(!st.isEmpty()) {
						bw.write(st.pop());
					}
					bw.write(str.charAt(i));
				} else {
					st.add(str.charAt(i));
				}
			}
			
		}
		if(!st.isEmpty()) {
			while(!st.isEmpty()) {
				bw.write(st.pop());
			}
		}
		bw.flush();
	}

}
