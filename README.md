# NoteTaker

A web-based note-taking application built with **JSP, Java Servlets and MySQL**. Users can sign up, log in, write notes, edit or delete them, upload PDF documents, and send feedback.

## Live Demo

**https://rimeeawasthi01.github.io/notetaker/**

> This is a **static preview** hosted on GitHub Pages, so you can click through every page and see the interface. Nothing is saved, and login, upload, update and delete are simulated with sample data. The full version runs on a Java server (Apache Tomcat) with a MySQL database, as described below.

## Features

- User registration and login
- Add notes with a title and content
- View all notes with their dates
- Update and delete notes
- Upload PDF documents and attach files
- Download and delete uploaded PDFs
- Feedback form
- Responsive layout using Bootstrap

## Tech Stack

| Layer | Technology |
|-------|------------|
| Frontend | HTML, CSS, Bootstrap 3, Font Awesome |
| Backend | JSP, Java Servlets |
| Database | MySQL (via JDBC) |
| Server | Apache Tomcat |

## Project Structure

```
noteTaker/
├── index.jsp            # Home page
├── Login.jsp            # Sign in
├── register.jsp         # Sign up
├── Add_Note.jsp         # Add a note / upload a document
├── Your_Notes.jsp       # View all notes
├── edit.jsp             # Update a note
├── Your_PDF.jsp         # View uploaded PDFs
├── Feedback.jsp         # Feedback form
├── Help.jsp
├── About_Us.jsp         # About the project and team
├── web.xml              # Servlet configuration
├── java/                # Servlets (login, reg, Insert_Content, Update,
│                        #   Delete, Upload, Done, DeletePDFServlet,
│                        #   FeedbackServlet, Go)
├── css_style/           # Stylesheets
├── images/              # Images
└── *.html               # Static demo pages used by GitHub Pages
```

## Run the Full Project Locally

### Requirements

- JDK 8 or later
- Apache Tomcat 9 or later
- MySQL Server
- MySQL Connector/J (JDBC driver)
- An IDE such as Eclipse (recommended) or IntelliJ

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/RimeeAwasthi01/notetaker.git
   ```
2. **Create the database** in MySQL named `notetaker`, with the tables the project uses (for example `notes` and `filename`, plus the tables for users and feedback).
3. **Set your own database credentials** in the JSP and servlet files that connect to MySQL. Use your own MySQL username and password, and do not commit real passwords to GitHub.
4. **Create a Dynamic Web Project** in Eclipse, then copy the JSP files, `css_style/`, `images/` and `web.xml` into the web content folder, and the servlets from `java/` into the `src` folder.
5. **Add the MySQL Connector/J JAR** to the project's `WEB-INF/lib` folder.
6. **Run on Tomcat** and open `http://localhost:8080/<project-name>/index.jsp`.

## Screenshots

<img width="1269" height="560" alt="ContentUploadPage" src="https://github.com/user-attachments/assets/e093d257-17f1-40eb-9703-d9c4b0aeb5dd" />


## Team

| Name | GitHub |
|------|--------|
| Yashit Tripathi | [@YashitTripathi](https://github.com/YashitTripathi) |
| Rimee Awasthi | [@RimeeAwasthi01](https://github.com/RimeeAwasthi01) |
| Antara Pandey | 

## Note

This project was built as a college project.
