package People;

import java.util.Calendar;

public class VisitNode extends Person {

	
	private int Visit;
	
	
	private Calendar VisitDate;
	
	
	private PatientNode assignedPatient;
	
	
	private DoctorNode assignedDoctor;
	
	

	/**
	 * Gets visit
	 * @return visit
	 */
	public int getVisit() {
		return Visit;
	}
	
	/**
	 * Gets visit date
	 * @return VisitDate
	 */
	public Calendar getVisitDate() {
		return VisitDate;
	}
	
	/**
	 * Sets visit date 
	 * @param VisitDate date for visit
	 */
	public void setVisitDate(Calendar VisitDate) {
		this.VisitDate = VisitDate;
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
		return "visit on " + (getVisitDate().get(2)+1) + "/" +  getVisitDate().get(5) + "/" + getVisitDate().get(1) + " with " + getAssignedDoctor();
	}
	
	
}
