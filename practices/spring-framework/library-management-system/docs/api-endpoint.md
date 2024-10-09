# Library Management System API Endpoints

## 1. Authentication & Authorization

- **POST /api/auth/login**
  - Login a user and return a token.
- **POST /api/auth/register**

  - Register a new member.

- **GET /api/auth/logout**
  - Logout the currently logged-in user.

## 2. Roles Management

- **GET /api/roles**

  - Retrieve a list of all roles.

- **POST /api/roles**
  - Create a new role.

## 3. Members Management

- **GET /api/members**
  - Retrieve a list of all members.
- **GET /api/members/{id}**

  - Retrieve a specific member by ID.

- **POST /api/members**

  - Add a new member.

- **PUT /api/members/{id}**

  - Update an existing member.

- **DELETE /api/members/{id}**
  - Delete a member.

## 4. Books Management

- **GET /api/books**

  - Retrieve a list of all books (with optional filters).

- **GET /api/books/{id}**

  - Retrieve a specific book by ID.

- **POST /api/books**

  - Add a new book.

- **PUT /api/books/{id}**

  - Update an existing book.

- **DELETE /api/books/{id}**
  - Delete a book.

## 5. Loan Management

- **GET /api/loans**

  - Retrieve a list of all loans.

- **GET /api/loans/{id}**

  - Retrieve details of a specific loan by ID.

- **POST /api/loans**

  - Borrow a book (create a new loan).

- **PUT /api/loans/{id}**

  - Return a borrowed book (update the loan).

- **DELETE /api/loans/{id}**
  - Delete a loan record (if needed).

## 6. Reservation Management

- **GET /api/reservations**

  - Retrieve a list of all reservations.

- **GET /api/reservations/{id}**

  - Retrieve details of a specific reservation by ID.

- **POST /api/reservations**

  - Reserve a book.

- **PUT /api/reservations/{id}**

  - Update a reservation.

- **DELETE /api/reservations/{id}**
  - Cancel a reservation.

## 7. Fine Management

- **GET /api/fines**

  - Retrieve a list of all fines.

- **GET /api/fines/{id}**

  - Retrieve details of a specific fine.

- **POST /api/fines**

  - Add a fine (typically when a book is returned late).

- **PUT /api/fines/{id}**

  - Update a fine (e.g., mark it as paid).

- **DELETE /api/fines/{id}**
  - Delete a fine record.

## 8. Reports and Analytics

- **GET /api/reports**

  - Retrieve a list of generated reports.

- **POST /api/reports**

  - Generate a new report (e.g., popular books, overdue books).

- **GET /api/reports/{id}**
  - Retrieve details of a specific report.
