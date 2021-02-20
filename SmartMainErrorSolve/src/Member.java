

import java.io.Serializable;

public class Member implements Serializable{

	private String address;
	private String city;
	private String firstName;
	private String idNumber;
	private String lastName;
	private String middleName;
	private String state;
	private String zip;
	
	private static int[] indexes = {0, 12, 24, 60, 88, 108, 124, 128, 133};
	Member (String currentLine) {
		this.setAddress(getStringAtIndex(currentLine, indexes[3], indexes[4]));
		this.setFirstName(getStringAtIndex(currentLine, indexes[0], indexes[1]));
		this.setLastName(getStringAtIndex(currentLine, indexes[1], indexes[2]));
		this.setMiddleName(getStringAtIndex(currentLine, indexes[2], indexes[3]));
		this.setState(getStringAtIndex(currentLine, indexes[4], indexes[5]));
		this.setIdNumber(getStringAtIndex(currentLine, indexes[7], Math.min(indexes[8], currentLine.length())));
		this.setCity(getStringAtIndex(currentLine, indexes[5], indexes[6]));
		this.setZip(getStringAtIndex(currentLine, indexes[6], indexes[7]));
	}
	
	private String getStringAtIndex(String currentLine, int i, int j) {
		return currentLine.substring(i, j).trim();
		
	}

	public Member(String address, String city, String firstName, String idNumber, String lastName, String middleName,
			String state, String zip, String code) {
		//super();
		this.address = address;
		this.city = city;
		this.firstName = firstName;
		this.idNumber = idNumber;
		this.lastName = lastName;
		this.middleName = middleName;
		this.state = state;
		this.zip = zip;
	}
	

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Member [address=" + address + ", city=" + city + ", firstName=" + firstName + ", idNumber=" + idNumber
				+ ", lastName=" + lastName + ", middleName=" + middleName + ", state=" + state + ", zip=" + zip + "]";
	}
	
	
	
	
}
