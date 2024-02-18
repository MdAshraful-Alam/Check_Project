package edu.colostate.cs415.model;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {
	@Test
	public void test() {
		assert (true);
	}

	@Test
	void testEquals() {
		Worker worker1 = new Worker("John", new HashSet<>(), 50000);
		Worker worker2 = new Worker("John", new HashSet<>(), 50000);
		Worker worker3 = new Worker("Alice", new HashSet<>(), 60000);

		assertTrue(worker1.equals(worker2), "Equal objects should return true");
		assertFalse(worker1.equals(worker3), "Different objects should return false");
	}

	@Test
	void testHashCode() {
		Worker worker1 = new Worker("John", new HashSet<>(), 50000);
		Worker worker2 = new Worker("John", new HashSet<>(), 50000);

		assertEquals(worker1.hashCode(), worker2.hashCode(), "Hash codes should be equal for equal objects");
	}

	@Test
	void testToString() {
		Worker worker = new Worker("Bob", new HashSet<>(), 70000);
		String expectedString = "Worker{name='Bob', salary=70000.0, projects=[], qualifications=[]}";
		assertEquals(expectedString, worker.toString(), "toString method should return expected string");
	}

	@Test
	void testGetSalary() {
		Worker worker = new Worker("Alice", new HashSet<>(), 60000);
		assertEquals(60000, worker.getSalary(), "getSalary should return correct value");
	}

	@Test
	void testSetSalary() {
		Worker worker = new Worker("Bob", new HashSet<>(), 70000);
		worker.setSalary(75000);
		assertEquals(75000, worker.getSalary(), "setSalary should update the salary");
	}

	@Test
	void testGetName() {
		Worker worker = new Worker("Charlie", new HashSet<>(), 80000);
		assertEquals("Charlie", worker.getName(), "getName should return correct value");
	}

	@Test
	void testGetQualifications() {
		Qualification qualification = new Qualification("Java");
		Worker worker = new Worker("David", Set.of(qualification), 90000);

		assertEquals(Set.of(qualification), worker.getQualifications(), "getQualifications should return correct value");
	}

	@Test
	void testAddQualification() {
		Qualification qualification = new Qualification("Python");
		Worker worker = new Worker("Eva", new HashSet<>(), 100000);

		worker.addQualification(qualification);
		assertTrue(worker.getQualifications().contains(qualification), "addQualification should add the qualification");
	}

	@Test
	void testGetProjects() {
		Qualification qualification = new Qualification("Java");
		Project project = new Project("ProjectA", Set.of(qualification), ProjectSize.SMALL);
		Worker worker = new Worker("Frank", new HashSet<>(), 110000);

		worker.addProject(project);
		assertEquals(Set.of(project), worker.getProjects(), "getProjects should return correct value");
	}

	@Test
	void testAddProject() {
		Qualification qualification = new Qualification("Java");
		Project project = new Project("ProjectA", Set.of(qualification), ProjectSize.SMALL);
		Worker worker = new Worker("Grace", new HashSet<>(), 120000);

		worker.addProject(project);
		assertTrue(worker.getProjects().contains(project), "addProject should add the project");
	}

	@Test
	void testRemoveProject() {
		Qualification qualification = new Qualification("Java");
		Project project = new Project("ProjectA", Set.of(qualification), ProjectSize.SMALL);
		Worker worker = new Worker("Harry", new HashSet<>(), 130000);

		worker.addProject(project);
		worker.removeProject(project);
		assertFalse(worker.getProjects().contains(project), "removeProject should remove the project");
	}

	@Test
	void testGetWorkload() {
		Worker worker = new Worker("Ivy", new HashSet<>(), 140000);
		Qualification qualification = new Qualification("Java");
		Project project1 = new Project("ProjectD",Set.of(qualification), ProjectSize.BIG);
		Project project2 = new Project("ProjectE",Set.of(qualification), ProjectSize.MEDIUM);
		Project project3 = new Project("ProjectA", Set.of(qualification), ProjectSize.SMALL);

		worker.addProject(project1);
		worker.addProject(project2);
		worker.addProject(project3);

		assertEquals(7, worker.getWorkload(), "getWorkload should return correct value");
	}
}
