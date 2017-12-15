package eu.burbach.procedureworld.server;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Sweeper s= new Sweeper();
		s.start();
		
		String str= "";
		boolean cont= true;
		while (cont) {
			byte[] i= new byte[100];
			try {
				System.in.read(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			str= new String(i);
			str= str.replace("\n", "").replace("\0","");
			if (str.length()>0)
				s.put(str);
			cont= !str.equalsIgnoreCase("exit");
			str= s.poll();
			if (str!=null)
				System.out.println(str);
		}
		s.ende();
	}
}
