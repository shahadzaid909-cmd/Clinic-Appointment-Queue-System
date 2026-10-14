# Clinic Appointment & Queue Management System

**Java · Data Structures · Linked Lists · Queues · Object-Oriented Programming**

A console-based clinic workflow project built around custom linked data structures. The system explores how appointments and patient waiting lists can be managed without relying on a database-backed scheduling service.

---

## The problem

A clinic needs to organize appointment records and serve waiting patients in a predictable order, while avoiding conflicting bookings for the same doctor and time slot.

## Core capabilities

- **Appointment management:** Add, view, and remove appointments.
- **Waiting queue:** Track patients using a linked queue with first-in, first-out (FIFO) behavior.
- **Patient service:** Serve the next waiting patient.
- **Booking validation:** Prevent duplicate doctor bookings at the same time.

## Data structures in focus

| Concept | Role in the project |
| --- | --- |
| Singly linked list | Manage appointment-related records |
| Linked queue | Represent the patient waiting line |
| FIFO processing | Serve patients in queue order |
| Object-oriented design | Separate clinic entities and operations |

## Run locally

**Recommended:** Open the repository as a NetBeans project with a compatible JDK, then run:

```text
project_DS_3c9.Main
```

Alternatively, compile the Java source files with `javac` and launch `project_DS_3c9.Main` with the compiled classes on your classpath.

## Project structure

```text
src/project_DS_3c9/   Java source files
nbproject/             NetBeans project settings
build.xml              Ant build configuration
```

## Engineering takeaways

This project demonstrates practical use of linked structures, queue operations, appointment constraints, and separation of responsibilities in a Java application.

## Implementation notes

The NetBeans entry point was corrected from `dondon.Main` to `project_DS_3c9.Main`. **A complete build and runtime test have not been independently performed**, so compatibility may depend on the local Java and NetBeans setup.

---

*Focused on data structures, predictable workflow, and clear program organization.*
