package Trash;
/*
We are building the back-end for a clinic appointment management system.
The system tracks doctors, appointments, and patient visits.


Definitions:

* A "doctor" has: doctorId, name.
* An "appointment" has: appointmentId, doctorId, patientId,
  durationMinutes, status.
* AppointmentStatus is one of: SCHEDULED, COMPLETED, CANCELLED, NO_SHOW.
* "ClinicManager" manages doctors, appointments, and provides statistics.
* "DoctorVisitSummary" class represents totalVisits, totalMinutes, and busiestVisitType of the doctor.

To begin with, we present you with two tasks:

1-1) Read through and understand the code below. Feel free to run it.

1-2) The test for ClinicManager is not passing due to a bug in the code.
     Make the necessary changes to ClinicManager to fix the bug.


We are extending the platform to track patient visits to doctors.

Each PatientVisit represents one patient's visit to a doctor:
- visitId           : unique identifier for the visit
- patientId         : the patient who visited
- doctorId          : the doctor the patient visited
- startTime         : the start time of the visit, as minutes from
                      the start of the day
- durationMinutes   : how long the visit lasted, in minutes
- visitType         : one of CONSULTATION, FOLLOWUP, EMERGENCY


To implement these changes, we need to add two functions to the ClinicManager class:


2.1) The addPatientVisit function should be used to store a visit.
     If the doctorId on the visit does not refer to a known doctor
     in ClinicManager, the visit should be ignored.


2.2) The getAverageVisitDurationByType function should return a
     dictionary mapping each visit type (CONSULTATION, FOLLOWUP,
     EMERGENCY) to the doctor's average visit duration in minutes for
     that type. Only visit types the doctor has at least one visit
     for should appear in the dictionary. If the doctor has no visits
     at all, return an empty dictionary.


To assist you in testing these new functions, we have provided the
testAddPatientVisit and testGetAverageVisitDurationByType tests.

*/

/*

We want to generate a visit activity summary for each doctor in the system.

For each doctor, the summary captures how busy they are overall and
what kind of visits they handle most often.

We have added a DoctorVisitSummary class to represent this summary:
- totalVisits         : total number of visits for that doctor
- totalMinutes        : sum of all visit durationMinutes for that doctor
- busiestVisitType   : the visit type with the most visits for that
                         doctor. If two visit types are tied, pick the
                         one that comes first alphabetically. If the
                         doctor has no visits, set this to null.

Add one function to the ClinicManager class:

3) The getDoctorVisitSummary function returns a dictionary mapping
   each doctorId to that doctor's DoctorVisitSummary.
   The result should include every doctor in the system, including
   doctors who have no visits. For doctors with no visits, return a
   summary with totalVisits = 0, totalMinutes = 0, and
   busiestVisitType = null.

To assist you in testing this new function, we have provided the
testGetDoctorVisitSummary test.
*/

/*
3 or more NO_SHOW appointments
within any 30-day window (inclusive).




*/

import java.util.*;
import java.util.stream.*;


enum AppointmentStatus {
    SCHEDULED, COMPLETED, CANCELLED, NO_SHOW
}


class Doctor {

    public int doctorId;
    public String name;

    public Doctor(int doctorId, String name) {
        this.doctorId = doctorId;
        this.name = name;
    }
}

class DoctorVisitSummary {
    Integer totalVisits;
    Integer totalMinutes;
    VisitType busiestVisitType;

    DoctorVisitSummary(Integer totalVisits, Integer totalMinutes, VisitType busiestVisitType) {
        this.totalVisits = totalVisits;
        this.totalMinutes = totalMinutes;
        this.busiestVisitType = busiestVisitType;
    }
}


enum VisitType {
    CONSULTATION, FOLLOWUP, EMERGENCY
}


class PatientVisit {

    int visitId;
    int patientId;
    int doctorId;
    int startTime;
    int durationMinutes;
    VisitType visitType;


    PatientVisit(int visitId, int patientId, int doctorId,
                 int startTime, int durationMinutes, VisitType visitType) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.visitType = visitType;

    }

}


class Appointment {

    public int appointmentId;
    public int doctorId;
    public int patientId;
    public int durationMinutes;
    public AppointmentStatus status;


    public Appointment(int appointmentId, int doctorId, int patientId,
                       int durationMinutes, AppointmentStatus status) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.durationMinutes = durationMinutes;
        this.status = status;
    }
}


class AppointmentStats {

    public int totalAppointments;
    public int completedAppointments;
    public double noShowRate;


    public AppointmentStats(int totalAppointments, int completedAppointments, double noShowRate) {
        this.totalAppointments = totalAppointments;
        this.completedAppointments = completedAppointments;
        this.noShowRate = noShowRate;
    }

}


class ClinicManager {

    public Map<Integer, Doctor> doctors;
    public List<Appointment> appointments;
    //added
    public List<PatientVisit> visits;

    public ClinicManager() {

        doctors = new HashMap<>();
        appointments = new ArrayList<>();
        //added
        visits = new ArrayList<>();
    }


    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.doctorId, doctor);
    }


    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }


    public AppointmentStats getAppointmentStatistics() {

        int total = appointments.size();
        int completed = 0;

        for (Appointment a : appointments) {
            if (a.status == AppointmentStatus.COMPLETED) {
                completed++;
            }
        }

        int noShows = 0;

        for (Appointment a : appointments) {
            if (a.status == AppointmentStatus.NO_SHOW) {
                noShows++;
            }
        }


        double noShowRate;

        if (total > 0) {
            noShowRate = (double) noShows / total;
        } else {
            noShowRate = 0.0;
        }
        return new AppointmentStats(total, completed, noShowRate);

    }

    //implemented method 2.1
    public void addPatientVisit(PatientVisit visit){
        if(!doctors.containsKey(visit.doctorId)){
            return;
        }
        visits.add(visit);
    }
    //implemented method 2.2
    public Map<VisitType, Double> getAverageVisitDurationByType(int doctorId){

        Map<VisitType, Double> result = new HashMap<>();
        if(!doctors.containsKey(doctorId)){
            return result;
        }
        Map<VisitType, Integer> totalTime = new HashMap<>();
        Map<VisitType, Integer> count = new HashMap<>();
        for(PatientVisit visit : visits){
            if(visit.doctorId == doctorId){
                totalTime.put(visit.visitType,totalTime.getOrDefault(visit.visitType,0)+visit.durationMinutes);
                count.put(visit.visitType,count.getOrDefault(visit.visitType,0)+1);

            }
        }
        for(VisitType type : totalTime.keySet()){
            result.put(type, (double)totalTime.get(type)/count.get(type));
        }

        return result;
    }




    public Map<Integer, DoctorVisitSummary> getDoctorVisitSummary(){
        Map<Integer, DoctorVisitSummary> result = new HashMap<>();
        for(Integer doctorId : doctors.keySet()){
            int totalVists = 0, totalMin = 0;
            Map<VisitType, Integer> visitCount = new HashMap<>();
            for(PatientVisit visit : visits){
                if(visit.doctorId == doctorId){
                    totalVists++;
                    totalMin += visit.durationMinutes;
                    visitCount.put(visit.visitType,visitCount.getOrDefault(visit.visitType,0)+1);
                }
            }
            VisitType busiest = null;
            if(!visitCount.isEmpty()){
                int max = -1;
                for(VisitType type : VisitType.values()){
                    int curr = visitCount.getOrDefault(type,0);
                    if(curr>max){
                        max = curr;
                        busiest = type;
                    }else if(curr == max && busiest != null && type.name().compareTo(busiest.name())<0){
                        busiest = type;
                    }
                }
            }
            result.put(doctorId,new DoctorVisitSummary(totalVists, totalMin,busiest));

        }
        return result;

    }

}


public class Solution_Clinic {

    public static void main(String[] args) {
        testGetAppointmentStatistics();
        testAddPatientVisit();
        testGetAverageVisitDurationByType();
        testGetDoctorVisitSummary();
        System.out.println("All tests pass!");
    }


    public static void testGetAppointmentStatistics() {

        System.out.println("Running testGetAppointmentStatistics");

        ClinicManager cm = new ClinicManager();


        cm.addAppointment(new Appointment(1, 10, 100, 30, AppointmentStatus.COMPLETED));
        cm.addAppointment(new Appointment(2, 10, 101, 45, AppointmentStatus.COMPLETED));
        cm.addAppointment(new Appointment(3, 10, 102, 30, AppointmentStatus.NO_SHOW));
        cm.addAppointment(new Appointment(4, 10, 103, 60, AppointmentStatus.CANCELLED));
        cm.addAppointment(new Appointment(5, 10, 104, 30, AppointmentStatus.SCHEDULED));

        AppointmentStats stats = cm.getAppointmentStatistics();

        assert stats.totalAppointments == 5 : "totalAppointments should be 5, was " + stats.totalAppointments;
        assert stats.completedAppointments == 2 : "completedAppointments should be 2, was " + stats.completedAppointments;
        assert Math.abs(stats.noShowRate - 0.2) < 1e-4 : "noShowRate should be 0.2, was " + stats.noShowRate;

    }


    static void testAddPatientVisit() {

        System.out.println("Running testAddPatientVisit");
        ClinicManager cm = new ClinicManager();

        cm.addDoctor(new Doctor(1, "dr_smith"));
        cm.addDoctor(new Doctor(2, "dr_jones"));


        cm.addPatientVisit(new PatientVisit(1, 100, 1, 540, 30, VisitType.CONSULTATION));
        cm.addPatientVisit(new PatientVisit(2, 101, 2, 600, 45, VisitType.FOLLOWUP));

        // unknown doctor ignored
        cm.addPatientVisit(new PatientVisit(3, 102, 99, 660, 30, VisitType.EMERGENCY));

    }


    static void testGetAverageVisitDurationByType() {

        System.out.println("Running testGetAverageVisitDurationByType");

        ClinicManager cm = new ClinicManager();

        cm.addDoctor(new Doctor(1, "dr_smith"));
        cm.addDoctor(new Doctor(2, "dr_jones"));


        cm.addPatientVisit(new PatientVisit(1, 100, 1, 540, 30, VisitType.CONSULTATION));
        cm.addPatientVisit(new PatientVisit(2, 101, 1, 600, 50, VisitType.CONSULTATION));
        cm.addPatientVisit(new PatientVisit(3, 102, 1, 660, 20, VisitType.FOLLOWUP));
        cm.addPatientVisit(new PatientVisit(4, 103, 2, 540, 40, VisitType.EMERGENCY));


        Map<VisitType, Double> avg1 = cm.getAverageVisitDurationByType(1);

        assert Math.abs(40.0 - avg1.get(VisitType.CONSULTATION)) < 1e-4 : "Expected 40.0 for CONSULTATION";  // (30+50)/2
        assert Math.abs(20.0 - avg1.get(VisitType.FOLLOWUP)) < 1e-4 : "Expected 20.0 for FOLLOWUP";
        assert !avg1.containsKey(VisitType.EMERGENCY) : "EMERGENCY should not be in avg1";


        Map<VisitType, Double> avg2 = cm.getAverageVisitDurationByType(2);

        assert Math.abs(40.0 - avg2.get(VisitType.EMERGENCY)) < 1e-4 : "Expected 40.0 for EMERGENCY";
        assert !avg2.containsKey(VisitType.CONSULTATION) : "CONSULTATION should not be in avg2";
        assert !avg2.containsKey(VisitType.FOLLOWUP) : "FOLLOWUP should not be in avg2";


        // doctor with no visits
        cm.addDoctor(new Doctor(3, "dr_brown"));
        assert cm.getAverageVisitDurationByType(3).isEmpty() : "Expected empty map for doctor with no visits";
    }

    // Also, add a call to testGetDoctorVisitSummary() in the main method.
    static void testGetDoctorVisitSummary() {
        System.out.println("Running testGetDoctorVisitSummary");
        ClinicManager cm = new ClinicManager();
        for (int did : new int[]{1, 2, 3, 4}) {
            cm.addDoctor(new Doctor(did, "doctor" + did));
        }

        // doctor 1: 4 visits, 125 total minutes
        // CONSULTATION x2, FOLLOWUP x1, EMERGENCY x1
        // busiest = CONSULTATION (2 visits, clear winner)
        cm.addPatientVisit(new PatientVisit(1, 100, 1, 540, 30, VisitType.CONSULTATION));
        cm.addPatientVisit(new PatientVisit(2, 101, 1, 600, 45, VisitType.CONSULTATION));
        cm.addPatientVisit(new PatientVisit(3, 102, 1, 660, 20, VisitType.FOLLOWUP));
        cm.addPatientVisit(new PatientVisit(4, 103, 1, 720, 30, VisitType.EMERGENCY));

        // doctor 2: 2 visits, 90 total minutes
        // FOLLOWUP x1, EMERGENCY x1 — tied
        // tiebreak alphabetically -> EMERGENCY wins (E < F)
        cm.addPatientVisit(new PatientVisit(5, 104, 2, 540, 40, VisitType.FOLLOWUP));
        cm.addPatientVisit(new PatientVisit(6, 105, 2, 600, 50, VisitType.EMERGENCY));

        // doctor 3: no visits -> zeroed summary

        // doctor 4: 2 visits, CONSULTATION x1, FOLLOWUP x1 — tied
        // tiebreak alphabetically -> CONSULTATION wins (C < F)
        cm.addPatientVisit(new PatientVisit(7, 106, 4, 540, 30, VisitType.CONSULTATION));
        cm.addPatientVisit(new PatientVisit(8, 107, 4, 600, 30, VisitType.FOLLOWUP));

        Map<Integer, DoctorVisitSummary> summary = cm.getDoctorVisitSummary();

        // doctor 1
        assert Integer.valueOf(4).equals(summary.get(1).totalVisits) : "doctor1 totalVisits";
        assert Integer.valueOf(125).equals(summary.get(1).totalMinutes) : "doctor1 totalMinutes";
        assert summary.get(1).busiestVisitType == VisitType.CONSULTATION : "doctor1 busiestVisitType";

        // doctor 2 — tiebreak by name -> EMERGENCY wins
        assert Integer.valueOf(2).equals(summary.get(2).totalVisits) : "doctor2 totalVisits";
        assert Integer.valueOf(90).equals(summary.get(2).totalMinutes) : "doctor2 totalMinutes";
        assert summary.get(2).busiestVisitType == VisitType.EMERGENCY : "doctor2 busiestVisitType";

        // doctor 3 — zero visits
        assert Integer.valueOf(0).equals(summary.get(3).totalVisits) : "doctor3 totalVisits";
        assert Integer.valueOf(0).equals(summary.get(3).totalMinutes) : "doctor3 totalMinutes";
        assert summary.get(3).busiestVisitType == null : "doctor3 busiestVisitType";

        // doctor 4 — tiebreak by name -> CONSULTATION wins
        assert Integer.valueOf(2).equals(summary.get(4).totalVisits) : "doctor4 totalVisits";
        assert Integer.valueOf(60).equals(summary.get(4).totalMinutes) : "doctor4 totalMinutes";
        assert summary.get(4).busiestVisitType == VisitType.CONSULTATION : "doctor4 busiestVisitType";
    }
}
