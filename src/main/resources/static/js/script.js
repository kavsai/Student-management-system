
// ====================== STUDENT API ======================
const STUDENT_API = "http://localhost:8080/students";

function addStudent() {
    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value,
        course: document.getElementById("course").value,
        year: document.getElementById("year").value
    };

    fetch(STUDENT_API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    })
        .then(() => {
            alert("Student Added!");
            getStudents();
        });
}

function getStudents() {
    fetch(STUDENT_API)
        .then(res => res.json())
        .then(data => {
            let output = "";

            data.forEach(s => {
                output += `
                <div class="card">
                    <h3>${s.name}</h3>
                    <p>${s.email}</p>
                    <p>${s.phone}</p>
                    <p>${s.course}</p>
                    <p>Year: ${s.year}</p>
                </div>
            `;
            });

            const el = document.getElementById("studentList");
            if (el) el.innerHTML = output;
        });
}


// ====================== COURSE API ======================
const COURSE_API = "http://localhost:8080/courses";

function addCourse() {
    const course = {
        courseName: document.getElementById("courseName").value,
        courseCode: document.getElementById("courseCode").value,
        credits: document.getElementById("credits").value
    };

    fetch(COURSE_API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(course)
    })
        .then(() => {
            alert("Course Added!");
            getCourses();
        });
}

function getCourses() {
    fetch(COURSE_API)
        .then(res => res.json())
        .then(data => {
            let output = "";

            data.forEach(c => {
                output += `
                <div class="card">
                    <h3>${c.courseName}</h3>
                    <p>${c.courseCode}</p>
                    <p>Credits: ${c.credits}</p>
                </div>
            `;
            });

            const el = document.getElementById("courseList");
            if (el) el.innerHTML = output;
        });
}


// ====================== ATTENDANCE API ======================
const ATTENDANCE_API = "http://localhost:8080/attendance";

function addAttendance() {
    const attendance = {
        studentId: document.getElementById("studentId").value,
        attendanceDate: document.getElementById("attendanceDate").value,
        status: document.getElementById("status").value
    };

    fetch(ATTENDANCE_API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(attendance)
    })
        .then(() => {
            alert("Attendance Saved!");
            getAttendance();
        });
}

function getAttendance() {
    fetch(ATTENDANCE_API)
        .then(res => res.json())
        .then(data => {
            let output = "";

            data.forEach(a => {
                output += `
                <div class="card">
                    <h3>Student ID: ${a.studentId}</h3>
                    <p>Date: ${a.attendanceDate}</p>
                    <p>Status: ${a.status}</p>
                </div>
            `;
            });

            const el = document.getElementById("attendanceList");
            if (el) el.innerHTML = output;
        });
}


// ====================== MARKS API ======================
const MARKS_API = "http://localhost:8080/marks";

function addMarks() {
    const mark = {
        studentId: document.getElementById("marksStudentId").value,
        subject: document.getElementById("subject").value,
        marks: document.getElementById("marks").value
    };

    fetch(MARKS_API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(mark)
    })
        .then(() => {
            alert("Marks Saved!");
            getMarks();
        });
}

function getMarks() {
    fetch(MARKS_API)
        .then(res => res.json())
        .then(data => {
            let output = "";

            data.forEach(m => {
                output += `
                <div class="card">
                    <h3>Student ID: ${m.studentId}</h3>
                    <p>Subject: ${m.subject}</p>
                    <p>Marks: ${m.marks}</p>
                </div>
            `;
            });

            const el = document.getElementById("marksList");
            if (el) el.innerHTML = output;
        });
}


// ====================== DASHBOARD API ======================
const DASHBOARD_API = "http://localhost:8080/dashboard";

function loadDashboard() {
    fetch(DASHBOARD_API)
        .then(res => res.json())
        .then(data => {
            document.getElementById("totalStudents").innerText = data.totalStudents;
            document.getElementById("totalCourses").innerText = data.totalCourses;
            document.getElementById("totalAttendance").innerText = data.totalAttendance;
            document.getElementById("totalMarks").innerText = data.totalMarks;
        });
}


// ====================== AUTO LOAD ======================
window.onload = function () {
    getStudents();
    getCourses();
    getAttendance();
    getMarks();
    loadDashboard();
};