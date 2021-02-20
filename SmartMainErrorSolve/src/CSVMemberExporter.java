

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CSVMemberExporter implements MemberExporter {

	private static final String delim = ",";
	private static final Object carriageReturn = "\r\n";

	@Override
	public void exportMembers(List<Member> members, File outputFile) {
		// TODO Auto-generated method stub
		Map<String, Member> map = new LinkedHashMap<String, Member>();
		
		for(Member m: members) {
			//System.out.println(m.getIdNumber());
			map.put(m.getIdNumber(), m);
			System.out.println(map.size());
		}
		System.out.println("exporting"+ map.size()+ "members");
		exportTofile(map, outputFile);
		
	}
	
	private void exportTofile(Map<String, Member> map, File outputFile) {
		try(FileOutputStream fos = new FileOutputStream(outputFile);){
			Iterator<Entry<String, Member>> iter = map.entrySet().iterator();
			
			while(iter.hasNext()) {
				Map.Entry<String, Member> entry = (Map.Entry<String, Member>) iter.next();
				byte[] data = getCSVRepresentation(entry.getValue());
				fos.write(data);
 			}
			fos.flush();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private byte[] getCSVRepresentation(Member member) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(member.getIdNumber());
		sb.append(delim);
		sb.append(member.getLastName());
		sb.append(delim);
		sb.append(member.getFirstName());
		sb.append(delim);
		sb.append(member.getMiddleName());
		sb.append(delim);
		sb.append(member.getAddress());
		sb.append(delim);
		sb.append(member.getCity());
		sb.append(delim);
		sb.append(member.getState());
		sb.append(delim);
		sb.append(member.getZip());
		sb.append(carriageReturn);
		
		return sb.toString().getBytes();
	}

}
