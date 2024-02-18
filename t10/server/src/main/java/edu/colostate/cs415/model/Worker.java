package edu.colostate.cs415.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import edu.colostate.cs415.dto.WorkerDTO;

public class Worker {

	public static final int MAX_WORKLOAD = 12;

	private String name;
	private double salary;
	private Set<Project> projects;
	private Set<Qualification> qualifications;

	// Constructor
	public Worker(String name, Set<Qualification> qualifications, double salary) {
		this.name = name;
		this.qualifications = new HashSet<>(qualifications);
		this.salary = salary;
		this.projects = new HashSet<>();
	}

	// equals method
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Worker worker = (Worker) o;
		return Objects.equals(name, worker.name);
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	// toString method


	@Override
	public String toString() {
		return "Worker{" +
				"name='" + name + '\'' +
				", salary=" + salary +
				", projects=" + projects +
				", qualifications=" + qualifications +
				'}';
	}

	// getName method
	public String getName() {
		return name;
	}

	// getSalary method
	public double getSalary() {
		return salary;
	}

	// setSalary method
	public void setSalary(double salary) {
		this.salary = salary;
	}

	// getQualifications method
	public Set<Qualification> getQualifications() {
		return new HashSet<>(qualifications);
	}

	// addQualification method
	public void addQualification(Qualification q) {
		qualifications.add(q);
	}

	// getProjects method
	public Set<Project> getProjects() {
		return new HashSet<>(projects);
	}

	// addProject method
	public void addProject(Project p) {
		projects.add(p);
		p.addWorker(this);
	}

	// removeProject method
	public void removeProject(Project p) {
		projects.remove(p);
		p.removeWorker(this);
	}

	// getWorkload method
	public int getWorkload() {
		int numSmall = 0, numMedium = 0, numBig = 0;
		for (Project project : projects) {
			if (project.getStatus() != ProjectStatus.FINISHED) {
				switch (project.getSize()) {
					case SMALL:
						numSmall++;
						break;
					case MEDIUM:
						numMedium++;
						break;
					case BIG:
						numBig++;
						break;
				}
			}
		}
		return 3 * numBig + 2 * numMedium + numSmall;
	}
	public boolean willOverload(Project project) {
		return false;
	}

	public boolean isAvailable() {
		return false;
	}

	public WorkerDTO toDTO() {
		return null;
	}

}
