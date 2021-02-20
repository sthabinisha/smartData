package impl;

import java.io.File;
import java.util.List;

public abstract class MemberFileConverter {
	protected abstract MemberExporter getMemberExporter();
	protected abstract MemberImporter getMemberImporter();
	public void convert (File inputFile, File outputFile) {
		MemberImporter importer = getMemberImporter();
		MemberExporter exporter = getMemberExporter();
		
		List<Member> members = importer.importMembers(inputFile);
		exporter.exportMembers(members, outputFile);
		
		
	}
	

}
