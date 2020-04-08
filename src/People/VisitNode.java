package People;

import java.util.Calendar;

public class VisitNode{

	
	public static int visitNumber = 0;
	private Calendar visitDate;
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
		visitDate = Calendar.getInstance();
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
		visitDate = Calendar.getInstance();
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
	
	/**
	 * Gets visit date
	 * @return VisitDate
	 */
	public Calendar getVisitDate() {
		return visitDate;
	}
	
	/**
	 * Sets visit date 
	 * @param VisitDate date for visit
	 */
	public void setVisitDate(Calendar VisitDate) {
		this.visitDate = VisitDate;
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
		return "Visit on " + (getVisitDate().get(2)+1) + "/" +  getVisitDate().get(5) + "/" + getVisitDate().get(1) + " with " + getAssignedDoctor();
	}
}
