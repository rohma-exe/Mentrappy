# MentRappy – Mental Therapy Platform

A small-scale academic Java project developed across the first and second semesters of a Software Engineering degree. The project began as a console-based application and was later extended into a Java Swing desktop application.

## Project versions

The prepared source package contains both versions in separate folders:

- `console-version/`: first-semester console application with patient and doctor registration/login workflows, validation, file-based storage, and email-related functionality.
- `swing-version/`: second-semester Java Swing application with patient/doctor screens, navigation, contact/support forms, a basic appointment interface, payment-form validation (no payment gateway or real payment processing), and a song library with playback and ratings.

The project demonstrates the progression from introductory Java programming to GUI development and object-oriented design, including classes, inheritance, abstraction, and encapsulation.

## Technologies

Java · Java Swing · Maven · Jakarta Mail · Java Sound API · File-based storage / serialization

## Running the project

Each version is a separate Maven project. From the relevant version directory, run:

```bash
mvn clean package
```

The Swing entry point is `com.company.maingui.MainGUI`; the console entry point is `com.company.mentrappy.MentRappy`.

## Email configuration and security

Email functionality requires SMTP credentials supplied through environment variables; no real credentials are included in the cleaned source package. See its `.env.example` file for the variable names. Never commit real credentials or local `.env` files. If you previously used the Gmail app password embedded in an earlier copy of this project, revoke it in your Google Account.

## Academic scope

MentRappy is presented as an introductory academic prototype, not a production-ready mental-health service. Some workflows are basic or incomplete, and the payment screen does not process real payments.
