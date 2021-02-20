

import java.io.File;
import java.io.FileNotFoundException;



public class DATtoCSVConverter extends MemberFileConverter {
	
	public static void main(String[] args) throws FileNotFoundException {
//		
		String inputFile = "Members.data";
		String outputFile = "output.csv";
//		
		DATtoCSVConverter converter = new DATtoCSVConverter();
		converter.convert(new File(inputFile), new File(outputFile));
		System.out.println("Process Complete");
	
		
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




}
