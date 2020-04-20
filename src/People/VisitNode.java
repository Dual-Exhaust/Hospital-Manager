package People;

import java.util.Date;

public class VisitNode{

	
	public static int visitNumber = 0;
	private String visitDate;
	private PatientNode assignedPatient;
	private DoctorNode assignedDoctor;
	private String condition;
	private int idNumber;
	
	/**Create a visit with just the current time
	 * 
	 */
	public VisitNode() {
		visitNumber++;
		idNumber = visitNumber;
		visitDate = new Date().toString();
		assignedPatient = null;
		assignedDoctor = null;
		condition = "";
	}
	
	/**Create a visit with current time and patient/doctor/condition
	 * 
	 * @param p
	 * @param d
	 * @param c
	 */
	public VisitNode(PatientNode p, DoctorNode d, String c) {
		visitNumber++;
		idNumber = visitNumber;
		visitDate = new Date().toString();
		assignedPatient = p;
		assignedDoctor = d;
		condition = c;
	}
	
	/**Returns ID Number
	 * 
	 * @return
	 */
	public int getIDNumber() {
		return idNumber;
	}
	
	/**Sets id number when loading data
	 * 
	 * @param id
	 */
	public void setIDNumber(int id) {
		idNumber = id;
	}
	
	/**
	 * Gets visit date
	 * @return VisitDate
	 */
	public String getVisitDate() {
		return visitDate;
	}
	
	/**
	 * Sets visit date 
	 * @param VisitDate date for visit
	 */
	public void setVisitDate(String s) {
		visitDate = s;
	}
	
	/**
	 * Gets assigned doctor for visit
	 * @return assignedDoctor
	 */
	public DoctorNode getAssignedDoctor() {
		return assignedDoctor;
	}
	
	/**
	 * Sets doctor for visit
	 * @param assignedDoctor doctor for visit
	 */
	public void setAssignedDoctor(DoctorNode assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}
	
	/**
	 * Gets patient for visit
	 * @return assignedPatient
	 */
	public PatientNode getAssignedPatient() {
		return assignedPatient;
	}
	
	/**
	 * Sets patient for visit 
	 * @param assignedPatient patient who has a visit
	 */
	public void setAssignedPatient(PatientNode assignedPatient) {
		this.assignedPatient = assignedPatient;
	}
	
	/**
	 * Formats visit for printout
	 */
	public String toString() {
		return "Visit on " + visitDate + " with " + assignedDoctor;
	}
	
	/**Formats important information in a way that can be loaded in at another time
	 * 
	 * @return
	 */
	public String toCSV() {
		return idNumber + "," + assignedDoctor.getIDNumber() + "," + assignedPatient.getIDNumber() + "," + visitDate;
	}
}
