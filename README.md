# MentRappy – Mental Therapy Platform

MentRappy is a small-scale academic project developed across the first and second semesters of a Software Engineering degree. It began as a console-based Java application and was later extended into a desktop GUI application using Java Swing and object-oriented programming concepts.

## Repository structure

```text
MentRappy/
├── console-version/   # First-semester console application
├── swing-version/     # Second-semester Java Swing application
├── .env.example       # Names of optional SMTP environment variables
└── README.md
```

## Versions

### Console version

The initial implementation provides console-based patient and doctor workflows, including registration and login, input validation, and file-based data storage. It also includes email-related functionality for verification and account alerts.

### Swing version

The later implementation introduces a graphical interface and object-oriented structure. It includes patient/doctor registration and login screens, application navigation, contact/support forms, a basic appointment interface, a payment form with input validation (no payment gateway or real payment processing), and a song library with playback and rating functionality.

Some screens and workflows are intentionally basic or incomplete because this was an introductory, small-scale academic project.

## Technologies

- Java
- Java Swing
- Object-oriented programming (classes, inheritance, abstraction, encapsulation)
- Java serialization / file-based storage
- Java Sound API
- Jakarta Mail (optional email functionality)
- Maven

## Requirements

- JDK 19 (or a compatible newer JDK)
- Maven

Each version is a separate Maven project. Open a terminal in the corresponding directory and run:

```bash
mvn clean package
```

To launch the application with Maven, run:

```bash
mvn exec:java
```

The Swing entry point is `com.company.maingui.MainGUI`; the console entry point is `com.company.mentrappy.MentRappy`.

## Optional email configuration

Email functionality is disabled unless SMTP credentials are supplied through environment variables. Set:

- `MENTRAPPY_GMAIL_USERNAME`
- `MENTRAPPY_GMAIL_APP_PASSWORD`
- `MENTRAPPY_SUPPORT_RECIPIENT` (Swing support form)

See `.env.example` for the variable names. Do not commit real credentials, `.env` files, personal data, or generated build output. The Gmail app password previously embedded in the original source has been removed from this cleaned version; revoke that credential in Google Account security settings if it has not already been revoked.

## Academic context

This repository preserves the two stages of the original student project to show the progression from console-based programming to GUI development and object-oriented design. It is presented as an academic prototype, not a production-ready mental-health service.
