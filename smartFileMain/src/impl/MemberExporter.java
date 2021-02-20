package impl;

import java.io.File;
import java.util.List;

public interface MemberExporter {

	void exportMembers(List<Member> members, File outputFile);

}
