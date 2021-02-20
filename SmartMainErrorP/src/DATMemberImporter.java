

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DATMemberImporter implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) {
		// TODO Auto-generated method stub
		ArrayList <Member> v = new ArrayList<>();
		Scanner sc;
		try{
			sc = new Scanner(inputFile);
			while(sc.hasNextLine()) {
				try{
					String currentLine = sc.nextLine();
				//System.out.println(currentLine.length());
				if(currentLine.trim().length()>0) {
					Member memberO = new Member(currentLine);
					
					v.add(memberO);
					
				}
				}catch(Exception e) {
					e.printStackTrace();
					
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println(" Imported" + v.size()+ " members");
		
		
		return v;
	}


	



}
