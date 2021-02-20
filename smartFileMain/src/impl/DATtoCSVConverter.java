package impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DATtoCSVConverter extends MemberFileConverter implements MemberImporter, MemberExporter{
	
	public static void main(String[] args) throws FileNotFoundException {
//		
		DATtoCSVConverter converter = new DATtoCSVConverter();
		ArrayList <Member> member = (ArrayList<Member>) converter.importMembers(new File("Members.data"));
		converter.exportMembers(member, new File("Members.csv"));
	
		
	}

	@Override
	protected MemberExporter getMemberExporter() {
		// TODO Auto-generated method stub
		return new CSVMemberExporter();
	}

	@Override
	protected MemberImporter getMemberImporter() {
		// TODO Auto-generated method stub
		return new DATMemberImporter();
	}

	@Override
	public List<Member> importMembers(File inputFile) {
		// TODO Auto-generated method stub
		ArrayList <Member> member = new ArrayList<>();
		Scanner scanner;
		try{
			scanner = new Scanner(inputFile);
			while(scanner.hasNextLine()) {
				try{
					String currentLine = scanner.nextLine();
				//System.out.println(currentLine.length());
				if(currentLine.trim().length()>0) {
					Member memberO = new Member(currentLine);
					
					member.add(memberO);
					
				}
				}catch(Exception e) {
					e.printStackTrace();
					
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println(member.size());
		
		for(int i = 0; i< member.size(); i++) {
			System.out.println(member.get(i).toString());
		}
		return member;
	}

	@Override
	public void exportMembers(List<Member> members, File outputFile) {
		// TODO Auto-generated method stub
		
		
			 try(PrintWriter pw = new PrintWriter(outputFile)){
				 members.stream()
				 .map(this::converttoCSV)
				 .forEach(pw::println);
				 
			 }catch(IOException e) {
				 System.out.println("Exception occured while populating data"+ e);
				 
			 }
			
		
		
	}

	 public String converttoCSV(Member data) {
		 
			return data.getIdNumber()+ ","+ data.getLastName()+","+ data.getFirstName()+","+ data.getMiddleName()+","+ data.getAddress()
			+","+ data.getCity()+","+ data.getState()+","+ data.getZip();
					 
			 
		 }
}
