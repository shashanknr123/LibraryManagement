// Function to handle adding a new book
document.getElementById('addBookForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const bookName = document.getElementById('newBookName').value;
    const availableBooks = document.getElementById('newAvailableBooks').value;

    fetch('http://localhost:8080/addBook', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ bookname: bookName, available: parseInt(availableBooks) })
    })
    .then(response => response.json())
    .then(data => {
        alert('Book added successfully!');
        document.getElementById('addBookForm').reset();
    })
    .catch(error => console.error('Error adding book:', error));
});

// Function to handle borrowing a book
document.getElementById('borrowBookForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const bookId = document.getElementById('borrowBookId').value;

    fetch(`http://localhost:8080/borrow/${bookId}`, {
        method: 'POST',
    })
    .then(response => {
        if (response.ok) {
            alert('Book borrowed successfully!');
            document.getElementById('borrowBookForm').reset();
        } else {
            alert('Error borrowing book. It may not be available.');
        }
    })
    .catch(error => console.error('Error borrowing book:', error));
});

// Function to handle returning a book
document.getElementById('returnBookForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const bookId = document.getElementById('returnBookId').value;

    fetch(`http://localhost:8080/return/${bookId}`, {
        method: 'POST',
    })
    .then(response => {
        if (response.ok) {
            alert('Book returned successfully!');
            document.getElementById('returnBookForm').reset();
        } else {
            alert('Error returning book.');
        }
    })
    .catch(error => console.error('Error returning book:', error));
});

// Function to handle updating available books
document.getElementById('updateBookForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const bookId = document.getElementById('updateBookId').value;
    const newAvailableBooks = document.getElementById('updateAvailableBooks').value;

    fetch(`http://localhost:8080/update/${bookId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ available: parseInt(newAvailableBooks) })
    })
    .then(response => {
        if (response.ok) {
            alert('Available books number updated successfully!');
            document.getElementById('updateBookForm').reset();
        } else {
            alert('Error updating available books number.');
        }
    })
    .catch(error => console.error('Error updating available books:', error));
});

// Function to view inventory
document.getElementById('viewInventoryButton').addEventListener('click', function() {
    fetch('http://localhost:8080/getBookDetails')
    .then(response => response.json())
    .then(data => {
        const inventoryList = document.getElementById('inventoryList');
        inventoryList.innerHTML = '';
        data.forEach(book => {
            const bookInfo = document.createElement('div');
            bookInfo.textContent = `ID: ${book.bookid}, Name: ${book.bookname}, Available: ${book.available}`;
            inventoryList.appendChild(bookInfo);
        });
    })
    .catch(error => console.error('Error fetching inventory:', error));
});
// Function to view inventory
document.getElementById('viewBorrowedButton').addEventListener('click', function() {
    fetch('http://localhost:8080/borrowedBooks')
    .then(response => response.json())
    .then(data => {
        const inventoryList = document.getElementById('inventoryList');
        inventoryList.innerHTML = '';
        data.forEach(book => {
            const bookInfo = document.createElement('div');
            bookInfo.textContent = `ID: ${book.bookid}, Name: ${book.bookname}, Borrowed: ${book.borrowedNumber}`;
            inventoryList.appendChild(bookInfo);
        });
    })
    .catch(error => console.error('Error fetching inventory:', error));
});